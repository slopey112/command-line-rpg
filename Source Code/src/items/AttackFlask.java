package items;

import objects.item;

public class AttackFlask extends item {
    public AttackFlask(String size) {
        description = "Permanently increases your attack power.";
        field = "attack";
        switch (size) {
            case ("small"):
                name = "Small Attack Flask";
                xp = 5;
                buff = 1;
                break;
            case ("medium"):
                name = "Medium Attack Flask";
                xp = 10;
                buff = 2;
                break;
            case ("large"):
                name = "Large Attack Flask";
                xp = 15;
                buff = 3;
                break;
        }
    }
}
