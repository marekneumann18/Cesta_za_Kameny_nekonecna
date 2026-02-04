package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

public class Pouzij extends Command {
    private Player player;
    private GameData data;
    Scanner sc = new Scanner(System.in);

    public Pouzij(Player player, GameData data) {
        this.player = player;
        this.data = data;
    }

    @Override
    public String execute() {
        String use = sc.next();
        for (Location loc : data.getLocations()) {

        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
