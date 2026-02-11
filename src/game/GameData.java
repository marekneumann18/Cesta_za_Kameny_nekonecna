package game;

import com.fasterxml.jackson.databind.ObjectMapper;
import location.Location;
import characters.Character;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * The GameData class represents the game's data, including characters and locations.
 * It is responsible for loading this data from a JSON file.
 */
public class GameData {

    //    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Character> characters = new ArrayList<>();
    public ArrayList<Location> locations = new ArrayList<>();


//    public ArrayList<Item> getItems() {
//        return items;
//    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<Location> getLocations() {

        return locations;
    }

    //    public GameData() {
//        items = new ArrayList<>();
//        characters = new ArrayList<>();
//        locations = new ArrayList<>();
//    }


    /**
     * Loads game data from a JSON file at the given resource path.
     *
     * @param resourcePath path to the resource file
     */
    public void loadGameDataFromResources(String resourcePath) {


        ObjectMapper parser = new ObjectMapper();

        try {
            InputStream input = new FileInputStream(resourcePath);
            GameData data = parser.readValue(input, GameData.class);

            this.locations = data.locations;
            this.characters = data.characters;


        } catch (FileNotFoundException e) {
            System.out.println("nefunguje");
        } catch (Exception e) {
            System.out.println("nefunguje !");
        }


//     * Finds a specific location by its identifier.
//     * @param name the identifier of the location to be found
//     * @return the matching location
//     */
//    public  Location findLocation(String name) {
//        for (Location l : locations) {
//            if (l.getName().equals(name)){
//                return l;
//            }
//        }
//        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
    }

    /**
     * Returns a string representation of the GameData object.
     * @return A string containing the characters and locations.
     */
    @Override
    public String toString() {
        return "game.GameData{" +
                "\ncharacters=" + characters +
                "\nlocations=" + locations +
                "\n}";
    }


}
