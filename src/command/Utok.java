package command;

import characters.Character;
import game.GameData;
import location.Location;
import player.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * The Utok class represents the "attack" command.
 * It handles the combat system in the game.
 * @author Marek
 */
public class Utok extends Command {
    private Random rd = new Random();
    private Scanner sc = new Scanner(System.in);
    private Player player;
    private GameData gameData;
    private boolean gameOver = false;


    /**
     * Constructs a new Utok command.
     * @param player The player object.
     * @param gameData The game data.
     */
    public Utok(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;


    }

    /**
     * Executes the "attack" command.
     * It initiates a fight with a character in the current location, if possible.
     * @return An empty string, as the output is handled within the method.
     */
    @Override
    public String execute() {

        Character lokiArmada = gameData.characters.get(7);
        Character armada = gameData.characters.get(5);
        Character thanos = gameData.characters.get(8);

        switch (player.getCurrentLocation().getName()) {
            case "New York City" -> {
                if (!lokiArmada.isDefeated()) {
                    fightNY(lokiArmada);
                } else {
                    System.out.println("Nikdo tu už není");
                }

            }
            case "Sokovia" -> {
                if (!armada.isDefeated()) {
                    fightSokovia(armada);
                } else {
                    System.out.println("Nikdo tu už není");

                }


            }
            case "Titan" -> {
                fightTitan(thanos);


            }
            default -> {
                return "V této lokaci nemůžeš bojovat";
            }


        }
        return "";


    }


    /**
     * Handles the fight in New York City.
     * @param ch The character to fight.
     */
    public void fightNY(Character ch) {

        if (player.getItems().contains("pistol")) {
            ch.setHp(ch.getHp() - 1);
        }
        if (player.getItems().contains("stit")) {
            ch.setHp(ch.getHp() - 2);
        }
        if (player.getItems().contains("thorovokladivo")) {
            ch.setHp(ch.getHp() - 3);
        }
        if (player.getItems().contains("stormbreaker")) {
            ch.setHp(ch.getHp() - 5);

        }

        fight(ch);
        if (ch.isDefeated()) {
            System.out.println("Lezi tu kamen mysli");
            for (Location l : gameData.locations) {
                if (l.getName().equals("New York City")) {
                    l.addItem("kamenmysli");

                }
            }
        }


    }

    /**
     * The main combat loop.
     * @param ch The character to fight.
     */
    public void fight(Character ch) {
        int ammoPlayer = 2;
        int ammoEnemy = 2;
        String[] volby = {"nabijeni", "strilet", "obrana"};
        System.out.println("Bojuješ proti " + ch.getName());
        System.out.println("\nSystem hry: \nMas tri moznosti boje:\nnabijeni\nstrilet\nobrana ");
        System.out.println("\nmas 2 naboje");
        boolean end = false;
        while (!end) {
            String choiseEnemy = volby[rd.nextInt(volby.length)];
            String choisePlayer = this.choise(volby);
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
            } else if (choisePlayer.equals("strilet") && choiseEnemy.equals("obrana") && ammoPlayer > 0) {
                System.out.println("Střela zablokována.");
                ammoPlayer--;
            } else if (choisePlayer.equals("obrana") && choiseEnemy.equals("strilet") && ammoEnemy > 0) {
                System.out.println("Střela zablokována.");
                ammoEnemy--;

            } else if (choisePlayer.equals("strilet") && choiseEnemy.equals("strilet")) {
                if (ammoPlayer == 0) {
                    System.out.println("Zásah! nepřítel ti ubral 1 hp.");
                    ammoEnemy--;
                    player.setHp(player.getHp() - 1);

                } else if (ammoEnemy == 0) {
                    System.out.println("Zasahl jsi, ubral jsi mu 1 hp");
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
            System.out.println("Hráč náboje: " + ammoPlayer);
            System.out.println("tvoje životy: " + player.getHp());

            System.out.println();
            System.out.println("Nepřítel náboje: " + ammoEnemy);
            System.out.println("jeho životy: " + ch.getHp());


            if (ch.getHp() == 0) {
                System.out.println("Zabil jsi " + ch.getName());
                ch.setDefeated(true);
                if (ch.getId().equals("thanos")) {
                    gameOver = true;
                }
                end = true;


            }
            if (player.getHp() == 0) {
                System.out.println("Umřel jsi");

                end = true;

            }

        }

    }

    /**
     * Prompts the player for their choice of action during combat.
     * @param choice The available choices.
     * @return The player's chosen action.
     */
    public String choise(String choice[]) {
        String choisePlayer = "";
        while (true) {
            System.out.println("Zadej volbu :");
            choisePlayer = sc.next();
            for (String s : choice) {
                if (s.equals(choisePlayer)) {
                    return choisePlayer;
                }
            }
        }
    }


    /**
     * Handles the fight in Sokovia.
     * @param ch The character to fight.
     */
    public void fightSokovia(Character ch) {
        if (player.getItems().contains("pistol")) {
            ch.setHp(ch.getHp() - 1);
        }
        if (player.getItems().contains("stit")) {
            ch.setHp(ch.getHp() - 3);
        }
        if (player.getItems().contains("thorovokladivo")) {
            ch.setHp(ch.getHp() - 5);
        }

        fight(ch);
        if (ch.isDefeated()) {
            System.out.println("Leží tu stormbreaker a kamen moci ");
            for (Location l : gameData.getLocations()) {
                if (l.getName().equals("Sokovia")) {
                    l.addItem("stormbreaker");
                    l.addItem("kamenmoci");

                }
            }
        }


    }

    /**
     * Handles the fight on Titan.
     * @param ch The character to fight.
     */
    public void fightTitan(Character ch) {
        if (player.getItems().contains("pistol")) {
            ch.setHp(ch.getHp() - 1);
        }
        if (player.getItems().contains("stit")) {
            ch.setHp(ch.getHp() - 3);
        }
        if (player.getItems().contains("thorovokladivo")) {
            ch.setHp(ch.getHp() - 5);
        }
        if (player.getItems().contains("stormbreaker")) {
            ch.setHp(ch.getHp() - 8);

        }
        if (hasInfinityStones()) {
            ch.setHp(ch.getHp() - 20);
        }
        fight(ch);


    }

    /**
     * Checks if the player has all the Infinity Stones.
     * @return true if the player has all the Infinity Stones, false otherwise.
     */
    public boolean hasInfinityStones() {
        return player.getItems().contains("kamenmoci") && player.getItems().contains("kamenreality") && player.getItems().contains("kamencasu") && player.getItems().contains("kamenduse") && player.getItems().contains("kamenprostoru") && player.getItems().contains("kamenmysli");
    }


    /**
     * Determines whether the "attack" command should cause the game to exit.
     * @return true if the player is dead or the game is over, false otherwise.
     */
    @Override
    public boolean exit() {
        if (player.getHp() == 0) {
            return true;
        } else if (gameOver) {
            System.out.println("\nVyhrál jsi.Dokončil jsi celou hru\nDěkuju za hraní mé hry");
            return true;

        }
        return false;


    }
}
