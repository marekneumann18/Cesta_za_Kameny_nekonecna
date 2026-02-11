package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

/**
 * The Seber class represents the "take" or "get" command.
 * It allows the player to pick up items from the current location.
 * @author Marek
 */
public class Seber extends Command {
    Scanner sc = new Scanner(System.in);
    private Player player;
    private GameData data;


    /**
     * Constructs a new Seber command.
     * @param player The player object.
     * @param data The game data.
     */
    public Seber(Player player, GameData data) {
        this.player = player;
        this.data = data;

    }

    /**
     * Executes the "take" command.
     * It allows the player to pick up an item from the current location and add it to their inventory.
     * @return A string indicating whether the item was successfully taken.
     */
    @Override
    public String execute() {
        System.out.println("Jaky predmet chces vzit");
        String item = sc.nextLine().toLowerCase().replaceAll(" ", "");

        for (Location l : data.locations) {
            if (l.getItems().contains(item)) {
                if (player.getCurrentLocation().equals(l)) {
                    if (player.getItems().size() < 9) {
                        player.addItem(item);
                        l.removeItem(item);
                        System.out.println(player.getItems());
                        return "předmět byl přidan";
                    } else {
                        return "Item nemůžeš přidat je plný";
                    }
                }


            }
        }


        return "Takový předmět tu není";
    }

    /**
     * The "take" command does not cause the game to exit.
     * @return false.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
