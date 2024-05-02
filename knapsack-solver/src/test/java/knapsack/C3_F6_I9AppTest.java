package knapsack;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class C3_F6_I9AppTest {
    private B2_Backpack backpack;
    private E5_Person person;
    private List<B2_Item> items;

    @BeforeEach
    public void setUp() {
        backpack = new B2_Backpack(4000); 
        person = new E5_Person(new D4_PairCompareStackingStrategy()); 
        items = person.prepareItems(10); 
    }

    @Test
    public void testPairCompareStacking() {
        person.optimizeStacking(new ArrayList<>(items), backpack);
        assertTrue(backpack.getCurrentWeight() <= backpack.getMaxWeight(), "Backpack should not exceed its max weight.");
    }

    @Test
    public void testRetryStackingStrategy() {
        person.setStackingStrategy(new D4_RetryStackingStrategy());
        person.emptyBackpack(backpack); 
        person.optimizeStacking(new ArrayList<>(items), backpack); 
        assertTrue(backpack.getCurrentWeight() <= backpack.getMaxWeight(), "Backpack should not exceed its max weight after retry strategy.");
    }

    @Test
    public void testBackpackRepackingAfterEmptying() {
        person.optimizeStacking(new ArrayList<>(items), backpack);
        int weightAfterFirstPacking = backpack.getCurrentWeight();
        List<B2_Item> firstPackingItems = new ArrayList<>(backpack.getItems());

        person.setStackingStrategy(new D4_RetryStackingStrategy());
        person.emptyBackpack(backpack);
        assertTrue(backpack.getItems().isEmpty() && backpack.getCurrentWeight() == 0, "Backpack should be empty after clearing.");

        items.forEach(item -> item.weightGr += 5);
        person.optimizeStacking(new ArrayList<>(items), backpack);
        int weightAfterSecondPacking = backpack.getCurrentWeight();
        List<B2_Item> secondPackingItems = new ArrayList<>(backpack.getItems());

        assertNotEquals(weightAfterFirstPacking, weightAfterSecondPacking, "Weights should differ indicating repacking occurred.");
        assertFalse(firstPackingItems.equals(secondPackingItems), "Item lists should differ after repacking with different strategy.");
        assertTrue(weightAfterSecondPacking <= backpack.getMaxWeight(), "Backpack should still not exceed max weight after repacking.");
    }
}