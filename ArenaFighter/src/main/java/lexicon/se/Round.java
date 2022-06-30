package lexicon.se;

import java.util.concurrent.TimeUnit;

public class Round {
    private int roundNumber = 1;
    private String roundLog;

    public int getRoundNumber() {
        return roundNumber;
    }
    public void fight(Fighter p, Fighter o){
        System.out.println("Round: " + this.getRoundNumber());
        int l = p.attack(p.getStrength()) - o.attack(o.getStrength());
        if (l>0){
            System.out.print(p.getName() + " dealt ");
            System.out.print(p.getStrength());
            System.out.println(" damage.");
            o.takeDamage(p.getStrength());
        } else if (l<0){
            System.out.print(o.getName() + " dealt ");
            System.out.print(o.getStrength());
            System.out.println(" damage.");
            p.takeDamage(o.getStrength());
        }
        else {
            System.out.println("No damage dealt.");
        }
        System.out.println(p.getName() + "\nHP: " + p.getHitpoints());
        System.out.println(o.getName() + "\nHP: " + o.getHitpoints());
        System.out.println("");
        roundNumber++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getRoundLog(){
        return roundLog;
    }
}
