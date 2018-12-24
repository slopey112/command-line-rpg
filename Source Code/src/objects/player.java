package objects;

import powers.fireball;
import powers.hurricane;

import java.util.ArrayList;
import java.util.Queue;

public class player {
    private int hp;
    private int atk;
    private int def;
    private int crit;
    private int mana;
    private int ap;
    private int level = 1;
    private int xp = 0;
    private ArrayList<item> inventory;
    private ArrayList<power> abilities;
    private String name = "replace_me";
    private String cclass;
    private Queue<item> mage_abilities;

    public player() {
        inventory = new ArrayList<item>();
        abilities = new ArrayList<power>();
    }

    public void getInfo() {
        System.out.println("Stats for \"" + name + "\" the " + cclass);
        System.out.println("HP:              " + hp);
        System.out.println("Attack Power:    " + atk);
        System.out.println("Defense:         " + def);
        System.out.println("Critical Chance: " + crit + "%");
        System.out.println("Mana:            " + mana);
        System.out.println("Ability Power:   " + ap);
        System.out.println("Level:           " + level);
        System.out.println("XP:              " + xp);
    }

    public void setHp(int a) {hp = a;}

    public int getHp() {return hp;}

    public void setAtk(int a) {atk = a;}

    public int getAtk() {return atk;}

    public void setDef(int a) {def = a;}

    public int getDef() {return def;}

    public void setCrit(int a) {crit = a;}

    public int getCrit() {return crit;}

    public void setMana(int a) {mana = a;}

    public int getMana() {return mana;}

    public void setAp(int a) {ap = a;}

    public int getAp() {return ap;}

    public void setLevel(int a) {level = a;}

    public int getLevel() {return level;}

    public void setXp(int a) {xp = a;}

    public int getXp() {return xp;}

    public void setName(String a) {name = a;}

    public String getName() {return name;}

    public void setCclass(String a) {cclass = a;}

    public String getCclass() {return cclass;}

    public ArrayList<item> getInventory() {
        return inventory;
    }

    public void addInventory(item a) {
        inventory.add(a);
    }

    public ArrayList<power> getAbilities() {return abilities;}

    public void removeInventory(int a) {
        inventory.remove(a-1);
    }

    public void dealDmg(int a) {
        int c = hp - (a - def);
        if (c < hp) hp = c;
    }

    public void setToClass(String a) {
        abilities = new ArrayList<power>();
        switch (a) {
            case ("mage"):
                setLevel(1);
                setHp(80);
                setAtk(8);
                setDef(2);
                setCrit(5);
                setMana(40);
                setAp(15);
                setCclass("mage");
                abilities.add(new hurricane(ap, level));
                abilities.add(new fireball(ap));
                break;
            case ("knight"):
                setLevel(1);
                setHp(150);
                setAtk(15);
                setDef(6);
                setCrit(8);
                setMana(20);
                setAp(5);
                setCclass("knight");
                break;
            case ("assassin"):
                setLevel(1);
                setHp(75);
                setAtk(20);
                setDef(3);
                setCrit(15);
                setMana(20);
                setAp(12);
                setCclass("assassin");
                break;
            case ("engineer"):
                setLevel(1);
                setHp(90);
                setAtk(10);
                setDef(4);
                setCrit(6);
                setMana(25);
                setAp(14);
                setCclass("engineer");
                break;
        }
    }
}