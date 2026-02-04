package command;

import player.Item;
import player.Player;

import java.util.ArrayList;

public class Inventar extends Command {
    private ArrayList<Item> items;
    private Player player;

    public Inventar(Player player) {
        this.player = player;
    }

    public Inventar() {
        items = new ArrayList<>();
    }


    @Override
    public String execute() {
        return "Tvůj inventar : " + player.getItems();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item items) {
        this.items.add(items);
    }

    public void removeItem(Item items) {
        this.items.remove(items);
    }

}
