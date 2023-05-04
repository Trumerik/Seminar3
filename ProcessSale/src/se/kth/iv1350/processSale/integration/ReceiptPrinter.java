package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.util.PrettyPrinter;

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
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        prettyPrinter.printReceipt(receipt);
    }
}
