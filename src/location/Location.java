package location;

import player.Player;

import java.util.ArrayList;

/**
 * Represents a location in the game.
 * Each location has an ID, a name, a description, a list of items, a list of characters, and a list of usable objects.
 * @author Marek
 */
public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> charactersAtLocation = new ArrayList<>();
    private ArrayList<String> uses = new ArrayList<>();
    private ArrayList<String> neigbours = new ArrayList<>();


    public ArrayList<String> getNeigbours() {
        return neigbours;
    }

    public void setNeigbours(ArrayList<String> neigbours) {
        this.neigbours = neigbours;
    }

    public ArrayList<String> getUses() {
        return uses;
    }

    public void setUses(ArrayList<String> uses) {
        this.uses = uses;
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

    /**
     * Removes an item from the location.
     * @param item The name of the item to remove.
     */
    public void removeItem(String item) {
        items.remove(item);

    }

    /**
     * Adds an item to the location.
     * @param item The name of the item to add.
     */
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
