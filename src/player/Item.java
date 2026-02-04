package player;

public class Item {

    private String name;

    public Item() {

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
                ", nazev='" + name + '\'' +
                '}';
    }
}
