import com.fasterxml.jackson.databind.ObjectMapper;
import hrac.Item;
import lokace.Location;
import postavy.Postava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameData {

    public ArrayList<Item> items;
    public ArrayList<Postava> characters;
    public ArrayList<Location> locations;


    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem

            ObjectMapper parser = new ObjectMapper();

            try {
                InputStream input = new FileInputStream("res/" + "gamedata.json");
                Location l = parser.readValue(input, Location.class);
                System.out.println(l);



            }catch (FileNotFoundException e){
                System.out.println("nefunguje");
            } catch (Exception e) {
                System.out.println("nefunguje ");
            }


        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = Main.class.getResourceAsStream(resourcePath)) {

            //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

            //Přečte celý JSON a vytvoří instanci GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }

    /**
     * Finds a specific location by its identifier.
     * @param name the identifier of the location to be found
     * @return the matching location
     */
    public  Location findLocation(String name) {
        for (Location l : locations) {
            if (l.getName().equals(name)){
                return l;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
    }


}
