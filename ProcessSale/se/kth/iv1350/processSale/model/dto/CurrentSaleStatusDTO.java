package se.kth.iv1350.processSale.model.dto;

public class CurrentSaleStatusDTO {

    private ItemDescriptionDTO itemDescription;
    private float runnintTotal;

    public CurrentSaleStatusDTO(ItemDescriptionDTO itemDescription, float runningTotal) {
        this.itemDescription = itemDescription;
        this.runnintTotal = runningTotal;
    }
}
