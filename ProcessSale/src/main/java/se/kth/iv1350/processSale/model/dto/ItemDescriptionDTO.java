package se.kth.iv1350.processSale.model.dto;

/**
 * This class represents an item description.
 */
public class ItemDescriptionDTO {
    private float price;
    private String name;
    private float vatRate;

    /**
     * Creates a new instance of an item description. 
     * 
     * @param price The price of the item.
     * @param name The name of the item.
     * @param vatRate The vat rate of the item.
     */
    public ItemDescriptionDTO(float price, String name, float vatRate){
        this.price = price;
        this.name = name;
        this.vatRate = vatRate;
    }

    /**
     * A getter method to retrive the price of the item.
     * 
     * @return The price of the item.
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * A getter method to retrive the name of the item.
     * 
     * @return The name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter method to retrive the vat rate of the item.
     * 
     * @return The vat rate of the item.
     */
    public float getVatRate() {
        return this.vatRate;
    }

}
