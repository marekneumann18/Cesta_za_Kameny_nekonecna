package command;

import game.GameData;
import location.Location;
import player.Player;
import characters.Character;

import java.util.Scanner;

public class Mluv extends Command {
    private static
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
        String character = sc.nextLine().toLowerCase().replaceAll(" ", "");
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
    public void speakCaptain(){
        if (!player.getItems().contains("stit")) {
            player.getCurrentLocation().addItem("stit");
            System.out.println("[INFO]: Captain America položil na zem svůj štít. Teď ho můžeš sebrat.");
        }

    }
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
    public void speakBlackPanther(String question){
        switch (question) {
            case "brneni" -> {
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


    @Override
    public boolean exit() {
        return false;
    }
}
