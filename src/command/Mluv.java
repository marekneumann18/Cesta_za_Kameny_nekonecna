package command;

import game.GameData;
import location.Location;
import player.Player;
import postavy.Character;

import java.util.Scanner;

public class Mluv extends Command {
    Scanner sc = new Scanner(System.in);
    private GameData data;
    private Player player;


    public Mluv(Player player, GameData data) {
        this.player = player;
        this.data = data;

    }


    @Override
    public String execute() {
        System.out.println("S kym chces mluvit");
        String charecter = sc.nextLine().toLowerCase().trim();
        Location l = player.getCurrentLocation();
        if (l.getCharactersAtLocation().contains(charecter)) {


            for (Character ch : data.getCharacters()) {
                if (ch.getId().equalsIgnoreCase(charecter)) {
                    System.out.println(ch.getName() + ": " + ch.getDialogs().get("default"));

                    boolean answer = false;
                    while (!answer) {
                        String question = sc.next().toLowerCase();
                        if (ch.getDialogs().containsKey(question)) {
                            System.out.println(ch.getName() + ": " + ch.getDialogs().get(question));
                        } else if (question.equalsIgnoreCase("konec")) {
                            answer = true;

                        } else {
                            System.out.println("Zadej znovu :");
                        }

                    }
                    return "Rozhovor ukončen";


                }

            }

        }
        return "Daná postava  není v místnosti nebo neexistuje";


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
