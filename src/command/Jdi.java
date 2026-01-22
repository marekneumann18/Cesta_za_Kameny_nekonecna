package command;

import player.Player;

import java.util.Scanner;

public class Jdi extends Command {
    private Player player;
    private Scanner scanner = new Scanner(System.in);
    public Jdi(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        System.out.println("Zadej lokaci , kam se chceš přemístit");
        String location = s
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
