package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;

/**
 * View class represents the interface between the cashier and the system.
 * This class contains the hardcoded system calls that represent the basic
 * flow (and the one alternate flow required) described in the seminar instructions. 
 */
public class View {
    private Controller controller;

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
        float runningTotal = controller.endSale();
        float amount = 1000f;
        float change = controller.enterPayment(amount);
    }

}
