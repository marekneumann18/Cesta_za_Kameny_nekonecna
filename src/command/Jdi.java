package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

public class    Jdi extends Command {
    private Player player;
    private GameData data;
    private Scanner scanner = new Scanner(System.in);
    public Jdi(Player player,GameData data) {
        this.player = player;
        this.data = data;
    }

    public Jdi(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        System.out.println("Zadej lokaci , kam se chceš přemístit");
        String location = scanner.next();
        for (Location l : data.getLocations()) {
            if (l.getName().equals(location)) {
                player.setCurrentLocation(l);
                System.out.println(player);
                return "Přesouváš se do lokace " + location;
            }
        }

        return "Taková možnost není";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
