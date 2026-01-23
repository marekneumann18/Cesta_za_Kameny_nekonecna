package command;

import player.Item;

import java.util.ArrayList;

public class Inventar extends Command {
    private ArrayList<Item> items;
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }



    public Inventar() {
        items = new ArrayList<>();
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
