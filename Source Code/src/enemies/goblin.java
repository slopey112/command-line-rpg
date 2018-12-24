package enemies;
import items.AttackFlask;
import items.EmptyBottle;
import items.HealingPotion;
import items.MagicPotion;
import objects.enemy;
import objects.item;
import objects.power;
import powers.shank;

public class goblin extends enemy {
    public goblin (int lvl, int pDef) {
        drops = new item[7];
        drops[0] = new EmptyBottle();
        drops[1] = new MagicPotion("small");
        drops[2] = new MagicPotion("small");
        drops[3] = new HealingPotion("medium");
        drops[4] = new MagicPotion("medium");
        drops[5] = new MagicPotion("medium");
        drops[6] = new AttackFlask("small");
        name = "goblin";
        level = lvl;
        hp = (int) Math.round(level * 1.5) + 20;
        atk = level + 3;
        def = level / 4;
        atkMsg = "The goblin stabs you with it's sharp knife!";
        abilities = new power[1];
        abilities[0] = new shank(level, pDef);
        if (level <= 15) xpdrop = level + 4;
        else xpdrop = 20;
    }
}
