package se.kth.iv1350.processSale.model.dto;

public class ItemDescriptionDTO {

    private float price;
    private String name;
    private float vatRate;

    public ItemDescriptionDTO(float price, String name, float vatRate){
        this.price = price;
        this.name = name;
        this.vatRate = vatRate;
    }


    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public float getVatRate() {
        return this.vatRate;
    }

}
