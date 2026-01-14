package hrac;

import predmety.Predmety;

import java.util.ArrayList;

public class Inventar {
    private ArrayList<Predmety> predmety;

    public Inventar() {
        predmety = new ArrayList<>();
    }
    public ArrayList<Predmety> getPredmety() {
        return predmety;
    }
    public void addPredmety(Predmety predmety) {
        this.predmety.add(predmety);
    }
    public void removePredmety(Predmety predmety) {
        this.predmety.remove(predmety);
    }

}
