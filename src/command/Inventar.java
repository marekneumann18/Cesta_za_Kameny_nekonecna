package command;


import player.Player;


import java.util.Scanner;

/**
 * The Inventar class represents the "inventory" command.
 * It allows the player to view their inventory and drop items.
 * @author Marek
 */
public class Inventar extends Command {
    private Player player;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructs a new Inventar command.
     * @param player The player object.
     */
    public Inventar(Player player) {
        this.player = player;
    }




    /**
     * Executes the "inventory" command.
     * It allows the player to either view their inventory or drop an item.
     * @return A string describing the result of the action.
     */
    @Override
    public String execute() {
        System.out.println("Co chceš udělat\n\n1) zobrazit inventář\n2) zahodit předmět ");
        String choise = sc.nextLine().toLowerCase().replace(" ", "");
        if (choise.equals("1")) {
            return "Tvůj inventar : " + player.getItems();
        } else if (choise.equals("2")) {
            System.out.println("Jaký předmět chces zahodit :");
            String item = sc.nextLine().toLowerCase().trim().replace(" ", "");
            for (String item1 : player.getItems()) {
                if (item1.equals(item)) {
                    player.removeItem(item);
                    player.getCurrentLocation().addItem(item);
                    return "Zahodil jsi " + item;

                }

            }
            return "Takový předmět nemáš";

        }
        return "Taková možnost není";

    }

    /**
     * The "inventory" command does not cause the game to exit.
     * @return false.
     */
    @Override
    public boolean exit() {
        return false;
    }





}
