package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

/**
 * The Pouzij class represents the "use" command.
 * It allows the player to use items in their inventory or in the environment.
 * @author Marek
 */
public class Pouzij extends Command {
    private Player player;
    private GameData data;
    Scanner sc = new Scanner(System.in);
    private boolean unlocked = false;

    /**
     * Constructs a new Pouzij command.
     * @param player The player object.
     * @param data The game data.
     */
    public Pouzij(Player player, GameData data) {
        this.player = player;
        this.data = data;
    }

    /**
     * Executes the "use" command.
     * It allows the player to use an item, which can have various effects depending on the item and the context.
     * @return A string describing the result of using the item.
     */
    @Override
    public String execute() {
        System.out.println("Co chceš použít :");
        String use = sc.nextLine().toLowerCase().replaceAll(" ", "");
        if (use.equals("leky") && player.getItems().contains("leky")) {
            player.setHp(player.getHp() + 10);
            player.removeItem("leky");
            return "Uzdravil sis 10 hp";


        }
        for (Location l : data.getLocations()) {
            if (l.getUses().contains(use) && player.getCurrentLocation().equals(l)) {
                    if (use.equals("kod")) {
                        if (!unlocked) {
                            System.out.println("Zadej kod :");
                            String code = sc.nextLine();
                            if (code.equals("1578")) {
                                l.addItem("kamenprostoru");
                                unlocked = true;
                                return "Správně odemkl jsi trezor a našel jsi kámen prostoru";
                            } else {
                                return "Špatně zkus to třeba příště";
                            }
                        }else {
                            return "Trezor je už otevřený";
                        }

                    }else if (use.equals("stormbreaker") || use.equals("thorovokladivo")) {
                        if (!player.getItems().contains("kamenreality")) {
                            player.getCurrentLocation().addItem("kamenreality");

                            return "Zničil jsi bariéru a našel jsi kámen reality";

                        }else{
                            return "Bariéra je už zničená";
                        }

                    }





            }

        }
        return "Taková možnost není";
    }

    /**
     * The "use" command does not cause the game to exit.
     * @return false.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
