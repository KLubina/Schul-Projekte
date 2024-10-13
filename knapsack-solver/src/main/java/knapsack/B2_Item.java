package knapsack;

public class B2_Item {
    protected String name;
    protected int weightGr;

    public B2_Item(String name, int weight) {
        this.name = name;
        this.weightGr = weight;
    }

    public int getWeightGr() {
        return weightGr;
    }

    @Override
    public String toString() {
        return name + ": " + weightGr + " gr";
    }
}