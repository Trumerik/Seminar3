package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import javafx.util.Pair;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;

public class ExternalInventorySystem {

    private ArrayList<Pair<ItemDescriptionDTO, Integer>> mockDatabase;

    public ExternalInventorySystem(){
        ItemDescriptionDTO itemDescriptionDTO1 = new ItemDescriptionDTO(30, "apple", 12); 
        ItemDescriptionDTO itemDescriptionDTO2 = new ItemDescriptionDTO(50, "mjöl", 15);
        ItemDescriptionDTO itemDescriptionDTO3 = new ItemDescriptionDTO(40, "honung", 70);
        ItemDescriptionDTO itemDescriptionDTO4 = new ItemDescriptionDTO(5, "mandariner", 36);
        ItemDescriptionDTO itemDescriptionDTO5 = new ItemDescriptionDTO(25, "ananas", 57);
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO1, 40));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO2, 25));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO3, 134));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO4, 1));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO5, 4));
    }

    public ItemDescriptionDTO getItemDescription(String identifier){
       for(Pair<ItemDescriptionDTO, Integer> item: mockDatabase) {
            if (identifier == item.getKey().getName())
                return item.getKey();
       }
       return null;
    }

    public void updateInventorySystem(Receipt receipt) {
        //this would simulate updating the external inventory system database. We chose not to include it because
        //remote calls are not supposed to be simulated.
    }
}
