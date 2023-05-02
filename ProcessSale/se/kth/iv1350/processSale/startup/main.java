package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.ReceiptPrinter;
import se.kth.iv1350.processSale.view.View;

public class Main {
    public static void main(String[] args) {
        ReceiptPrinter printer = new ReceiptPrinter();
        Controller controller = new Controller(printer);
        View view = new View(controller);
    }
}
