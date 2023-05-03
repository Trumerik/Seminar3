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
     * Constructor for the View class.
     * 
     * @param controller is an instance of the Controller
     */
    public View(Controller controller) {
        this.controller = controller;
        systemCalls();
    }

    /**
     * This method contains the hardcoded system calls that represent the basic flow, 
     * and the one alternate flow, described in the seeminar instructions.
     */
    private void systemCalls() {
        controller.startSale();
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSaleStatus = controller.entersItemIdentifier(identifier);
        prettyPrinter.printCurrentSaleInformation(currentSaleStatus);
        float totalPrice = controller.endSale();
        System.out.println("Total price: " + totalPrice);
        float payment = 1000f;
        float change = controller.enterPayment(payment);
        System.out.println("Change: " + change);
    }
}