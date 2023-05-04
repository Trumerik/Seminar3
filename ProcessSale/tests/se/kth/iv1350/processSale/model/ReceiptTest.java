package ProcessSale.tests.se.kth.iv1350.processSale.model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
import se.kth.iv1350.processSale.model.Item;

/**
 * Tests on the methods belonging to the Receipt class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */

public class ReceiptTest {
    

    /**
     * test on the method updatePayment
     */
    @Test
    public void testUpdatePayment() {
        Receipt receipt = new Receipt(LocalDateTime.now());
        float payment = 100f;
        receipt.updatePayment(payment);
        assertEquals(receipt.getAmountPaid(), 100f, 0);
        assertEquals(receipt.getChange(), 100f, 0);
    }
    
    /**
     * test on the method addItemToReceipt
     */
    @Test
    public void testAddItemToReceipt() {
        Receipt receipt = new Receipt(LocalDateTime.now());
        ItemDescriptionDTO item = new ItemDescriptionDTO(10, "mandarin", 0.12f);
        receipt.addItemToReceipt(item);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("mandarin"));
        ArrayList<Integer> quantities = new ArrayList<Integer>();
        quantities.add(1);
        assertEquals(receipt.getItems(), items);
        assertEquals(receipt.getRunningTotal(), 10*1.12, 0.01);
        assertEquals(receipt.getVat(), 10*0.12f, 0.01);
    }
}
