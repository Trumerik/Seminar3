package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import javafx.util.Pair;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
/**
 * The external inventory system contains all item description informations. Calls are only made 
 * to the class from the {@link Controller}
 */
public class ExternalInventorySystem {

    private ArrayList<Pair<ItemDescriptionDTO, Integer>> mockDatabase;
    
    /**
     * Creates a new instance of the {@link ExternalInventorySystem}, creating and adding item
     * descriptions to a mock database, along with its quantity in inventory.
     */
    public ExternalInventorySystem(){
        ItemDescriptionDTO itemDescriptionDTO1 = new ItemDescriptionDTO(30, "apple", 0.25f); 
        ItemDescriptionDTO itemDescriptionDTO2 = new ItemDescriptionDTO(50, "mjöl", 0.12f);
        ItemDescriptionDTO itemDescriptionDTO3 = new ItemDescriptionDTO(40, "honung", 0.06f);
        ItemDescriptionDTO itemDescriptionDTO4 = new ItemDescriptionDTO(5, "mandariner", 0.25f);
        ItemDescriptionDTO itemDescriptionDTO5 = new ItemDescriptionDTO(25, "ananas", 0.12f);
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO1, 40));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO2, 25));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO3, 134));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO4, 1));
        mockDatabase.add(new Pair<ItemDescriptionDTO, Integer>(itemDescriptionDTO5, 4));
    }

    /**
     * method returns the item description from the mock data base, by searching for matching 
     * item identifier.
     * 
     * @param identifier the identifier of the searched item description
     * 
     * @return the specified {@link ItemDescriptionDTO}. If not found, null instead.
     */
    
    public ItemDescriptionDTO getItemDescription(String identifier){
       for(Pair<ItemDescriptionDTO, Integer> item: mockDatabase) {
            if (identifier == item.getKey().getName())
                return item.getKey();
       }
       return null;
    }

    /**
     * updates the external inventory system database with the information from receipt.
     * This is not included because remote calls are not supposed to be simulated.
     * 
     * @param receipt the {@link Receipt} to be handled by inventory system
     */

    public void updateInventorySystem(Receipt receipt) {}
}
