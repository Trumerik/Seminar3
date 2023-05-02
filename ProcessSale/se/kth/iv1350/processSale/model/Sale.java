package se.kth.iv1350.processSale.model;
import java.time.LocalDateTime;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import se.kth.iv1350.processSale.integration.ExternalInventorySystem;

import java.util.HashMap;

public class Sale {
    private LocalDateTime timeOfSale;
    private Receipt receipt;
    private HashMap<String, ItemDescriptionDTO> seenItemsCache; // if we want to use cache
    private ExternalInventorySystem inventorySystem;
   

    public Sale(ExternalInventorySystem inventorySystem) {
        setTimeOfSale();
        this.receipt = new Receipt(this.timeOfSale);
        this.inventorySystem = inventorySystem;
    }

    private void setTimeOfSale() {
        this.timeOfSale = LocalDateTime.now();
    }
    
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

    private ItemDescriptionDTO retrieveFromCacheIfItemSeenBefore(String identifier) {
        if (seenItemsCache.containsKey(identifier)) {
            return seenItemsCache.get(identifier);
        }
        return null;
    }
    
    private void addItemToCache(String indentifier, ItemDescriptionDTO itemDescription) {
        seenItemsCache.put(indentifier, itemDescription);
    }


    public void updateReciept(float payment) {
        receipt.updateReceipt(payment);
    }

    public Receipt getReceipt() {
        return this.receipt;
    }
}
