package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

public class Seber extends Command {
    Scanner sc = new Scanner(System.in);
    private Player player;
    private GameData data;
    private Location location;

    public Seber(Player player, GameData data) {
        this.player = player;
        this.data = data;
        location = player.getCurrentLocation();
    }

    @Override
    public String execute() {
        System.out.println("Jaky predmet chces vzit");
        String item = sc.nextLine().toLowerCase().replaceAll(" ", "");

        for (Location l : data.locations) {
            if (l.getItems().contains(item)) {
                if (player.getCurrentLocation().equals(l)) {
                    player.addItem(item);
                    l.removeItem(item);
                    System.out.println(player.getItems());
                    return "předmět byl přidan";
                }


            }
        }


        return "Takový předmět tu není";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
