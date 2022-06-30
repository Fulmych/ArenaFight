package lexicon.se;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Fighter {
    private int m = 0;
    private String name;
    private int strength;
    private int maxHitpoints;
    private int hitpoints = maxHitpoints;
    private int score;
    private boolean retired;
    private String[] history = new String[0];
    private  boolean alive;
    Random randMod = new Random();

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMaxHitpoints(int maxHitpoints) {
        this.maxHitpoints = maxHitpoints;
    }
    public int getMaxHitpoints(){return maxHitpoints;}
    public void setHitpoints(int hitpoints){this.hitpoints = hitpoints;}

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHitpoints() {
        return hitpoints;
    }


    public int getScore() {
        return score;
    }

    public String[] getHistory() {
        return history;
    }

    public int attack(int randomModifier){
        int strengthMod = ThreadLocalRandom.current().nextInt(1,6);
        int f = this.getStrength() + strengthMod;
        System.out.println(getName() + "'s Attack Score: " + f);
        return f;
    }
    public void addToScore(int scoreToAdd){
        this.score += scoreToAdd;
    }
    public void addToMoney(int moneyToAdd){
        this.m += moneyToAdd;
    }
    public int getM(){
        return m;
    }
    public void takeDamage(int damage){
        this.hitpoints = this.hitpoints-damage;
    }
    public String getInfo(){
        String n = "";
        System.out.println("Name: " + this.name + "\nStrength: " + this.strength + "\nHitpoints: " + this.hitpoints);
        return n;
    }
    public void retire(){
        this.retired = true;
    }
    public boolean isRetired(){
        return retired;
    }
    public boolean isAlive(){
        if (this.hitpoints > 0){
            return alive;
        }
        return !alive;
    }
    public void addToHistory(String log){
        String[] newHistory = new String[history.length+1];
        Arrays.fill(newHistory, log);
        history = newHistory.clone();
    }
    public void printHistory(){
        for (String s : history) {
            System.out.println(s);
        }
    }
}