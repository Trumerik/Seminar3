package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ExternalInventorySystem;
import se.kth.iv1350.processSale.integration.ReceiptPrinter;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.integration.ExternalAccountingSystem;
import se.kth.iv1350.processSale.integration.DiscountDatabase;

public class Controller {
    private ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
    private ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
    private DiscountDatabase discountDatabase = new DiscountDatabase();
    private Sale sale;
    private ReceiptPrinter printer;

    public Controller(ReceiptPrinter printer) {
        this.printer = printer;
    }

    public void startSale() {
        Sale sale = new Sale(inventorySystem);
    }
    
    public CurrentSaleStatusDTO entersItemIdentifier(String identifier) {
        
        return sale.requestSaleInformation(identifier);
    }

    public float endSale() {
        return sale.getRunningTotal();
    }

    public float enterPayment(float amount) {
        Receipt receipt = sale.getReceipt(amount);
        inventorySystem.updateInventorySystem(receipt);
        accountingSystem.sendSaleInformation(receipt);
        printer.printReceipt(receipt);
        return receipt.getChange();
        
    }

}
