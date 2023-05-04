package se.kth.iv1350.processSale.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;

/**
 * Tests on the methods belonging to the Receipt class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class ReceiptTest {
    Receipt receipt;

    /**
     * test on the method updatePayment
     */
    @Test
    public void testUpdateReceiptWithPayment() {
        Receipt receipt = new Receipt(LocalDateTime.now());
        float payment = 100f;
        receipt.updateReceiptWithPayment(payment);
        assertEquals(receipt.getAmountPaid(), 100f, 0);
        assertEquals(receipt.getChange(), 100f, 0);
    }

    /**
     * a setup is made before the tests on the reciepts items list
     */
    @Before
    public void setUpItemsList(){
        this.receipt = new Receipt(LocalDateTime.now());
        ItemDescriptionDTO item = new ItemDescriptionDTO(10, "mandarin", 0.12f);
        receipt.addItemToReceipt(item);
    }
    
    /**
     * Tests that the item name is correctly stores in the list of items.
     */
    @Test
    public void testAddItemToReceiptName() {
        assertEquals(this.receipt.getItems().get(0).getItemName(), "mandarin");
    }

     /**
     * Test correct quantity field in Items object from method addItemToReceipt
     */

    @Test
    public void testAddItemToReceiptQuantity() {
        assertEquals(this.receipt.getItems().get(0).getQuantity(), 1);
    }

     /**
     * Tests that the item price is correctly stores in the list of items.
     */
    @Test
    public void testAddItemToReceiptPrice() {
        assertEquals(this.receipt.getTotalPrice(), 10*1.12, 0.01);
    }

     /**
     * Tests that the item VAT is correctly stores in the list of items.
     */
    @Test
    public void testAddItemToReceiptVat() {
        assertEquals(this.receipt.getVat(), 10*0.12f, 0.01);
    }

     /**
     * Tests that the item quantity is correctly updated in the list of items 
     * when items of same kind are added.
     */
    @Test
    public void testAddItemToReceiptSameItem() {
        ItemDescriptionDTO item = new ItemDescriptionDTO(10, "mandarin", 0.12f);
        receipt.addItemToReceipt(item);
        assertEquals(this.receipt.getItems().get(0).getQuantity(), 2);
    }

    /**
     * Clean up performed after the tests are done
     */
    @After
    public void cleanUp(){
        this.receipt = null;
    }
}