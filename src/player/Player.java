package player;

import game.GameData;
import location.Location;

import java.util.ArrayList;

/**
 * Represents the player in the game.
 * This class stores player information such as name, health, current location, and inventory.
 * @author Marek
 */
public class Player {
    private String name;
    private int hp;
   ;
    private Location currentLocation;
    private ArrayList<String> items;

    /**
     * Constructs a new Player object.
     * @param name The player's name.
     * @param hp The player's initial health points.
     */
    public Player(String name, int hp) {
        this.name = name;
        setHp(hp);

        this.currentLocation = getCurrentLocation();
        items = new ArrayList<>();

    }


    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Adds an item to the player's inventory.
     * @param item The name of the item to add.
     */
    public void addItem(String item) {

        items.add(item);
    }

    /**
     * Removes an item from the player's inventory.
     * @param item The name of the item to remove.
     */
    public void removeItem(String item) {
        items.remove(item);
    }


    @Override
    public String toString() {
        return "Player{" +
                "jmeno='" + name + '\'' +
                ", zivoty=" + hp +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
