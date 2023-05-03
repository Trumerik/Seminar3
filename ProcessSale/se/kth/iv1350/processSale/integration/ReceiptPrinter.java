package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Receipt;

/**
 * The external printer machine that will simply print the reciept.
 */
public class ReceiptPrinter {

    /**
     * Creates a new instance of the receipt printer.
     */
    public ReceiptPrinter(){}

    /**
     * Prints the receipt. But since external systems are not modeled in
     * this seminar it is excluded.
     * 
     * @param receipt The {@link Receipt} to be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println("====RECEIPT======");
        System.out.println(receipt.getAmountPaid());
        System.out.println(receipt.getChange());
        System.out.println(receipt.getRunningTotal());
        System.out.println(receipt.getVat());
        System.out.println(receipt.getItems());
        System.out.println(receipt.getQuantities());
        System.out.println(receipt.getTimeOfSale());
        System.out.println("====END OF RECEIPT======");
    }
}
