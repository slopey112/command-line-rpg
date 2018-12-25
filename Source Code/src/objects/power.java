package objects;

public class power {
    protected String name;
    protected String description;
    protected String field;
    protected int affectsPlayer;
    protected int value;
    protected int cost;
    protected int dot;
    protected int dotL;
    protected int skips;

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

    public int getDot() { return dot; }

    public int getDotL() { return dotL; }

    public String getField() { return field; }
}
