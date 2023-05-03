package se.kth.iv1350.processSale.integration;
import se.kth.iv1350.processSale.model.Receipt;
/**
 * The external accounting system contains accounting information. Calls are only made 
 * to the class from the controller
 */
public class ExternalAccountingSystem {
    /**
     * Creates a new instance of the external accounting system.
     */
    public ExternalAccountingSystem(){}
    
    /**
     * recieves receipt/sale information. But since external systems are not modeled in this
     * exercise we choose to leave it blank.
     * 
     * @param receipt the {@link Receipt} to be handled by the accounting system
     */
    public void sendSaleInformation(Receipt receipt) {
        
    }
}
