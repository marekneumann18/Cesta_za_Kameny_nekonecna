package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

/**
 * The Jdi class represents the "go" command.
 * It allows the player to move to a different location.
 * @author Marek
 */
public class Jdi extends Command {
    private Player player;
    private GameData data;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new Jdi command.
     * @param player The player object.
     * @param data The game data.
     */
    public Jdi(Player player, GameData data) {
        this.player = player;
        this.data = data;
    }


    /**
     * Executes the "go" command.
     * It prompts the user for a location and moves the player to that location if it exists.
     * @return A description of the new location.
     */
    @Override
    public String execute() {
        while (true) {
            System.out.println("Zadej lokaci , kam se chceš přemístit");
            String location = scanner.nextLine().toLowerCase().trim().replace(" ", "");
            for (Location l : data.getLocations()) {
                if (l.getId().equalsIgnoreCase(location)) {
                    player.setCurrentLocation(l);
                    System.out.println(player);
                    System.out.println("Přesouváš se do lokace " + l.getName());
                    return l.getDescription();
                }

            }
            System.out.println("Taková možnost není");
        }
    }

    /**
     * The "go" command does not cause the game to exit.
     * @return false.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
