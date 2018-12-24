package items;

import objects.item;

public class AbilityFlask extends item {
    public AbilityFlask(String size) {
        description = "Permanently increases your ability power.";
        field = "ability";
        switch (size) {
            case ("small"):
                name = "Small Ability Flask";
                xp = 5;
                buff = 1;
                break;
            case ("medium"):
                name = "Medium Ability Flask";
                xp = 10;
                buff = 3;
                break;
            case ("large"):
                name = "Large Attack Flask";
                xp = 15;
                buff = 4;
                break;
        }
    }
}
