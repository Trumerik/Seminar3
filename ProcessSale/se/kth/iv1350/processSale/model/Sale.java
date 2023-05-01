package se.kth.iv1350.processSale.model;
import java.time.LocalDateTime;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import se.kth.iv1350.processSale.integration.ExternalInventorySystem;

import java.util.HashMap;

public class Sale {
    private float runningTotal;
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
        ItemDescriptionDTO itemDescription = retrieveIfItemSeenBefore(identifier);
        if (itemDescription == null) {
            itemDescription = inventorySystem.getItemDescription(identifier);
        }
        increaseRunningTotal(itemDescription.getPrice());
        receipt.addItemToReceipt(itemDescription);
        CurrentSaleStatusDTO currentSaleStatus = new CurrentSaleStatusDTO(itemDescription, runningTotal);
        return currentSaleStatus;
    }

    private ItemDescriptionDTO retrieveIfItemSeenBefore(String identifier) {
        if (seenItemsCache.containsKey(identifier)) {
            return seenItemsCache.get(identifier);
        }
        return null;
    }

    private void increaseRunningTotal(float price) {
        this.runningTotal += price;
    }

    public float getRunningTotal() {
        return runningTotal;
    }

    public float calculateChange(float payment) {
        float change = payment - runningTotal;
        receipt.updateReceipt(payment, change);
        return change;
    }

    public Receipt getReceipt(float payment) {
        float change = payment - runningTotal;
        receipt.updateReceipt(payment, change);
        return this.receipt;
    }
}
