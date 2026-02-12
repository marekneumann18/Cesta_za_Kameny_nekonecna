package player;

import game.GameData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    private GameData data;

    @Test
    void addItem() {
        Player p = new Player("dw",1,data);
        p.addItem("test");
        assertEquals("test",p.getItems().get(0));
    }

    @Test
    void removeItem() {
        Player p = new Player("dw",1,data);
        p.addItem("test");
        p.removeItem("test");
        assertNull(p.getItems());
    }
}