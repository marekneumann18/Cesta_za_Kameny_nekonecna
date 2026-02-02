package characters;

import java.util.HashMap;

public class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isDefeated = false;
    private HashMap<String, String> dialogs;

    public Character() {

    }

    public HashMap<String, String> getDialogs() {
        return dialogs;
    }

    public void setDialogs(HashMap<String, String> dialogs) {
        this.dialogs = dialogs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isDefeated() {
        return isDefeated;
    }

    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }

    @Override
    public String toString() {
        return "Postava{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
