package items;
import objects.item;

public class HealingPotion extends item {
    public HealingPotion(String size) {
        description = "Heals a certain amount of health.";
        field = "hp";
        switch (size) {
            case ("small"):
                name = "Small Healing Potion";
                xp = 1;
                buff = 5;
                break;
            case ("medium"):
                name = "Medium Healing Potion";
                xp = 2;
                buff = 10;
                break;
            case ("large"):
                name = "Large Healing Potion";
                xp = 4;
                buff = 20;
                break;
        }
    }
}
