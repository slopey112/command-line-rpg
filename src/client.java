import enemies.goblin;
import enemies.whisp;
import objects.enemy;
import objects.player;
import objects.item;
import objects.power;

import java.util.*;
import java.io.*;

public class client {
    private static player main;
    private static String[] mobs = {"whisp", "goblin"};
    public static boolean gameNew;
    public static final String invalid = "Sorry, that's not a valid choice.";
    public static void setup() throws IOException {
        main = new player();
        System.out.println("\nCHARACTER CREATION\n");
        System.out.println("Hi, what's your name?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String r = in.readLine().trim();
        if (r == "highscores") {
            System.out.println("Hey, I see what you're trying to do.");
            return;
        }
        main.setName(r);
        System.out.println("Greetings, " + main.getName() + "!");
        boolean running = true;
        while (running) {
            System.out.println("What will your class be? Enter 'o' for options. (When in doubt, enter 'o'.)");
            String choice = in.readLine().trim().toLowerCase();
            if (choice.equals("o")) {
                System.out.println("(M)age: The arcane master.");
                System.out.println("(K)night: The valiant hero.");
                System.out.println("(A)ssassin: The silent killer.");
                System.out.println("(E)ngineer: The crafty builder.");
                System.out.println("Type the corresponding letter for more info, or 'b' to go back to selection.");
                switch (choice = in.readLine().trim().toLowerCase()) {
                    case ("b"):
                        break;
                    case ("m"):
                        main.setToClass("mage");
                        main.getInfo();
                        break;
                    case ("k"):
                        main.setToClass("knight");
                        main.getInfo();
                        break;
                    case ("a"):
                        main.setToClass("assassin");
                        main.getInfo();
                        break;
                    case ("e"):
                        main.setToClass("engineer");
                        main.getInfo();
                        break;
                    default:
                        System.out.println(invalid);
                        break;
                }
            } else {
                switch (choice) {
                    case ("m"):
                        main.setToClass("mage");
                        running = false;
                        break;
                    case ("k"):
                        main.setToClass("knight");
                        running = false;
                        break;
                    case ("a"):
                        main.setToClass("assassin");
                        running = false;
                        break;
                    case ("e"):
                        main.setToClass("engineer");
                        running = false;
                        break;
                    default:
                        System.out.println(invalid);
                        break;
                }
            }
        }
        System.out.println("You're all set " + main.getName() + "!");
        System.out.println("Here are your stats: ");
        main.getInfo();
    }
    public static void begin() throws IOException {
        FileReader a = new FileReader("data.txt");
        gameNew = false;
        System.out.println("WELCOME TO DUNGEON CRAWLERS");
        System.out.println("a game designed by slopey112.");
        boolean running = true;
        while (running) {
            System.out.println("\nFirst time playing? (Y/N)");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String result = in.readLine().trim().replaceAll("\\s+", "");
            if (result.equals("Y")) {
                System.out.println("\nHi! Welcome to the game.");
                System.out.println("The goal of this game is to kill as many monsters as possible.");
                System.out.println("Most of the time, you can enter 'o' for more help.");
                System.out.println("Let's quickly set up your character.");
                setup();
                running = false;
            } else if (result.equals("N")) {
                while (true) {
                    System.out.println("New game? (Y/N) ");
                    result = in.readLine().trim();
                    if (result.equals("Y")) {
                        System.out.println("Alright. Setting up your character...");
                        setup();
                        break;
                    } else if (result.equals("N")) {
                        while (true) {
                            System.out.println("Ok. What was your old character name?");
                            String name = in.readLine().trim();
                            try {
                                BufferedReader data = new BufferedReader(new FileReader(name + ".txt"));
                                main = new player();
                                main.setHp(Integer.parseInt(data.readLine()));
                                main.setAtk(Integer.parseInt(data.readLine()));
                                main.setDef(Integer.parseInt(data.readLine()));
                                main.setCrit(Integer.parseInt(data.readLine()));
                                main.setMana(Integer.parseInt(data.readLine()));
                                main.setAp(Integer.parseInt(data.readLine()));
                                main.setLevel(Integer.parseInt(data.readLine()));
                                main.setXp(Integer.parseInt(data.readLine()));
                                main.setName(data.readLine());
                                main.setCclass(data.readLine());
                                System.out.println("Welcome back, " + main.getName() + "!");
                                System.out.println("Here are your stats before we head into the game: ");
                                main.getInfo();
                                break;
                            } catch (FileNotFoundException e) {
                                System.out.println("Sorry. Character not found.");
                            }
                        }
                    }
                }
                running = false;
            } else {
                System.out.println(invalid);
            }
        }
    }
    public static void gameplay() throws IOException {
        System.out.println("Alright. This is it. Time for the game to actually start.");
        System.out.println("\n\n\n");
        System.out.println("_  \\     ____");
        System.out.println("| | \\   ____ |");
        System.out.println("| | |       | | ");
        System.out.println("| | |       | |");
        System.out.println("| | |       | |");
        System.out.println("| / /       | |");
        System.out.println("|/ /        | |");
        System.out.println("_ /  _______|_\n\n\n");
        boolean alive = true;
        int counter = 1;
        Random a = new Random();
        while (alive) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Stage " + counter);
            if (counter == 1) {
                System.out.println("Alright, first stage. Let's see how well you can do, newbie.\n");
            }
            enemy[] choices = new enemy[3];
            for (int i = 0; i < 3; i++) {
                int ranNum = a.nextInt(mobs.length);
                int dif = a.nextInt(3);
                int lvl;
                if (i == 0) {
                    if (main.getLevel() <= 3) {
                        lvl = 1;
                    } else {
                        lvl = main.getLevel() - dif - 1;
                    }
                } else if (i == 1) {
                    lvl = main.getLevel();
                } else {
                    lvl = main.getLevel() + dif + 1;
                }
                switch (ranNum) {
                    case (0):
                        choices[i] = new whisp(lvl);
                        break;
                    case (1):
                        choices[i] = new goblin(lvl, main.getDef());
                        break;
                }
            }
            boolean test = true;
            enemy fight = new enemy();
            while (test) {
                System.out.println("Which monster will you fight?");
                System.out.println("(a):");
                choices[0].getInfo();
                System.out.println("(b):");
                choices[1].getInfo();
                System.out.println("(c):");
                choices[2].getInfo();
                String selection = in.readLine().trim().toLowerCase();
                switch (selection) {
                    case ("a"):
                        fight = choices[0];
                        test = false;
                        break;
                    case ("b"):
                        fight = choices[1];
                        test = false;
                        break;
                    case ("c"):
                        fight = choices[2];
                        test = false;
                        break;
                    default:
                        System.out.print(invalid);
                        break;
                }
            }
            boolean enemyAlive = true;
            Random start = new Random();
            int turn = start.nextInt(2);
            boolean flee = false;
            boolean signal = false;
            int skip = -1;
            while (enemyAlive) {
                if (turn == 0) {
                        System.out.println("\nIt's your turn, " + main.getName() + "!");
                        System.out.println("(A)ttack");
                        System.out.println("(I)tem");
                        System.out.println("(F)lee");
                        System.out.println("(P)ower");
                        String choice = in.readLine().toLowerCase().trim();
                        switch (choice) {

                            case ("a"):
                                int crit = start.nextInt(100) + 1;
                                int atk = main.getAtk();
                                if (crit <= main.getCrit()) {
                                    atk = atk * 2;
                                    System.out.println("CRITICAL STRIKE!");
                                }
                                int before = fight.getHp();
                                fight.dealDmg(atk);
                                if (fight.getHp() <= 0) {
                                    enemyAlive = false;
                                    System.out.println(fight.getName().toUpperCase() + " KO'ed");
                                } else {
                                    System.out.println(fight.getName().toUpperCase());
                                    System.out.println("HP: " + before + " --> " + fight.getHp());
                                }
                                break;

                            case ("i"):
                                ArrayList<item> inventory = main.getInventory();
                                boolean caseI = true;
                                while (caseI) {
                                    if (inventory.size() == 0) {
                                        System.out.println("Sorry, it looks like you don't have any items.");
                                        turn = 0;
                                        signal = true;
                                        break;
                                    } else {
                                        boolean z = true;
                                        while (z) {
                                            for (int i = 0; i < inventory.size(); i++) {
                                                System.out.println((i + 1) + ": " + inventory.get(i).getName());
                                            }
                                            choice = in.readLine();
                                            if (choice.equals("o")) {
                                                while (true) {
                                                    System.out.println("Which of the above items do you need info on?");
                                                    choice = in.readLine();
                                                    try {
                                                        int sel = Integer.parseInt(choice);
                                                        if (sel > inventory.size()) {
                                                            System.out.println(invalid);
                                                        } else {
                                                            System.out.println(inventory.get(sel - 1).getDescription());
                                                            caseI = false;
                                                            break;
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println(invalid);
                                                    }
                                                }
                                            } else {
                                                try {
                                                    int sel = Integer.parseInt(choice);
                                                    if (sel > inventory.size()) {
                                                        System.out.println(invalid);
                                                    } else {
                                                        item sItem = inventory.get(sel - 1);
                                                        switch (sItem.getField()) {
                                                            case ("hp"):
                                                                int b4 = main.getHp();
                                                                main.setHp(b4 + sItem.getBuff());
                                                                System.out.println("HP increased from " + b4 + " ---> " + main.getHp());
                                                                main.removeInventory(sel);
                                                                z = false;
                                                                caseI = false;
                                                                break;
                                                            case ("mana"):
                                                                b4 = main.getMana();
                                                                main.setMana(main.getMana() + sItem.getBuff());
                                                                System.out.println("Mana increased from " + b4 + " ---> " + main.getMana());
                                                                main.removeInventory(sel);
                                                                caseI = false;
                                                                z = false;
                                                                break;
                                                            case ("eb"):
                                                                System.out.println("Nothing happened.");
                                                                main.removeInventory(sel);
                                                                z = false;
                                                                caseI = false;
                                                                break;
                                                            case ("attack"):
                                                                b4 = main.getAp();
                                                                main.setAtk(main.getAtk() + sItem.getBuff());
                                                                System.out.println("ATK increased from " + b4 + " ---> " + main.getAtk());
                                                                caseI = false;
                                                                z = false;
                                                                break;
                                                        }
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println(invalid);
                                                }
                                            }
                                        }

                                    }
                                }
                                break;

                            case ("f"):
                                System.out.println("You chose to run away!");
                                counter--;
                                enemyAlive = false;
                                flee = true;
                                break;

                            case ("p"):
                                ArrayList<power> pList = main.getAbilities();
                                for (int i = 0; i < pList.size(); i++) {
                                    System.out.println((i + 1) + ": " + pList.get(i).getName());
                                }
                                while (true) {
                                    String sel = in.readLine().trim().toLowerCase();
                                    if (sel.equals("o")) {
                                        System.out.println("Which of these do you need more info on?");
                                        sel = in.readLine().trim().toLowerCase();
                                        try {
                                            int pick = Integer.parseInt(sel);
                                            if (pick > pList.size()) {
                                                System.out.println(invalid);
                                            } else {
                                                power curr = pList.get(pick - 1);
                                                System.out.println(curr.getName().toUpperCase() + ": " + curr.getDescription());
                                                System.out.println("Cost: " + curr.getCost());
                                                signal = true;
                                                break;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println(invalid);
                                        }
                                    } else {
                                        try {
                                            int pick = Integer.parseInt(sel);
                                            if (pick > pList.size()) {
                                                System.out.println(invalid);
                                            } else if (main.getMana() < pList.get(pick - 1).getCost()) {
                                                System.out.println("Sorry, you don't seem to have enough mana to use that move.");
                                            } else {
                                                power now = pList.get(pick - 1);
                                                skip = now.getSkips();
                                                if (now.getAffectsPlayer() == 1) {
                                                    int nowHP = fight.getHp();
                                                    int nMana = main.getMana();
                                                    fight.dealDmg(now.getValue());
                                                    if (fight.getHp() <= 0) {
                                                        System.out.println(fight.getName().toUpperCase() + " KO'ed");
                                                        enemyAlive = false;
                                                        break;
                                                    } else {
                                                        System.out.println(fight.getName().toUpperCase());
                                                        System.out.println("HP:   " + nowHP + " ---> " + fight.getHp());
                                                        System.out.println(main.getName().toUpperCase());
                                                        main.setMana(main.getMana() - now.getCost());
                                                        System.out.println("MANA: " + nMana + " ---> " + main.getMana());
                                                        break;
                                                    }
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println(invalid);
                                        }
                                    }
                                }
                                break;
                        }
                    } else {
                        int action = a.nextInt(10);
                        System.out.println("\nIt's the " + fight.getName().toUpperCase() + "'s turn!!!");
                        System.out.println(action);
                        if (fight.getHp() <= 5 && a.nextInt(5) == 0) {
                            System.out.println(fight.getName() + " has decided to flee!");
                            flee = true;
                        } else if (action != 9 && action != 8) {
                            fight.getAtkMsg();
                            int b4 = main.getHp();
                            int crit = a.nextInt(100) + 1;
                            int atk = fight.getAtk();
                            if (crit <= fight.getCrit()) {
                                System.out.println("CRITICAL HIT!");
                                atk *= 2;
                            }
                            main.dealDmg(atk);
                            if (main.getHp() <= 0) {
                                System.out.println("Sorry " + main.getName() + "...");
                                System.out.println("You're not going to make it...");
                                alive = false;
                                break;
                            } else {
                                System.out.println(main.getName().toUpperCase());
                                System.out.println("HP: " + b4 + " ---> " + main.getHp());
                            }
                        } else {
                            System.out.println(fight.getName().toUpperCase() + " uses " + fight.getAbilities()[0].getName().toUpperCase());
                            int b4 = main.getHp();
                            main.dealDmg(fight.getAbilities()[0].getValue());
                            if (main.getHp() <= 0) {
                                System.out.println("Sorry " + main.getName() + "...");
                                System.out.println("You're not going to make it...");
                                System.out.println("that " + fight.getAbilities()[0].getName() + "'s strength was just too much...");
                                alive = false;
                                break;
                            } else {
                                System.out.println(main.getName().toUpperCase());
                                System.out.println("HP: " + b4 + " ---> " + main.getHp());
                            }
                        }
                    }
                    if (!enemyAlive && !flee) {
                        System.out.println("ENEMY REWARDS");
                        item reward = fight.getDrop();
                        System.out.println("You received a " + reward.getName() + " from the " + fight.getName());
                        main.addInventory(reward);
                        if (main.getInventory().size() > 5) {
                            System.out.println("ERROR: It seems you have too many items!");
                            System.out.println("Cash one of your current items out for XP.");
                            ArrayList<item> inven = main.getInventory();
                            for (int i = 0; i < inven.size(); i++) {
                                System.out.println("(" + (i + 1) + ") " + inven.get(i).getName() + ": " + inven.get(i).getXp() + " XP");
                            }
                            while (true) {
                                String choice = in.readLine();
                                try {
                                    int sel = Integer.parseInt(choice);
                                    if (sel > 6) System.out.println(invalid);
                                    else {
                                        System.out.println("Alright, cashing in " + inven.get(sel-1).getName() + " for " + inven.get(sel-1).getXp() + " XP");
                                        level(inven.get(sel-1).getXp());
                                        main.removeInventory(sel);
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println(invalid);
                                }
                            }
                        }
                        System.out.println("\nLEVELING REWARDS");
                        level(fight.getXp());

                    }
                    if (flee) {
                        break;
                    }
                    if (!signal) {
                        if (turn == 0) turn = 1;
                        else turn = 0;
                    }
                    if (skip == 0 && enemyAlive) {
                        turn = 0;
                        System.out.println(fight.getName() + "'s turn was skipped!");
                    }
                }
                counter++;

        }
        end(counter);
    }
    public static void level(int xp) {
        int threshold = main.getLevel() * 10;
        main.setXp(main.getXp() + xp);
        if (main.getXp() >= threshold) {
            System.out.println("Congrats! You leveled up from " + main.getLevel() + " to " + (main.getLevel() + 1));
            System.out.println("Let's change a few of your stats for you...");
            main.setHp(main.getHp() + 5);
            main.setMana(main.getMana() + 5);
            main.setAtk(main.getAtk() + 1);
            main.setDef(main.getDef() + 1);
            main.setAp(main.getAp() + 1);
            main.setCrit(main.getCrit() + 1);
            main.setLevel(main.getLevel() + 1);
            System.out.println("Meet your new self!");
            main.getInfo();
        } else {
            System.out.println("You are level " + main.getLevel() + " with " + main.getXp() + " XP.");
            System.out.println("You only need " + (threshold - main.getXp()) + " XP more!\n\n");
        }
    }
    public static void end(int stage) throws IOException {
        System.out.println("\nHerein lies the end for " + main.getName() + ".");
        System.out.println("Final stats: ");
        main.getInfo();
        System.out.println("\nHighscores:");
        BufferedReader hs = new BufferedReader(new FileReader("highscores.txt"));
        String a;
        ArrayList<Integer> scores = new ArrayList<>();
        while ((a = hs.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(a);
            scores.add(Integer.parseInt(str.nextToken()));
        }
        Collections.sort(scores);
        hs.close();
        if (scores.size() == 0) {
            System.out.println("Sorry, there doesn't seem to be any records.");
        } else if (scores.size() == 1) {
            System.out.println("1st: " + a + " at stage " + scores.get(scores.size() - 1));
        } else if (scores.size() == 2) {
            BufferedReader asdf = new BufferedReader(new FileReader("highscores.txt"));
            StringTokenizer str1 = new StringTokenizer(asdf.readLine());
            StringTokenizer str2 = new StringTokenizer(asdf.readLine());
            int check1 = Integer.parseInt(str1.nextToken());
            String entry1 = str1.nextToken();
            int check2 = Integer.parseInt(str2.nextToken());
            String entry2 = str2.nextToken();
            if (check1 > check2) {
                System.out.println("1st: " + entry1 + " at stage " + check1);
                System.out.println("2nd: " + entry2 + " at stage " + check2);
            } else {
                System.out.println("1st: " + entry2 + " at stage " + check2);
                System.out.println("2nd: " + entry1 + " at stage " + check1);
            }
            asdf.close();
        } else {
            int[] three = new int[3];
            String[] threeStr = new String[3];
            three[0] = scores.get(scores.size() - 1);
            three[1] = scores.get(scores.size() - 2);
            three[2] = scores.get(scores.size() - 3);
            BufferedReader asdf = new BufferedReader(new FileReader("highscores.txt"));
            for (int i = 0; i < scores.size(); i++) {
                StringTokenizer z = new StringTokenizer(asdf.readLine());
                String name = z.nextToken();
                int w = Integer.parseInt(z.nextToken());
                if (w == three[0]) {
                    threeStr[0] = name;
                } else if (w == three[1]) {
                    threeStr[1] = name;
                } else if (w == three[2]) {
                    threeStr[2] = name;
                }
            }
            asdf.close();
            System.out.println("1st: " + threeStr[0] + " at stage " + three[0]);
            System.out.println("2nd: " + threeStr[1] + " at stage " + three[1]);
            System.out.println("3rd: " + threeStr[2] + " at stage " + three[2]);
        }
        boolean u = true;
        while (u) {
            System.out.println("\nSave your score? (Y/N)");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String response = in.readLine().toLowerCase();
            switch (response) {
                case ("y"):
                    PrintWriter out = new PrintWriter(new FileOutputStream(new File("highscores.txt"), true));
                    out.println(stage + " " + main.getName());
                    out.close();
                    newGame();
                    u = false;
                    break;
                case ("n"):
                    newGame();
                    u = false;
                    break;
            }
        }

    }
    public static void newGame() throws IOException {
        System.out.println("Alright. Our path ends here. Goodbye.");
        System.out.println("Unless you wish to start a new game?");
        boolean y = true;
        while (y) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String a = in.readLine().toLowerCase().trim();
            switch (a) {
                case ("y"):
                    System.out.println("Great!");
                    System.out.println("Let's start anew.");
                    gameNew = true;
                    y = false;
                    break;
                case ("n"):
                    System.out.println("Then our path ends here.");
                    System.out.println("Goodbye.");
                    gameNew = false;
                    y = false;
                    break;
                default:
                    System.out.println(invalid);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        boolean running = true;
        Random a = new Random();
        while (running) {
            begin();
            gameplay();
            if (!gameNew) running = false;
        }
    }
}