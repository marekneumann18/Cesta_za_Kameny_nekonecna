package player;

import game.GameData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    private Player p;



    @org.junit.jupiter.api.BeforeEach
    void init(){
        p = new Player("dw",1);
    }

    @Test
    void addItem() {

        p.addItem("test");
        assertEquals("test",p.getItems().get(0));
    }

    @Test
    void removeItem() {

        p.addItem("test");
        p.addItem("test2");
        p.removeItem("test2");
        assertEquals("test",p.getItems().get(0));
    }
}