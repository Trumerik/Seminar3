package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ExternalInventorySystem;
import se.kth.iv1350.processSale.integration.ReceiptPrinter;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.integration.ExternalAccountingSystem;

/**
 * The controller works as a middle-man between the view and the model as well as the
 * external systems. All calls to the model pass through here.
 */
public class Controller {
    private ExternalInventorySystem inventorySystem;
    private ExternalAccountingSystem accountingSystem; 
    private Sale sale;
    private ReceiptPrinter printer;

    /**
     * Creates a new instance of the controller and initilize the external systems.
     * 
     * @param printer The printer that will print the receipt.
     */
    public Controller(ReceiptPrinter printer) {
        this.printer = printer;
        this.inventorySystem = new ExternalInventorySystem();
        this.accountingSystem = new ExternalAccountingSystem();
    }

    /**
     * Starts a new sale by creating a new instance of the {@link Sale} class.
     * The sale object is initilized with the inventorySystem.
     */
    public void startSale() {
        this.sale = new Sale(inventorySystem);
    }
    
    /**
     * Enters an item identifier into the system and returns the current
     * status of the sale.
     * 
     * @param identifier The identifier of the item.
     * @return The current sale status.
     */
    public CurrentSaleStatusDTO entersItemIdentifier(String identifier) {
        return sale.requestSaleInformation(identifier);
    }

    /**
     * Ends the sale and returns the total price of the sale.
     * 
     * @return The total price of the sale.
     */
    public float endSale() {
        Receipt receipt = sale.getReceipt();
        return receipt.getRunningTotal();
    }

    /**
     * Enters the payment amount and returns the change. Also updates the
     * inventory system and sends the sale information to the accounting system
     * as well as prints the receipt.
     * 
     * @param amount The amount of money the customer paid.
     * @return The change.
     */
    public float enterPayment(float amount) {
        sale.updateReceipt(amount);
        Receipt receipt = sale.getReceipt();
        this.inventorySystem.updateInventorySystem(receipt);
        this.accountingSystem.sendSaleInformation(receipt);
        printer.printReceipt(receipt);
        return receipt.getChange();
    }
}


