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
     * 1. Cashier starts the sale.
     * 2. Cashier enters the item identifier "mjöl" and the system returns the current sale status.
     * 3. Cashier enters the item identifier "mandarin" and the system returns the current sale status.
     * 4. Cashier enters the item identifier "mandarin" and the system returns the current sale status.
     * 5. Cashier enters the item identifier "mandarin" and the system returns the current sale status.
     * 6. Cashier enters the item identifier "mjöl" and the system returns the current sale status.
     * 7. Cashier enters the item identifier "honung" and the system returns the current sale status.
     * 8. Cashier enters the item identifier "äpple" and the system returns the current sale status.
     * 9. Cashier enters the item identifier "ananas" and the system returns the current sale status.
     * 10. Cashier enters the item identifier "äpple" and the system returns the current sale status.
     * 11. Cashier ends the sale.
     * 12. Cashier enters the amount paid by the customer and finally the receipt is printed.
     */
    private void systemCalls() {
        this.controller.startSale();
        
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);
        
        identifier = "mandarin";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

        identifier = "mandarin";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

        identifier = "mandarin";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);
        
        identifier = "mjöl";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

        identifier = "honung";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

        identifier = "äpple";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

        identifier = "ananas";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);

        identifier = "äpple";
        currentSaleStatus = this.controller.entersItemIdentifier(identifier);
        this.prettyPrinter.printCurrentSaleInformation(currentSaleStatus);
        
        float totalPrice = this.controller.endSale();
        this.prettyPrinter.printTotalPrice(totalPrice);
        
        float payment = 200f;
        float change = this.controller.entersPayment(payment);
        this.prettyPrinter.printChange(change);

        this.controller.printReceipt();
    }
}