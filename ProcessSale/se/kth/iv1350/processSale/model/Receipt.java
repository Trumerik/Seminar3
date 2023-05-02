package se.kth.iv1350.processSale.model;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Receipt {
    private LocalDateTime timeOfSale;
    private float vat;
    private ArrayList<Integer> quantities;
    private ArrayList<String> items;
    private float totalPrice;
    private float amountPaid;
    private float change;
    
    public Receipt(LocalDateTime timeOfSale){
        this.timeOfSale = timeOfSale;
    }
    
    public void addItemToReceipt(ItemDescriptionDTO itemDescription){ //remember to increase quantity of item
        for(int i = 0; i <= quantities.size(); i++){
            if (items.get(i) == itemDescription.getName()){
                quantities.set(i, quantities.get(i) + 1);
                updateRunningTotalAndVat(itemDescription.getPrice(), itemDescription.getVatRate());
                return;
            }
        }
        items.add(itemDescription.getName());
        quantities.add(1);
        updateRunningTotalAndVat(itemDescription.getPrice(), itemDescription.getVatRate());
    }

    private void updateRunningTotalAndVat(float price, float vatRate) {
        this.totalPrice += price * (1 + vatRate);
        this.vat += price * vatRate;
    }

    public void updateReceipt(float payment){
        float change = payment - totalPrice;
        this.amountPaid = payment;
        this.change = change;
    }

    public Receipt getReceipt(){
        return this;
    }

    public float getChange(){
        return this.change;
    }

    public float getRunningTotal(){
        return this.totalPrice;
    }
}
