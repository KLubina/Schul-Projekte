package knapsack;

import java.util.List;

class D4_PairCompareStackingStrategy implements E5_StackingStrategy {
    public void stackOpt(List<B2_Item> items, B2_Backpack backpack) {
        for (int i = 0; i < items.size(); i++) {
            if (pack(backpack, items.get(i))) {
                items.remove(i);
                i--;
            }
        }
    }
}