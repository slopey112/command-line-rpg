package objects;

import items.EmptyBottle;

import java.util.Random;

public class enemy {
    public int hp;
    public int atk;
    public int crit;
    public int mana;
    public int ap;
    public int level;
    public int xpdrop;
    public int def;
    public power[] abilities;
    public item[] drops;
    public String name;
    public String atkMsg;

    public int getXp() {
        return xpdrop;
    }
    public int getHp() {
        return hp;
    }
    public String getName() {
        return name;
    }
    public void dealDmg(int a) {
        int c = hp - (a - def);
        if (c < hp) hp = c;
    }
    public void getInfo() {
        System.out.println(name + ", level " + level);
        System.out.println("HP:  " + hp);
        System.out.println("ATK: " + atk);
        System.out.println("DEF: " + def);
        System.out.println("EXP: " + xpdrop);
    }
    public item getDrop() {
        Random a = new Random();
        int seg = drops.length / 3;
        int yes = a.nextInt(4);
        if (yes != 3) {
            if (level <= 10) {
                return drops[a.nextInt(seg + 1)];
            } else if (level <= 30) {
                return drops[a.nextInt(seg * 2 + 1)];
            } else {
                return drops[a.nextInt(drops.length)];
            }
        } else {
            return new EmptyBottle();
        }
    }
    public void getAtkMsg() {
        System.out.println(atkMsg);
    }
    public int getCrit() {
        return crit;
    }
    public int getAtk() {
        return atk;
    }
    public int getLevel() {
        return level;
    }
    public power[] getAbilities() {
        return abilities;
    }
}
