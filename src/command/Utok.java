package command;

import game.GameData;
import player.Player;
import postavy.Character;

import java.util.Random;
import java.util.Scanner;

public class Utok extends Command {
    private Player player;
    private GameData gameData;
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);


    public Utok(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;

    }

    @Override
    public String execute() {

        switch (player.getCurrentLocation().getName()) {
            case "NewYorkCity" -> {
                fightNY();

            }
            case "Sokovia" -> {


            }
            case "Titan" -> {


            }

        }
        return "";


    }

    @Override
    public boolean exit() {
        return false;
    }

    public void fightNY() {
        Character ch = gameData.characters.get(7);
        System.out.println(ch.getHp());
        int ammoPlayer = 2;
        int ammoEnemy = 2;
        String[] volby = {"nabijeni", "strilet", "obrana"};
        System.out.println("Bojuješ s Lokiho armadou\nSystem hry: \nMas tri moznosti boje:\nnabijeni\nstrilet\nobrana ");
        boolean end = false;
        while (!end) {
            String choiseEnemy = volby[rd.nextInt(volby.length)];
            String choisePlayer = "";

            boolean input = false;
            while (!input) {
                System.out.println("Zadej volbu");
                choisePlayer = sc.next();
                for (int j = 0; j < volby.length - 1; j++) {
                    if (volby[j].equals(choisePlayer)) {
                        input = true;

                    }

                }
            }
            System.out.println("Jeho volba " + choiseEnemy);


            if (choisePlayer.equals("strilet")) {
                if (ammoPlayer == 0) {
                    System.out.println("Nemáš náboje! Musíš nabíjet nebo bránit.");


                } else {
                    ammoPlayer--;

                }
            }
            if (choiseEnemy.equals("strilet")) {
                if (ammoEnemy == 0) {

                } else {
                    ammoEnemy--;
                }
            }

            if (choiseEnemy.equals("nabijeni")) {
                ammoEnemy++;
            }
            if (choisePlayer.equals("nabijeni")) {
                ammoPlayer++;
            }
            if (ch.getHp() == 0) {

                end = true;
            }

            if (choisePlayer.equals("strilet") && choiseEnemy.equals("nabijeni") && ammoEnemy > 0) {
                System.out.println("Zásah! Vyhrál hráč.");
                ch.setHp(ch.getHp() - 1);
            } else if (choisePlayer.equals("nabijeni") && choiseEnemy.equals("strilet") && ammoPlayer > 0) {
                System.out.println("Zásah! Vyhrál nepřítel.");
                player.setHp(player.getHp() - 1);
            } else if ((choisePlayer.equals("strilet") && choiseEnemy.equals("obrana")) || (choisePlayer.equals("obrana") && choiseEnemy.equals("strilet"))) {
                System.out.println("Střela zablokována.");
            } else if (choisePlayer.equals("strilet") && choiseEnemy.equals("strilet")) {
                if (ammoPlayer == 0) {
                    System.out.println("Zásah! Vyhrál nepřítel.");

                } else if (ammoEnemy == 0) {

                } else {
                    System.out.println("Oba dva jse byli zasazeny");
                }


            } else {
                System.out.println("Nic se nestalo.");
            }

            System.out.println("Hráč náboje: " + ammoPlayer);
            System.out.println("Nepřítel náboje: " + ammoEnemy);


        }
    }

    public void fightSokovia() {
        Character ch = gameData.characters.get(5);
        //TODO idelat souboj v sokovii
        int ammoPlayer = 2;

    }

    public void fightTitan() {
        Character ch = gameData.characters.get(8);
        //TODO udelat souboj titan
        int ammoPlayer = 2;

    }

}
