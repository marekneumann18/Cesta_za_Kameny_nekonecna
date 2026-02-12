package command;

import characters.Character;
import game.GameData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtokTest {
    Character character;
    Player player;
    GameData gameData;
    Utok utok;

    @BeforeEach
    void init() {
        character = new Character();
        player = new Player("h", 10);
        utok = new Utok(player, gameData);

    }

    @Test
    void hasInfinityStones() {
       player.addItem("kamenmoci");
       player.addItem("kamenreality");
       player.addItem("kamencasu");
       player.addItem("kamenprostoru");
       player.addItem("kamenduse");
       player.addItem("kamenmysli");
       assertTrue(utok.hasInfinityStones());
    }

    @Test
    void exit() {
        player.setHp(0);
        assertTrue(utok.exit());
        player.setHp(5);
        assertFalse(utok.exit());
        boolean gameOver = true;
        assertTrue(gameOver);



    }
}