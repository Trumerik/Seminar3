package se.kth.iv1350.processSale.util;

import java.util.ArrayList;

import se.kth.iv1350.processSale.model.Item;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;

/**
 * The class PrettyPrinter prints out information from a sample run made in {link View}.
 */
public class PrettyPrinter {

    /**
     * Constructor for the PrettyPrinter class.
     */
    public PrettyPrinter(){}

    /**
     * Prints the current sale information based on the information from the input {@link CurrentSaleStatusDTO} class.
     * 
     * @param info The information to be printed.
     */
    public void printCurrentSaleInformation(CurrentSaleStatusDTO info){   
        System.out.println("- Returned by the controller: Current sale status -"); 
        System.out.println("Name: " + info.getItemDescription().getName());
        System.out.println("Price: " + info.getItemDescription().getPrice());
        System.out.println("VAT-rate: " + info.getItemDescription().getVatRate());
        System.out.println("Running total: " + info.getRunningTotal() + "\n");
    }
    
    /**
     * Prints the total price of the sale sent from {@link Controller}
     * @param totalPrice the total price to be printed
     */
    public void printTotalPrice(float totalPrice){ 
        System.out.println("- Returned by the controller: Total price -");
        System.out.println("Total price: " + totalPrice + "\n");
    }

    /**
     * Prints out the change
     * 
     * @param change the change to be printed
     */
    public void printChange(float change) {
        System.out.println("- Returned by the controller: Change -");
        System.out.println("Change: " + change + "\n");
    }

    /**
     * Prints out the receipt
     * 
     * @param receipt the receipt to be printed
     */
    public void printReceipt(Receipt receipt) {
        System.out.println("====RECEIPT======");
        System.out.println("Paid amount: " + receipt.getAmountPaid());
        System.out.println("Change: " + receipt.getChange());
        System.out.println("Total: " + receipt.getTotalPrice());
        System.out.println("VAT: " + receipt.getVat());
        printItems(receipt.getItems());
        System.out.println("Date & Time: " + receipt.getTimeOfSale());
        System.out.println("====END OF RECEIPT======\n");
    }

    private void printItems(ArrayList<Item> items) {
        System.out.println("Purchased Items: ");
        for(Item item : items) {
            System.out.println("  " + item.getQuantity() + " x " + item.getItemName());
        }
    }
}
