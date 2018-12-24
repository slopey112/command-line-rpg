package items;
import objects.item;

public class MagicPotion extends item {
    public MagicPotion(String size) {
        description = "Refills a certain amount of you mana pool.";
        field = "mana";
        switch (size) {
            case ("small"):
                name = "Small Magic Potion";
                xp = 1;
                buff = 3;
                break;
            case ("medium"):
                name = "Medium Magic Potion";
                xp = 2;
                buff = 5;
                break;
            case ("large"):
                name = "Large Magic Potion";
                xp = 5;
                buff = 10;
                break;
        }
    }
}
