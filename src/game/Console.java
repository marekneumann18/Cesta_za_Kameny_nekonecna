package game;

import command.*;
import player.Player;

import java.util.HashMap;

public class Console {
    private GameData data;
    private Player player;
    private HashMap<String, Command> commands;
    public void inicialization(){
        GameData.loadGameDataFromResources("res/gamedata.json");
        commands.put("jdi", new Jdi(player));
        commands.put("inventar", new Inventar());
        commands.put("konec hry", new KonecHry());
        commands.put("mluv", new Mluv());
        commands.put("napoveda", new Napoveda());
        commands.put("puzij", new Pouzij());
        commands.put("seber", new Seber());
        commands.put("utok", new Utok());
    }
   public void start(){

   }
}
