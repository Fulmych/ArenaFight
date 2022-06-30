package lexicon.se;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {
    Fighter p = new Fighter();
    @Test
    void getMaxHitpoints() {
        p.setMaxHitpoints(20);
        int getMaxHitpoints = p.getMaxHitpoints();
        Assertions.assertEquals(20, 20);
    }

    @Test
    void getName() {
        p.setName("Bob");
        String getName = p.getName();
        Assertions.assertEquals("Bob", "Bob");
    }

    @Test
    void getStrength() {
        p.setStrength(5);
        int getStrength = p.getStrength();
        Assertions.assertEquals(5, 5);
    }

    @Test
    void getHitpoints() {
        p.setHitpoints(20);
        int getHitpoints = p.getHitpoints();
        Assertions.assertEquals(20, 20);
    }

    @Test
    void getScore() {
        p.addToScore(20);
        int getScore = p.getScore();
        Assertions.assertEquals(20, 20);
    }

    @Test
    void getHistory() {
        p.addToHistory("Bob");
        String[] getHistory = p.getHistory();
        Assertions.assertEquals("Bob", "Bob");
    }

    @Test
    void getM() {
        p.addToMoney(50);
        int getM = p.getM();
        Assertions.assertEquals(50, 50);
    }

    @Test
    void getInfo() {
        p.setName("Bob");
        p.setHitpoints(20);
        p.setStrength(4);
        String getInfo = p.getInfo();
        Assertions.assertEquals("Name: " + p.getName() + "\nStrength: " + p.getStrength() + "\nHitpoints: " + p.getHitpoints(), "Name: " + p.getName() + "\nStrength: " + p.getStrength() + "\nHitpoints: " + p.getHitpoints());
    }
}