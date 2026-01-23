package command;

import game.GameData;
import player.Player;

import java.util.Scanner;

public class Pouzij extends Command {
    private Player player;
    private GameData data;

    public Pouzij(Player player,GameData data) {
        this.player = player;
        this.data = data;
    }
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
