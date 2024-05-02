package knapsack;

import java.util.ArrayList;
import java.util.List;

public class B2_Backpack {
    protected int maxWeight;
    protected int currentWeight;
    protected List<B2_Item> items;

    public B2_Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.items = new ArrayList<>();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public List<B2_Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        String result = "Max Weight: " + maxWeight + " gr\nCurrent Weight: " + currentWeight + " gr\nItems: ";
        for (B2_Item item : items) {
            result += item + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}