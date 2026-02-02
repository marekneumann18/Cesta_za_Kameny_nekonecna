package player;

public class Item {
    private String id;

    private String name;

    public Item() {

    }

    public String getId() {
        return id;
    }

    public void setString(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nazev='" + name + '\'' +
                '}';
    }
}
