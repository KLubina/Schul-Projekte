package knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class E5_Person {
    protected String name;
    protected E5_StackingStrategy stackingStrategy;

    public E5_Person(E5_StackingStrategy stackingStrategy) {
        this.name = "Packer";
        this.stackingStrategy = stackingStrategy;
    }

    public void setStackingStrategy(E5_StackingStrategy newStrategy) {
        stackingStrategy = newStrategy;
    }

    public void optimizeStacking(List<B2_Item> items, B2_Backpack backpack) {
        stackingStrategy.stackOpt(items, backpack);
    }

    public List<B2_Item> prepareItems(int numberOfItems) {
        List<B2_Item> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfItems; i++) {
            result.add(new B2_Item("Item " + (i + 1), random.nextInt(800) + 1));
        }
        return result;
    }

    public void emptyBackpack(B2_Backpack backpack) {
        backpack.items.clear();
        backpack.currentWeight = 0;
    }
}