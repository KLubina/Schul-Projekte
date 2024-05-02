package knapsack;

import java.util.List;

class D4_RetryStackingStrategy implements E5_StackingStrategy {
    public void stackOpt(List<B2_Item> items, B2_Backpack backpack) {
        int tries = items.size() * 2;
        for (int i = 0; i < tries; i++) {
            int index = (int) (Math.random() * items.size());
            if (items.size() > 0 && pack(backpack, items.get(index))) {
                items.remove(index);
            }
        }
    }
}