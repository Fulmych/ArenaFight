package lexicon.se;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner con = new Scanner(System.in);
        Fighter p = new Fighter();
        Fighter o = new Fighter();
        System.out.print("Choose a name for your fighter: ");
        String a = scan.nextLine();
        p.setName(a);
        System.out.println("Choose your strength between 1 and 4: ");
        int b = scan.nextInt();
        while (b<1){
            System.out.println("You should have at least 1 strength. Choose again: ");
            b = scan.nextInt();
        }
        while (b > 4){
            System.out.println("That was above 4. Choose again: ");
            b = scan.nextInt();
        }
        p.setStrength(b);
        System.out.println("Choose your hitpoints between 10 and 20: ");
        int c = scan.nextInt();
        while (c<10){
            System.out.println("You should choose hitpoints above 10. Choose again: ");
            c = scan.nextInt();
        }
        while (c>20){
            System.out.println("You should choose hitpoints below 20. Choose again: ");
            c = scan.nextInt();
        }
        p.setMaxHitpoints(c);
        p.setHitpoints(p.getMaxHitpoints());
        int opStrength = ThreadLocalRandom.current().nextInt(1,5);
        int opHitpoints = ThreadLocalRandom.current().nextInt(10,21);
        o.setName("TestDummy");
        o.setStrength(opStrength);
        o.setHitpoints(opHitpoints);
        Round fight = new Round();
        Equipment gear = new Equipment();
        while (p.getHitpoints() > 0 && !p.isRetired()){
            System.out.println(p.getInfo());
            System.out.println(o.getInfo());
            while (o.getHitpoints() > 0 && p.getHitpoints()>0){
                fight.fight(p,o);
            }
            if (p.getHitpoints()>0){
                p.addToMoney(100);
                p.addToScore(1);
                while (o.getHitpoints()<=0 && !p.isRetired()) {
                    p.addToHistory(o.getName());
                    System.out.println(p.getM());
                    System.out.println("Do you want to retire, shop or continue? ");
                    String n = con.nextLine();
                    if (n.equalsIgnoreCase("retire")) {
                        p.retire();
                    } else if (n.equalsIgnoreCase("shop")) {
                        gear.shop(p);
                    } else if (!p.isRetired()) {
                        p.setHitpoints(p.getMaxHitpoints());
                        o.setHitpoints(opHitpoints);
                        System.out.println(o.getInfo());
                    }
                }
            }
        }
        System.out.println("You have won " + p.getScore() + " times.");
        p.printHistory();
    }
}
