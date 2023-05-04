package se.kth.iv1350.processSale.model;

import org.junit.Test;

/**
 * Here we perform tests the {@link ExternalInventorySystem} class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class ItemTest {

    /**
     * Test on the method incrementQuantity to correctly increase the quantity of an item by one.
     */
    @Test
    public void testIncrementQuantity() {
        Item item = new Item("mandarin");
        item.incrementQuantity();
        assert(item.getQuantity() == 2);
    }
}