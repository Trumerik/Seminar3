package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;
/**
 * The external inventory system contains all item description informations. Calls are only made 
 * to the class from the {@link Controller}
 */
public class ExternalInventorySystem {
    private ArrayList<ItemDescriptionDTO> mockDatabase;
    
    /**
     * Creates a new instance of the {@link ExternalInventorySystem}, creating and adding item
     * descriptions to a mock database, along with its quantity in inventory.
     */
    public ExternalInventorySystem(){
        this.mockDatabase = new ArrayList<ItemDescriptionDTO>();
        mockDatabase.add(new ItemDescriptionDTO(3.90f, "äpple", 0.12f));
        mockDatabase.add(new ItemDescriptionDTO(15.50f, "mjöl", 0.12f));
        mockDatabase.add(new ItemDescriptionDTO(80f, "honung", 0.06f));
        mockDatabase.add(new ItemDescriptionDTO(4.95f, "mandarin", 0.25f));
        mockDatabase.add(new ItemDescriptionDTO(27.95f, "ananas", 0.25f));
    }

    /**
     * Method returns the item description from the mock data base, by searching for matching 
     * item identifier.
     * 
     * @param identifier the identifier of the searched item description
     * @return the specified {@link ItemDescriptionDTO}. If not found, null instead.
     */
    
    public ItemDescriptionDTO getItemDescription(String identifier){
       for(ItemDescriptionDTO item: mockDatabase) {
            if (identifier == item.getName())
                return item;
       }
       return null;
    }

    /**
     * Updates the external inventory system database with the information from receipt.
     * This is not included because remote calls are not supposed to be simulated.
     * 
     * @param receipt the {@link Receipt} to be handled by inventory system
     */

    public void updateInventorySystem(Receipt receipt) {}
}
