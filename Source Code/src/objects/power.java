package objects;

public class power {
    public String name;
    public String description;
    public int affectsPlayer;
    public int value;
    public int cost;
    public int hiddenValue;
    public int skips;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAffectsPlayer() {
        return affectsPlayer;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    public int getSkips() { return skips; }
}
