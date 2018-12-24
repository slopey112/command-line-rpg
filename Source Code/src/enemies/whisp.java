package enemies;
import items.HealingPotion;
import items.MagicPotion;
import objects.enemy;
import objects.item;
import objects.power;
import powers.zap;

import java.util.Random;

public class whisp extends enemy {
    public whisp(int a) {
        drops = new item[5];
        drops[0] = new HealingPotion("small");
        drops[1] = new HealingPotion("small");
        drops[2] = new MagicPotion("small");
        drops[3] = new HealingPotion("medium");
        drops[4] = new MagicPotion("medium");
        name = "whisp";
        level = a;
        abilities = new power[1];
        abilities[0] = new zap(level);
        crit = 5;
        hp = (level * 2) + 15;
        atk = level + 1;
        def = level / 2;
        atkMsg = "The whisp shocks you with it's ghastly tentacles!";
        if (level <= 13) xpdrop = level + 2;
        else xpdrop = 15;
    }
}

