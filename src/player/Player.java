package player;

import game.GameData;
import location.Location;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private GameData gameData;
    private Location currentLocation;
    private ArrayList<String > items = new ArrayList<>();

    public Player(String name, int hp,GameData gameData) {
        this.name = name;
        setHp(hp);
        this.gameData = gameData;
        this.currentLocation = getCurrentLocation();

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
    public void addItem(String item) {
        this.items.add(item);
    }

    public void removeItem(String item) {
        this.items.remove(item);
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
