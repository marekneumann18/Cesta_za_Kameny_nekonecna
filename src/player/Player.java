package player;

import game.GameData;
import location.Location;

public class Player {
    private String jmeno;
    private int zivoty ;
    private GameData gameData;
    private Location currentLocation;

    public Player(String jmeno, int zivoty,GameData gameData) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.gameData = gameData;

        this.currentLocation = getCurrentLocation();
    }
    public Player() {

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

    @Override
    public String toString() {
        return "Player{" +
                "jmeno='" + jmeno + '\'' +
                ", zivoty=" + zivoty +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
