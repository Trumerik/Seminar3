package se.kth.iv1350.processSale.model;

/**
 * Item class represent the name of the item and its quantitiy to be presented in the receipt
 */
public class Item {
    private String itemName;
    private int quantity;

    /**
     * Constructor for Item which takes in the name of the item and sets the quantity to 1
     * 
     * @param itemName the name of the item
     */
    public Item(String itemName){
        this.itemName = itemName;
        this.quantity = 1;
    }
    
    /**
     * Retrieves the items name
     * 
     * @return the name of the item
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Retrieves the quantity of the item
     * 
     * @return the items quantity
     */

    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Increments the quantity of the item by one
     */
    public void incrementQuantity(){
        this.quantity = this.quantity + 1;
    }
}
