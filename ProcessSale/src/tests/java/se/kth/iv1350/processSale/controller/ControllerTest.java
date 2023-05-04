package se.kth.iv1350.processSale.controller; 

import org.junit.*;
import se.kth.iv1350.processSale.integration.ReceiptPrinter;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import static org.junit.Assert.assertEquals;

/**
 * Tests on the methods belonging to the Controller class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class ControllerTest {
    
    private Controller controller;
    private ReceiptPrinter receiptPrinter;
    private CurrentSaleStatusDTO cssDTO;
    
    /**
     * A setup is made before the tests are made
     */
    @Before
    public void setUp(){
        receiptPrinter = new ReceiptPrinter();
        controller = new Controller(receiptPrinter);
        controller.startSale();
        this.cssDTO = controller.entersItemIdentifier("mandarin");
    }
    
    /**
     * Test on the method entersItemIdentifier to store and return the correct name of the item
     */
    @Test
    public void entersItemIdentifierTestName() {
        assertEquals(this.cssDTO.getItemDescription().getName(), "mandarin");
    }
    
    /**
     * Test on the method entersItemIdentifier to calculate, store and return the correct Vat rate
     */
    @Test
    public void entersItemIdentifierTestVatRate() {
        assertEquals(this.cssDTO.getItemDescription().getVatRate(), 0.25f, 0);

    }

    /**
     * Test on the method entersItemIdentifier to store and return the correct price of the item
     */
    @Test
    public void entersItemIdentifierTestPrice() {
        assertEquals(this.cssDTO.getItemDescription().getPrice(), 4.95, 0.01);

    }

    /**
     * Test on the method entersItemIdentifier to calculate, store and return the correct running total.
     */
    @Test
    public void entersItemIdentifierTestRunningTotal() {
        assertEquals(this.cssDTO.getRunningTotal(), 6.1875, 0);
    }

    /**
     * Test on the method endSaleTest to calculate and return the correct total price
     */
     @Test
    public void endSaleTest() {
        float totalPrice = controller.endSale();
        assertEquals(totalPrice, 6.1875, 0);
    }

    /**
     * Test on the method enterPayment to calculate and return the correct amount of change based on payment
     */
    @Test
    public void testEnterPayment(){
        float change = controller.entersPayment(100f);
        assertEquals(change, 93.8125, 0);
    }
}