package se.kth.iv1350.processSale.util;

import se.kth.iv1350.processSale.model.dto.CurrentSaleStatusDTO;

public class PrettyPrinter {

    public PrettyPrinter(){}
    public void printCurrentSaleInformation(CurrentSaleStatusDTO info){    
        System.out.println("Running total: " + info.getRunningTotal());
        System.out.println("Name: " + info.getItemDescription().getName());
        System.out.println("Price: " + info.getItemDescription().getPrice());
        System.out.println("VAT-rate: " + info.getItemDescription().getVatRate());
    }
}
