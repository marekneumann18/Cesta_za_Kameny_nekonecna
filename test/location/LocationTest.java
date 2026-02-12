package location;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Location l;
    @BeforeEach
    void init(){
        l = new Location();
    }

    @Test
    void removeItem() {
        l.addItem("test");
        l.addItem("test2");
        l.removeItem("test2");
        assertEquals("test",l.getItems().get(0));
    }

    @Test
    void addItem() {
        l.addItem("test");
        assertEquals("test", l.getItems().get(0));
    }
}