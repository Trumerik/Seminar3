package se.kth.iv1350.processSale.integration;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import se.kth.iv1350.processSale.model.dto.ItemDescriptionDTO;

/**
 * Here we perform tests the {@link ExternalInventorySystem} class. Tests on the set/gets methods
 * are not included, according to the task instructions.
 */
public class ExternalInventorySystemTest {
    ExternalInventorySystem inventorySystem;
    
    /**
     * A set up method to be performed before the tests
     */
    @Before
    public void setUp() {
        this.inventorySystem = new ExternalInventorySystem();
    }
    
    /**
     * Test on the method getItemDescription to correctly find an existing {@link itemDescriptioDTO} with the
     * matching identifier
     */
    @Test
    public void testGetItemDescriptionExists() {
        ItemDescriptionDTO itemDescription = inventorySystem.getItemDescription("mjöl");
        assert(itemDescription.getName().equals("mjöl"));
    }
    
    /**
     * Test on the method getItemDescription to correctly return null value if no item description has
     * matching invalid identifier
     */
    @Test
    public void testGetItemDescriptionNotFound() {
        ItemDescriptionDTO itemDescription = inventorySystem.getItemDescription("mjölk");
        assertEquals(itemDescription, null);
    }
}