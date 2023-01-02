package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGameManager {
    @Test
    public void whoIsTaborda() {
        GameManager game = new GameManager();
        assertEquals("Wrestling",game.whoIsTaborda());
    }
}
