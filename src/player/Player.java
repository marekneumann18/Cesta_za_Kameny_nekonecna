package player;

import command.Inventar;
import game.GameData;
import location.Location;

import java.util.ArrayList;

public class Player {
    private String jmeno;
    private int zivoty ;
    private GameData gameData;
    private Location currentLocation;
    private ArrayList<String > items = new ArrayList<>();

    public Player(String jmeno, int zivoty,GameData gameData) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.gameData = gameData;
        this.currentLocation = getCurrentLocation();

    }
    public Player() {

    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
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
                "jmeno='" + jmeno + '\'' +
                ", zivoty=" + zivoty +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
