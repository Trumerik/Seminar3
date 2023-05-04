package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;
import se.kth.iv1350.processSale.util.PrettyPrinter;

/**
 * View class represents the interface between the cashier and the system.
 * This class contains the hardcoded system calls that represent the basic
 * flow (and the one alternate flow required) described in the seminar instructions. 
 */
public class View {
    private Controller controller;
    private PrettyPrinter prettyPrinter = new PrettyPrinter();

    /**
     * Constructor for the View class with the specified {@link Controller} class as a parameter.
     * 
     * @param controller is an instance of the Controller.
     */
    public View(Controller controller) {
        this.controller = controller;
        systemCalls();
    }

    /**
     * This method contains the hardcoded system calls that represent the user interface, 
     * we showcase basic flow, and the one alternate flow, as described in the task instructions.
     * We also have printouts directly the System.out when the something is returned by the controller.
     * 
     * Here is an explination of the mock user interface system calls:
     * 1. Cashier enters the item identifier "mjöl" and the system returns the current sale status.
     * 2. Cashier enters the item identifier "mandariner" and the system returns the current sale status.
     * 3. Cashier enters the item identifier "mjöl" and the system returns the current sale status.
     * 4. Cashier ends the sale and the system returns the total price of the sale.
     * 5. Cashier enters the payment recieved by the customer of 1000 SEK and the system returns the change.
     */
    private void systemCalls() {
        this.controller.startSale();
        
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);
        
        identifier = "mandariner";
        CurrentSaleStatusDTO currentSaleStatus1 = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus1);
        
        identifier = "mjöl";
        CurrentSaleStatusDTO currentSaleStatus3 = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus3);
        
        float totalPrice = this.controller.endSale();
        this.prettyPrinter.printTotalPrice(totalPrice);
        
        float payment = 1000f;
        float change = this.controller.entersPayment(payment);
        this.prettyPrinter.printChange(change);
        
    }
}