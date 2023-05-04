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
    private ArrayList<Item> items;
    private float totalPrice;
    private float amountPaid;
    private float change;
    
    /**
     * Creates a new instance of the receipt with the specified time of sale as a parameter 
     * and initializes its fields. 
     * 
     * @param timeOfSale The time which the sale was initilized.
     */
    Receipt(LocalDateTime timeOfSale){
        this.timeOfSale = timeOfSale;
        this.items = new ArrayList<Item>();
        this.vat = 0;
        this.totalPrice = 0;
        this.amountPaid = 0;
        this.change = 0;
    }
    
    /**
     * Adds the item and updates the receipts items, quantities, vat and running total.
     * 
     * @param itemDescription The information about the item to be added to receipt
     */
    void addItemToReceipt(ItemDescriptionDTO itemDescription){
        for(Item item: this.items){
            if (item.getItemName().equals(itemDescription.getName())){
                item.incrementQuantity();
                updateRunningTotalAndVat(itemDescription.getPrice(), itemDescription.getVatRate());
                return;
            }
        }
        this.items.add(new Item(itemDescription.getName()));
        updateRunningTotalAndVat(itemDescription.getPrice(), itemDescription.getVatRate());
    }

    private void updateRunningTotalAndVat(float price, float vatRate) {
        this.totalPrice += price * (1 + vatRate);
        this.vat += price * vatRate;
    }

    /**
     * Updates the reciept based on the recieved payment.
     * 
     * @param payment the payment of the sale
     */
    void updateReceiptWithPayment(float payment){
        this.amountPaid = payment;
        float change = payment - totalPrice;
        this.change = change;
    }

    /**
     * Retrieves the change from the receipt.
     * 
     * @return the change of the receipt
     */
    public float getChange(){
        return this.change;
    }

    /**
     * Retrieves the total price from the receipt
     * 
     * @return the total price of the receipt
     */
    public float getTotalPrice(){
        return this.totalPrice;
    }
    
    /**
     * Retrieves the time of sale from the receipt.
     * 
     * @return the time of sale of the receipt
     */
    public LocalDateTime getTimeOfSale(){
        return this.timeOfSale;
    }

    /**
     * Retrieves the list of items (class {@link Item}) from the receipt.
     * 
     * @return the items of the receipt
     */
    public ArrayList<Item> getItems(){
        return this.items;
    }

    /**
     * Retreives the total VAT from the receipt
     * 
     * @return the total vat of the receipt
     */
    public float getVat(){
        return this.vat;
    }

    /**
     * Retrieves the amount paid from the receipt. 
     *
     * @return the amount paid of the receipt
     */
    public float getAmountPaid(){
        return this.amountPaid;
    }
}
