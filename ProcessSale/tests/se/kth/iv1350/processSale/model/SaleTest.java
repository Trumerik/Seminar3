package ProcessSale.tests.se.kth.iv1350.processSale.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.integration.ExternalInventorySystem;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
/**
 * Tests on the methods belonging to the Sale class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class SaleTest{
    
     /**
     * test on the method requestSaleInformation
     */
    @Test
    public void testRequestSaleInformation(){
        ExternalInventorySystem inventory = new ExternalInventorySystem();
        Sale sale = new Sale(inventory);
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSale = sale.requestSaleInformation(identifier);
        assertEquals(currentSale.getItemDescription().getName(), "mjöl");
    }
    /**
     * test on the method updateReceipt
     */
    @Test
    public void testUpdateReceipt(){
        ExternalInventorySystem inventory = new ExternalInventorySystem();
        Sale sale = new Sale(inventory);
        float payment = 100f;
        sale.updateReceipt(payment);
        assertEquals(sale.getReceipt().getAmountPaid(), 100f, 0);
    }

}