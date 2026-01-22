package player;

import location.Location;

public class Player {
    private String jmeno;
    private int zivoty ;
    private Location currentLocaion;

    public Player(String jmeno, int zivoty) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
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
    public Location getCurrentLocaion() {
        return currentLocaion;
    }
    public void setCurrentLocaion(Location currentLocaion) {
        this.currentLocaion = currentLocaion;
    }

    @Override
    public String toString() {
        return "Player{" +
                "jmeno='" + jmeno + '\'' +
                ", zivoty=" + zivoty +
                ", currentLocaion=" + currentLocaion +
                '}';
    }
}
