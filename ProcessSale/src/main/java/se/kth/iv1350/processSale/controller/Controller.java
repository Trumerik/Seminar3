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
     * Creates a new instance of the controller with the specified {@link Printer} class as a parameter.
     * Initilize the external systems and initializes the external systems used for inventory and accounting.
     * 
     * @param printer the printer print the receipt.
     */
    public Controller(ReceiptPrinter printer) {
        this.printer = printer;
        this.inventorySystem = new ExternalInventorySystem();
        this.accountingSystem = new ExternalAccountingSystem();
        this.sale = null;
    }

    /**
     * Starts a new sale by creating a new instance of the {@link Sale} class with the
     * controllers {@link ExternalInventorySystem} field inventorySystem.
     */
    public void startSale() {
        this.sale = new Sale(inventorySystem);
    }
    
    /**
     * Enters an item identifier into the system and returns the current
     * status of the sale after the new item has been processed.
     * 
     * @param identifier The identifier of the item.
     * @return The current sale status as a {@link CurrentSaleStatusDTO}.
     */
    public CurrentSaleStatusDTO entersItemIdentifier(String identifier) {
        return this.sale.requestSaleInformation(identifier);
    }

    /**
     * Ends the sale and returns the total price of the sale.
     * 
     * @return The total price of the sale.
     */
    public float endSale() {
        Receipt receipt = this.sale.getReceipt();
        return receipt.getTotalPrice();
    }

    /**
     * Enters the payment amount and returns the change. Also updates the reciept and
     * external systems as well as prints the receipt.
     * 
     * @param amount The amount of money the customer paid.
     * @return The change.
     */
    public float entersPayment(float amount) {
        this.sale.updateReceiptWithPayment(amount);
        Receipt receipt = this.sale.getReceipt();
        updateExternalSystems(receipt);
        return receipt.getChange();
    }

    private void updateExternalSystems(Receipt receipt){
        this.inventorySystem.updateInventorySystem(receipt);
        this.accountingSystem.sendSaleInformation(receipt);
    }

    /**
     * Prints the receipt.
     */
    public void printReceipt() {
        Receipt receipt = this.sale.getReceipt();
        this.printer.printReceipt(receipt);
    }

}