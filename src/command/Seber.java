package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

public class Seber extends Command {
    private Player player;
    private GameData data;
    private Location location;
    Scanner sc = new Scanner(System.in);

    public Seber(Player player, GameData data) {
        this.player = player;
        this.data = data;
        location = player.getCurrentLocation();
    }

    @Override
    public String execute() {
        System.out.println("Jaky predmet chces vzit");
        String item = sc.nextLine();

        for (Location l : data.locations) {
            if (l.getItems().contains(item)) {
                player.addItem(item);
                l.removeItem(item);
                System.out.println(l);
                System.out.println(player.getItems());
                return "předmět byl přidan";

            }
        }


        return "Takovy predmet tu neni";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
