package knapsack;

import java.util.ArrayList;
import java.util.List;

public class H8_App {
    public static void main(String[] args) {
        B2_Backpack backpack = new B2_Backpack(4000);
        E5_Person person = new E5_Person(new D4_PairCompareStackingStrategy());

        System.out.println("Backpack (empty):");
        System.out.println(backpack);

        List<B2_Item> items = person.prepareItems(30);
        person.optimizeStacking(new ArrayList<>(items), backpack);
        System.out.println("Backpack (after repacking, 1st Strategy):");
        System.out.println(backpack);

        person.setStackingStrategy(new D4_RetryStackingStrategy());
        person.emptyBackpack(backpack);

        person.optimizeStacking(new ArrayList<>(items), backpack);
        System.out.println("Backpack (after packing, 2nd Strategy):");
        System.out.println(backpack);
    }
}