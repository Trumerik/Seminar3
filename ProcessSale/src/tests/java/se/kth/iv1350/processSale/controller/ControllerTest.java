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
    /**
     * a setup is made before the tests are made
     */
    @Before
    public void setUp(){
        receiptPrinter = new ReceiptPrinter();
    }
    
    /**
     * test on the method testStartSale
     */
    @Test
    public void testStartSale() {
        controller = new Controller(receiptPrinter);
        controller.startSale();
        assert(true);
    }
    /**
     * test on the method entersItemIdentifier
     */
    @Test
    public void entersItemIdentifierTest() {
        controller = new Controller(receiptPrinter);
        controller.startSale();
        CurrentSaleStatusDTO cssDTO = controller.entersItemIdentifier("mandariner");
        assertEquals(cssDTO.getItemDescription().getName(), "mandariner");
        assertEquals(cssDTO.getItemDescription().getVatRate(), 0.25f, 0);
        assertEquals(cssDTO.getItemDescription().getPrice(), 5, 0);
        assertEquals(cssDTO.getRunningTotal(), 6.25, 0);
    }
    /**
     * test on the method endSaleTest
     */
     @Test
    public void endSaleTest() {
        controller = new Controller(receiptPrinter);
        controller.startSale();
        controller.entersItemIdentifier("mandariner");
        float totalPrice = controller.endSale();
        assertEquals(totalPrice, 6.25, 0);
    }
    /**
     * test on the method enterPayment
     */
    @Test
    public void testEnterPayment(){
        controller = new Controller(receiptPrinter);
        controller.startSale();
        controller.entersItemIdentifier("mandariner");
        controller.endSale();
        float change = controller.entersPayment(100f);
        assertEquals(change, 93.75, 0);
    }
}