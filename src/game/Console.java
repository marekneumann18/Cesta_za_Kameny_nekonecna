package game;

import command.*;
import player.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private GameData data;
    private Player player;

    private HashMap<String, Command> commands;
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);


    public void inicialization() {
        this.commands = new HashMap<>();
        this.player = new Player("",10,data);
        this.data = new GameData();
        data.loadGameDataFromResources("res/gamedata.json");
        commands.put("jdi", new Jdi(player,data));
        commands.put("inventar", new Inventar(player));
        commands.put("konechry", new KonecHry());
        commands.put("mluv", new Mluv(player,data));
        commands.put("napoveda", new Napoveda());
        commands.put("pouzij", new Pouzij(player,data));
        commands.put("seber", new Seber(player,data));
        commands.put("utok", new Utok(player,data));
    }

    private void proved() {
        System.out.println("\nZadej příkaz : (např. napoveda)");
        System.out.print(">> ");
        String prikaz = scanner.next().toLowerCase().trim().replace(" ","");
        if (commands.containsKey(prikaz)) {
            System.out.println(">> " + commands.get(prikaz).execute());
            exit = commands.get(prikaz).exit();
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    public void start() {
        inicialization();
        System.out.print("Zadej jméno: ");
        String jmeno = scanner.next();
        player.setName(jmeno);
        player.setCurrentLocation(data.getLocations().get(1));
        System.out.println(player);
        System.out.println(player.getItems());
//        data.getLocations().get();


        try {

            do {
                proved();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
