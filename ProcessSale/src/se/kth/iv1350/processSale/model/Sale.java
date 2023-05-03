package se.kth.iv1350.processSale.model;
import java.time.LocalDateTime;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import se.kth.iv1350.processSale.integration.ExternalInventorySystem;
import java.util.HashMap;

/**
 * Sale class represent the sale that is initiated by the cashiere when a customer arrives at the point of sale. 
 *  
 */
public class Sale {
    private LocalDateTime timeOfSale;
    private Receipt receipt;
    private HashMap<String, ItemDescriptionDTO> seenItemsCache; 
    private ExternalInventorySystem inventorySystem;
   
    /**
     * Constructor for the Sale class. Takes in a reference to the external inventory system.
     * Also sets the time of sale, and initializes a receipt of class {@link receipt}. 
     * 
     * @param inventorySystem of type {@link ExternalInventorySystem} is a reference to the external inventory system.
     */
    public Sale(ExternalInventorySystem inventorySystem) {
        setTimeOfSale();
        this.receipt = new Receipt(this.timeOfSale);
        this.inventorySystem = inventorySystem;
        seenItemsCache = new HashMap<String, ItemDescriptionDTO>();
    }

    /**
     * Sets the timeOfSale field in the instance of class {@link Sale}.
     */
    private void setTimeOfSale() {
        this.timeOfSale = LocalDateTime.now();
    }
    
    /**
     * Gets called by the controller for every new item scanned in the sale. Checks if the itemsDescription (of type {@link ItemDescriptionDTO})
     * already exists in the local cache, if not, it will fetch it from the external inventory system ({@link ExternalInventorySystem}).
     * It will then fetch the runningTotal from the receipt, package the runningTotal and the itemsDescription into an object currentSaleStatus of type
     * {@link CurrentSaleStatusDTO} that it then returns.
     * 
     * @param identifier is the identifier of the scanned item. 
     * 
     * @return a currentSaleStatus of type {@link CurrentSaleStatusDTO}, that contains the itemDescription of the item and the runningTotal of the sale.
     */
    public CurrentSaleStatusDTO requestSaleInformation(String identifier) {
        ItemDescriptionDTO itemDescription = retrieveFromCacheIfItemSeenBefore(identifier);
        if (itemDescription == null) {
            itemDescription = inventorySystem.getItemDescription(identifier);
            addItemToCache(identifier, itemDescription);
        }
        receipt.addItemToReceipt(itemDescription);
        CurrentSaleStatusDTO currentSaleStatus = new CurrentSaleStatusDTO(itemDescription, receipt.getRunningTotal());
        return currentSaleStatus;
    }

    /**
     * Checks if an items itemDescritpion, of type {@link ItemDescritpionDTO}, is currently stored in the cache.
     * If so, return that itemDescription. Else return null.
     * 
     * @param identifier is the identifier of the scanned item.
     * 
     * @return the itemDescription if it is found in cache, otherwise return null. 
     * 
     */
    private ItemDescriptionDTO retrieveFromCacheIfItemSeenBefore(String identifier) {
        if (seenItemsCache.containsKey(identifier)) {
            return seenItemsCache.get(identifier);
        }
        return null;
    }
    
    /**
     * Add the identifier and description, of type {@link ItemDescriptionDTO}, of an item to the cache
     * 
     * @param identifier is the identifier of the scanned item
     * @param itemDescription is the description of the scanned item
     */
    private void addItemToCache(String indentifier, ItemDescriptionDTO itemDescription) {
        seenItemsCache.put(indentifier, itemDescription);
    }


    /**
     * Calls updatereceipt in the {@link Receipt} class.
     * 
     * @param payment is the payment provided by the customer. 
     */
    public void updateReceipt(float payment) {
        receipt.updatePayment(payment);
    }

    /**
     * A getter for the receipt field.
     * 
     * @return the receipt stored in the instance of the {@link Sale} class. 
     */
    public Receipt getReceipt() {
        return this.receipt;
    }
}
