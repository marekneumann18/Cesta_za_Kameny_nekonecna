package location;

import java.util.ArrayList;

public class Location {
    private String id, name, description;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> charactersAtLocation = new ArrayList<>();


    public Location() {


    }

    public ArrayList<String> getCharactersAtLocation() {
        return charactersAtLocation;
    }

    public void setCharactersAtLocation(ArrayList<String> charactersAtLocation) {
        this.charactersAtLocation = charactersAtLocation;
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

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public void removeItem(String item) {
        items.remove(item);

    }

    public void addItem(String item) {
        items.add(item);

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }
}