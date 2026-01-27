package command;

import game.GameData;
import player.Player;
import postavy.Character;

public class Mluv extends Command {
    private GameData data;
    private Player player;


    public Mluv(Player player, GameData data) {
        this.player = player;
        this.data = data;

    }

    @Override
    public String execute() {
        switch (player.getCurrentLocation().getName()) {
            case "AvengersTower" -> {
                speakAvengerTower();

            }
            case "Wakanda" -> {
                speakWakanda();

            }
            case "Knowhere" -> {
                speakKnowhere();

            }
            case "Asgard" -> {
                speakAsgard();

            }
            case "NewYorkCity" -> {
                speakNewYorkCity();

            }
            case "Vormir" -> {

            }

        }
        return "";

    }

    public void speakAvengerTower() {
        Character ch = data.characters.get(1);
        System.out.println("Mluvis s " + ch.getName());
        System.out.println();
        System.out.println();
    }

    public void speakWakanda() {
        Character ch = data.characters.get(3);
    }

    public void speakAsgard() {
        Character ch = data.characters.get(2);
    }

    public void speakNewYorkCity() {
        Character ch = data.characters.get(0);
    }

    public void speakKnowhere() {
        Character ch = data.characters.get(4);
    }

    public void speakVormir() {
        Character ch = data.characters.get(6);
    }


    @Override
    public boolean exit() {
        return false;
    }
}
