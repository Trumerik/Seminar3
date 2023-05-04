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

    @Before
    public void setUpItemsList(){
        this.inventory = new ExternalInventorySystem();
        this.sale = new Sale(inventory);
        String identifier = "mjöl";
        sale.requestSaleInformation(identifier);
    }

    /**
     * test on the method requestSaleInformation
     */
    @Test
    public void testRequestSaleInformationIfInCache(){
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSale = sale.requestSaleInformation(identifier);
        assertEquals(currentSale.getItemDescription().getName(), "mjöl");
    }

    
    @Test
    public void testRequestSaleInformationIfItDoesNotExist(){
        String identifier = "guld";
        CurrentSaleStatusDTO currentSale = sale.requestSaleInformation(identifier);
        assertEquals(currentSale.getItemDescription().getName(), null);
    }

    /**
     * test on the method updateReceipt
     */
    @Test
    public void testUpdateReceipt(){
        float payment = 100f;
        sale.updateReceiptWithPayment(payment);
        assertEquals(sale.getReceipt().getAmountPaid(), 100f, 0);
    }

}