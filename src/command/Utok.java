package command;

import game.GameData;
import location.Location;
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
            case "New York City" -> {
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
        System.out.println("\nmas 2 naboje");
        boolean end = false;
        while (!end) {
            String choiseEnemy = volby[rd.nextInt(volby.length)];
            String choisePlayer = "";

            boolean input = false;
            while (!input) {
                System.out.println("Zadej volbu :");
                choisePlayer = sc.next();
                for (String s : volby) {
                    if (s.equals(choisePlayer)) {
                        input = true;
                        break;

                    }

                }
            }
            System.out.println("Jeho volba " + choiseEnemy);


            if (choisePlayer.equals("strilet")) {
                if (ammoPlayer == 0) {
                    System.out.println("Nemáš náboje! Musíš nabíjet nebo bránit.");


                }
            }


            if (choiseEnemy.equals("nabijeni")) {
                ammoEnemy++;
            }
            if (choisePlayer.equals("nabijeni")) {
                ammoPlayer++;
            }


            if (choisePlayer.equals("strilet") && choiseEnemy.equals("nabijeni") && ammoPlayer > 0) {
                ammoPlayer--;
                System.out.println("Zásah! Ubral jsi nepriteli 1 hp.");
                ch.setHp(ch.getHp() - 1);
            } else if (choisePlayer.equals("nabijeni") && choiseEnemy.equals("strilet") && ammoEnemy > 0) {
                ammoEnemy--;
                System.out.println("Zásah! Ubral ti 1 hp.");
                player.setHp(player.getHp() - 1);
            } else if ((choisePlayer.equals("strilet") && choiseEnemy.equals("obrana"))) {
                System.out.println("Střela zablokována.");
                ammoPlayer--;
            } else if ((choisePlayer.equals("obrana") && choiseEnemy.equals("strilet"))) {
                System.out.println("Střela zablokována.");
                ammoEnemy--;

            } else if (choisePlayer.equals("strilet") && choiseEnemy.equals("strilet")) {
                if (ammoPlayer == 0) {
                    System.out.println("Zásah! Vyhrál nepřítel.");
                    ammoEnemy--;
                    player.setHp(player.getHp() - 1);


                } else if (ammoEnemy == 0) {
                    System.out.println("Zasahl jsi ubral jsi mu 1 hp");
                    ammoPlayer--;
                    ch.setHp(ch.getHp() - 1);

                } else {
                    System.out.println("Oba dva jse byli zasazeny");
                    ammoEnemy--;
                    ammoPlayer--;
                    ch.setHp(ch.getHp() - 1);
                    player.setHp(player.getHp() - 1);

                }


            } else {
                System.out.println("Nic se nestalo.");
            }
            if (ch.getHp() == 0) {
                System.out.println("Zabil jsi Lokiho armádu\n");

                end = true;
            }

            System.out.println("Hráč náboje: " + ammoPlayer);
            System.out.println("tvoje životy: " + player.getHp());

            System.out.println();
            System.out.println("Nepřítel náboje: " + ammoEnemy);
            System.out.println("jeho životy: " + ch.getHp());



        }
        System.out.println("Lezi tu kamen mysli");
        for (Location l : gameData.locations) {
            if (l.getName().equals("New York City")) {
                l.addItem("kamen mysli");

            }
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
