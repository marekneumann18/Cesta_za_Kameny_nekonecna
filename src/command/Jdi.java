package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

public class Jdi extends Command {
    private Player player;
    private GameData data;
    private Scanner scanner = new Scanner(System.in);

    public Jdi(Player player, GameData data) {
        this.player = player;
        this.data = data;
    }


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

    @Override
    public boolean exit() {
        return false;
    }
}
