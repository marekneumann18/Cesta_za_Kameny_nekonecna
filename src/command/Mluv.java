package command;

import game.GameData;
import location.Location;
import player.Player;
import characters.Character;

import java.util.Scanner;

/**
 * The Mluv class represents the "talk" command.
 * It allows the player to interact with characters in the game.
 * @author Marek
 */
public class Mluv extends Command {

    private static Scanner sc = new Scanner(System.in);
    private GameData data;
    private Player player;


    /**
     * Constructs a new Mluv command.
     * @param player The player object.
     * @param data The game data.
     */
    public Mluv(Player player, GameData data) {
        this.player = player;
        this.data = data;

    }


    /**
     * Executes the "talk" command.
     * It allows the player to talk to a character in the current location and respond to their dialogs.
     * @return A string indicating the end of the conversation.
     */
    @Override
    public String execute() {
        System.out.println("S kym chces mluvit");
        String character = sc.nextLine().toLowerCase().trim().replaceAll(" ", "");
        Location l = player.getCurrentLocation();
        if (l.getCharactersAtLocation().contains(character)) {


            for (Character ch : data.getCharacters()) {
                if (ch.getId().equalsIgnoreCase(character)) {
                    System.out.println(ch.getName() + ": " + ch.getDialogs().get("default"));

                    boolean answer = false;
                    while (!answer) {
                        String question = sc.nextLine().toLowerCase().replaceAll(" ", "");
                        if (ch.getDialogs().containsKey(question)) {
                            System.out.println(ch.getName() + ": " + ch.getDialogs().get(question));
                            switch (ch.getId()){
                                case "captainamerica"->{
                                    if (question.equals("zbran")){
                                        speakCaptain();
                                    }

                                }case "redskull"->{
                                    if (question.equals("hadanka")){
                                        speakRedSkull();
                                        answer = true;
                                    }

                                }case "blackpanther"->{
                                    speakBlackPanther(question);
                                    answer = true;

                                }case "obchodnik"->{
                                    speakObchodnik(question);


                                }default -> System.out.println();
                            }
                        } else if (question.equals("konec")) {
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

    /**
     * Handles the conversation with Captain America.
     */
    public void speakCaptain(){
        if (!player.getItems().contains("stit")) {
            player.getCurrentLocation().addItem("stit");
            System.out.println("[INFO]: Captain America položil na zem svůj štít. Teď ho můžeš sebrat.");
        }

    }

    /**
     * Handles the conversation with Red Skull.
     */
    public void speakRedSkull(){
        if (!player.getItems().contains("kamenduse")) {
            String answerMystery = sc.next().toLowerCase();
            if (answerMystery.equals("procesor") || answerMystery.equals("cpu")) {
                player.getCurrentLocation().addItem("kamenduse");
                System.out.println("Správně");
                System.out.println("Kámen duše leží na zemi před tebou");


            } else {
                System.out.println("špatná odpověď.Zkus to třeba příště");
            }
        } else {
            System.out.println();
            System.out.println("Kámen už máš.");
        }
    }

    /**
     * Handles the conversation with Black Panther.
     * @param question The player's question.
     */
    public void speakBlackPanther(String question){
        switch (question) {
            case "vibranium" -> {
                if (!player.getItems().contains("brneni")) {
                    player.getCurrentLocation().addItem("brneni");

                }
            }
            case "kladivo" -> {
                if (!player.getItems().contains("thorovokladivo")) {
                    String answerMystery2 = sc.nextLine();
                    if (answerMystery2.equals("1")) {
                        System.out.println("Správně");
                        player.getCurrentLocation().addItem("thorovokladivo");
                        System.out.println("Thorovo kladivo zde leží");

                    } else {
                        System.out.println("špatná odpověď");
                    }
                } else {
                    System.out.println("Už jsi tady byl.");
                }


            }
        }
    }

    /**
     * Handles the conversation with the Obchodnik.
     * @param question The player's question.
     */
    public void speakObchodnik(String question){
        if (question.equals("ukol")) {
            if (player.getItems().contains("brneni")) {
                System.out.println("Výborně našel jsi brnění");
                System.out.println("Děkuji že jsi mi ho přinesl\nTady máš kámen času");
                player.getCurrentLocation().addItem("kamencasu");
                player.removeItem("brneni");
            }
        } else if (question.equals("leky")) {
            player.getCurrentLocation().addItem("leky");

        }

    }


    /**
     * The "talk" command does not cause the game to exit.
     * @return false.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
