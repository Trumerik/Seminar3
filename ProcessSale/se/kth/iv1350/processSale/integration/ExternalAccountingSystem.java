package se.kth.iv1350.processSale.integration;
import se.kth.iv1350.processSale.model.Receipt;
/**
 * The external accounting system contains accounting information. Calls are only made 
 * to the class from the 
 * external systems. All calls to the model pass through here.
 */
public class ExternalAccountingSystem {
    
    public ExternalAccountingSystem(){}
    
    public void sendSaleInformation(Receipt receipt) {
        //this method would be used to send information to a remote external accounting system.
        //But since those are not modeled in this excercise, we choose to leave it blank.
    }
}
