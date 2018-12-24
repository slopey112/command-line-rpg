package enemies;

import items.AbilityFlask;
import items.AttackFlask;
import objects.enemy;
import objects.item;
import objects.power;
import powers.laser_beam;

public class cephalon extends enemy {
    public cephalon (int lvl) {
        name = "cephalon";
        level = lvl;
        atk = lvl + 25;
        hp = lvl + 40;
        def = lvl / 2 - 5;
        crit = 10;
        drops = new item[3];
        xpdrop = lvl + 5;
        drops[0] = new AttackFlask("medium");
        drops[1] = new AttackFlask("large");
        drops[2] = new AbilityFlask("large");
        atkMsg = "Cephalon barrages its tentacles at you!";
        abilities = new power[1];
        abilities[0] = new laser_beam(lvl);
    }
}
