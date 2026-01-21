package command;

import player.Player;

public class Jdi extends Command {
    private Player player;
    public Jdi(Player player) {
        player = player;
    }

    @Override
    public String execute() {
        System.out.println("Zadej lokaci , kam se chceš přemístit");
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
