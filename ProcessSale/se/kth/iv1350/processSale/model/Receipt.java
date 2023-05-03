package se.kth.iv1350.processSale.model;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The receipt class contains information on the current sale, with methods to 
 * update and return attributes. 
 */
public class Receipt {
    private LocalDateTime timeOfSale;
    private float vat;
    private ArrayList<Integer> quantities;
    private ArrayList<String> items;
    private float totalPrice;
    private float amountPaid;
    private float change;
    
    /**
     * Creates a new instance of the receipt and sets the time of sale.
     * 
     * @param timeOfSale The time which the sale took place.
     */
    public Receipt(LocalDateTime timeOfSale){
        this.timeOfSale = timeOfSale;
    }
    
    /**
     * An item description is added to the receipt. If the item have already been added, its 
     * quantity will increase. Otherwise, the item is added to the receipt with the quantity of 1. 
     * The running total and vat is lastly updated.
     * 
     * @param itemDescription the item to be added to receipt
     */

    public void addItemToReceipt(ItemDescriptionDTO itemDescription){
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

    /**
     * updates the running total and vat attributes with added price and vat rate.
     * 
     * @param price the price of an item to be added to total price
     * @param vatRate the vat rate of an item to be added to vat
     */
    private void updateRunningTotalAndVat(float price, float vatRate) {
        this.totalPrice += price * (1 + vatRate);
        this.vat += price * vatRate;
    }

    /**
     * updates the attributes of amount paid to be the payment. Lastly calculates 
     * and updates the attribute of change.
     * 
     * @param payment the payment of the sale
     */
    public void updateReceipt(float payment){
        this.amountPaid = payment;
        float change = payment - totalPrice;
        this.change = change;
    }

    /**
     * @return the change of the current {@link Receipt }
     */
    public float getChange(){
        return this.change;
    }
    /**
     * @return the total price of the current {@link Receipt}
     */
    public float getRunningTotal(){
        return this.totalPrice;
    }





    public LocalDateTime getTimeOfSale(){
        return this.timeOfSale;
    }

    public ArrayList<Integer> getQuantities(){
        return this.quantities;
    }

    public ArrayList<String> getItems(){
        return this.items;
    }

    public float getVat(){
        return this.vat;
    }

    public float getAmountPaid(){
        return this.amountPaid;
    }
}
