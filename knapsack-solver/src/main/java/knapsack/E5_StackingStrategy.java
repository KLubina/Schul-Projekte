package knapsack;

import java.util.List;

public interface E5_StackingStrategy {
    void stackOpt(List<B2_Item> items, B2_Backpack backpack);
    
    default boolean pack(B2_Backpack backpack, B2_Item item) {
        if (item.getWeightGr() <= (backpack.getMaxWeight() - backpack.getCurrentWeight())) {
            backpack.getItems().add(item);
            backpack.setCurrentWeight(backpack.getCurrentWeight() + item.getWeightGr());
            return true;
        }
        return false;
    }
}