package se.kth.iv1350.processSale.model;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Receipt {
    private LocalDateTime timeOfSale;
    private int vatRate;
    private ArrayList<Integer> quantities; // {5, "apples"}, {2, "milk"} eller: {1,2,5,6}
    private ArrayList<String> items;                                  //        {"apples, "milk", "flour"}
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
                increaseRunningTotal(itemDescription.getPrice());
                return;
            }
        }
        items.add(itemDescription.getName());
        quantities.add(1);
        increaseRunningTotal(itemDescription.getPrice());
    }

    private void increaseRunningTotal(float price) {
        this.totalPrice += price;
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
