package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Receipt;

/**
 * The external printer machine that will simply print the receipt.
 */
public class ReceiptPrinter {

    /**
     * Creates a new instance of the receipt printer.
     */
    public ReceiptPrinter(){}

    /**
     * Prints the receipt. But since external systems are not modeled in
     * this seminar it is excluded. Here is an example of how the receipt can be printed.
     * 
     * @param receipt The {@link Receipt} to be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println("====RECEIPT======");
        System.out.println("Paid amount: " + receipt.getAmountPaid());
        System.out.println("Change: " + receipt.getChange());
        System.out.println("Total: " + receipt.getRunningTotal());
        System.out.println("VAT: " + receipt.getVat());
        System.out.println("Items: " + receipt.getItems());
        System.out.println("Quantaties: " + receipt.getQuantities());
        System.out.println("Date & Time: " + receipt.getTimeOfSale());
        System.out.println("====END OF RECEIPT======");
    }
}
