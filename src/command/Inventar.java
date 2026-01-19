package command;

import hrac.Item;

import java.util.ArrayList;

public class Inventar extends Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    private ArrayList<Item> predmety;

    public Inventar() {
        predmety = new ArrayList<>();
    }

    public ArrayList<Item> getPredmety() {
        return predmety;
    }

    public void addPredmety(Item predmety) {
        this.predmety.add(predmety);
    }

    public void removePredmety(Item predmety) {
        this.predmety.remove(predmety);
    }

}
