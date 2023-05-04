package se.kth.iv1350.processSale.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import se.kth.iv1350.processSale.integration.ExternalInventorySystem;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;

/**
 * Tests on the methods belonging to the Sale class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class SaleTest{
    private ExternalInventorySystem inventory;
    private Sale sale;

    /**
     * A set up method to be performed before the tests
     */
    @Before
    public void setUpItemsList(){
        this.inventory = new ExternalInventorySystem();
        this.sale = new Sale(inventory);
        String identifier = "mjöl";
        sale.requestSaleInformation(identifier);
    }

    /**
     * test the method requestSaleInformation, if an {@link Item} with an identifier exists in the cache.
     */
    @Test
    public void testRequestSaleInformationIfInCache(){
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSale = sale.requestSaleInformation(identifier);
        assertEquals(currentSale.getItemDescription().getName(), "mjöl");
    }

    /**
     * test on the method requestSaleInformation, if an {@link Item} identifier is not in the cache, i.e in 
     * {@link Inventory}
     */
    @Test
    public void testRequestSaleInformationIfNotInCache(){
        String identifier = "mandarin";
        CurrentSaleStatusDTO currentSale = sale.requestSaleInformation(identifier);
        assertEquals(currentSale.getItemDescription().getName(), "mandarin");
    }

    /**
     * test on the method updateReceipt, if it correctly updates the {@link Receipt} amount paid
     * with payment
     */
    @Test
    public void testUpdateReceipt(){
        float payment = 100f;
        sale.updateReceiptWithPayment(payment);
        assertEquals(sale.getReceipt().getAmountPaid(), 100f, 0);
    }
}