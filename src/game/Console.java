package game;

import command.*;
import player.Player;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The Console class is responsible for handling user input and managing the game flow.
 * It initializes the game data, processes commands, and interacts with the player.
 *
 * @author Marek
 */
public class Console {
    private GameData data;
    private Player player;
    private HashMap<String, Command> commands;
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    private static final String BLUE =
            "\u001B[34m";
    private static final String RESET =
            "\u001B[0m";



    /**
     * Initializes the game by loading game data, creating the player, and setting up commands.
     */
    public void inicialization() {
        this.commands = new HashMap<>();
        this.player = new Player("", 20);
        this.data = new GameData();
        data.loadGameDataFromResources("gamedata.json");
        commands.put("jdi", new Jdi(player, data));
        commands.put("inventar", new Inventar(player));
        commands.put("konechry", new KonecHry());
        commands.put("mluv", new Mluv(player, data));
        commands.put("napoveda", new Napoveda(player));
        commands.put("pouzij", new Pouzij(player, data));
        commands.put("seber", new Seber(player, data));
        commands.put("utok", new Utok(player, data));
    }

    /**
     * Reads and processes a command from the user.
     */
    private void proved() {
        System.out.println();
        System.out.println("Zadej příkaz : (např. napoveda)");
        System.out.print(">> ");
        String prikaz = scanner.nextLine().toLowerCase().replace(" ", "");
        if (commands.containsKey(prikaz)) {
            System.out.println(">> " + commands.get(prikaz).execute());
            exit = commands.get(prikaz).exit();
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    /**
     * Starts the game.
     * It initializes the game, prompts the player for their name, and enters the main game loop.
     */
    public void start() {
        inicialization();

        player.setCurrentLocation(data.getLocations().get(0));
        System.out.println(BLUE + "nápověda : Všechno piš bez diakritiky" + RESET);
        System.out.println("Nacházíš se v " + player.getCurrentLocation().getName());
        System.out.println(player.getCurrentLocation().getDescription());
        System.out.print("Zadej jméno: ");
        String jmeno = scanner.nextLine();
        player.setName(jmeno);


        try {

            do {
                proved();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
