package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        systemCalls();
    }

    private void systemCalls() {
        controller.startSale();
        String identifier = "mjöl";
        CurrentSaleStatusDTO currentSaleStatus = controller.entersItemIdentifier(identifier);
        float runningTotal = controller.endSale();
        float amount = 1000f;
        float change = controller.enterPayment(amount);
    }

}
