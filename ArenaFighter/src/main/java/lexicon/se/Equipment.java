package lexicon.se;

import java.util.Scanner;

public class Equipment extends Fighter {
    Scanner scan = new Scanner(System.in);
    private boolean hOn = false;
    private boolean bPOn = false;
    private boolean gOn = false;
    private boolean boOn = false;

    public void shop(Fighter p) {
        boolean ret = false;
        while (!ret) {
            if (!hOn || !bPOn || !gOn || !boOn) {
                System.out.println("Welcome!\nHere are the items that you can buy. Or you can return to the battle.");
                String h = "Helmet";
                if (!hOn) {
                    System.out.println(h + " - adds 2 hitpoints,  20 gold");
                }
                String bP = "Breastplate";
                if (!bPOn) {
                    System.out.println(bP + " - adds 4 hitpoins,  40 gold");
                }
                String g = "Gloves";
                if (!gOn) {
                    System.out.println(g + " - adds 2 damage, 50 gold");
                }
                String bo = "Boots";
                if (!boOn) {
                    System.out.println(bo + " - adds 1 damage, 30 gold");
                }
                String n = scan.nextLine();
                if (n.equalsIgnoreCase("helmet")) {
                    if (p.getM() >= 20) {
                        p.addToMoney(-20);
                        System.out.println("You have bought the " + h + ".");
                        hOn = true;
                        int sH = 2;
                        p.setMaxHitpoints(p.getMaxHitpoints() + sH);
                        p.setHitpoints(p.getMaxHitpoints() + sH);
                        System.out.println("Do you want to continue to shop or return to battle?");
                    } else {
                        System.out.println("You don't have enough money. Choose something else or return to battle.");
                    }
                }
                if (n.equalsIgnoreCase("breastplate")) {
                    if (p.getM() >= 40) {
                        p.addToMoney(-40);
                        System.out.println("You have bought the " + bP + ".");
                        bPOn = true;
                        int sBP = 4;
                        p.setMaxHitpoints(p.getMaxHitpoints() + sBP);
                        p.setHitpoints(p.getMaxHitpoints() + sBP);
                        System.out.println("Do you want to continue to shop or return to battle?");
                    } else {
                        System.out.println("You don't have enough money. Choose something else or return to battle.");
                    }
                }
                if (n.equalsIgnoreCase("gloves")) {
                    if (p.getM() >= 50) {
                        p.addToMoney(-50);
                        System.out.println("You have bought the " + g + ".");
                        gOn = true;
                        int sG = 2;
                        p.setStrength(p.getStrength() + sG);
                        System.out.println("Do you want to continue to shop or return to battle?");
                    } else {
                        System.out.println("You don't have enough money. Choose something else or return to battle.");
                    }
                }
                if (n.equalsIgnoreCase("boots")) {
                    if (p.getM() >= 30) {
                        p.addToMoney(-30);
                        System.out.println("You have bought the " + bo + ".");
                        boOn = true;
                        int sBo = 1;
                        p.setStrength(p.getStrength() + sBo);
                        System.out.println("Do you want to continue to shop or return to battle?");
                    } else {
                        System.out.println("You don't have enough money. Choose something else or return to battle.");
                    }
                }
                if (n.equalsIgnoreCase("return")) {
                    ret = true;
                }
            }
            if (hOn && bPOn && gOn && boOn){
                System.out.println("There's nothing left in the shop. You will be returned to battle.");
                ret =true;
            }
        }
    }
}