package se.kth.iv1350.processSale.model;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Receipt {
    private LocalDateTime timeOfSale;
    private int vatRate;
    private ArrayList<Integer> quantities;
    private ArrayList<String> items;
    private int totalPrice;
    private float amountPaid;
    private float change;
    
    public Receipt(LocalDateTime timeOfSale){
        this.timeOfSale = timeOfSale;
    }
    
    public void addItemToReceipt(ItemDescriptionDTO itemDescription){ //remember to increase quantity of item
    }

    public void updateReceipt(float payment, float change){
        // have to add update reciept
    }

    public Receipt getReceipt(){
        return this;
    }

    public float getChange(){
        return this.change;
    }
}
