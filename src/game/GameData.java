package game;

import com.fasterxml.jackson.databind.ObjectMapper;
import player.Item;
import location.Location;
import postavy.Postava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class GameData {

    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Postava> characters = new ArrayList<>();
    public ArrayList<Location> locations = new ArrayList<>();


    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Postava> getCharacters() {
        return characters;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a game.GameData object filled with the loaded data
     */
    public static void loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem

        ObjectMapper parser = new ObjectMapper();

        try {
            InputStream input = new FileInputStream(resourcePath);
            GameData data = parser.readValue(input, GameData.class);
            System.out.println(data);



        }catch (FileNotFoundException e){
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

    @Override
    public String toString() {
        return "game.GameData{" +
                "\ncharacters=" + characters +
                "\nlocations=" + locations +
                "\nitems=" + items +
                "\n}";
    }


}
