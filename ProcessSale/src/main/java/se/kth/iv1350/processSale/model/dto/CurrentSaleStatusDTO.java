package se.kth.iv1350.processSale.model.dto;

/**
 * This class represents the current sale status.
 */
public class CurrentSaleStatusDTO {
    private ItemDescriptionDTO itemDescription;
    private float runningTotal;

    /**
     * Creates a new instance of the current sale status representing the currents sale status. 
     * Which includes information of the sale in its current state.
     * 
     * @param itemDescription The {@link itemDescriptionDTO} class which includes necessary information.
     * @param runningTotal The running total of the sale.
     */
    public CurrentSaleStatusDTO(ItemDescriptionDTO itemDescription, float runningTotal) {
        this.itemDescription = itemDescription;
        this.runningTotal = runningTotal;
    }

    /**
     * getter method for the running total
     * @return the running total
     */
    public float getRunningTotal(){
        return this.runningTotal;
    }

    /**
     * getter method for the item description
     * @return the item description
     */
    public ItemDescriptionDTO getItemDescription(){
        return this.itemDescription;
    }
}