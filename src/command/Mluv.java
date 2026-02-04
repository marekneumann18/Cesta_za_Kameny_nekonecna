package command;

import game.GameData;
import location.Location;
import player.Player;
import characters.Character;

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
        String character = sc.nextLine().toLowerCase().trim();
        Location l = player.getCurrentLocation();
        if (l.getCharactersAtLocation().contains(character)) {


            for (Character ch : data.getCharacters()) {
                if (ch.getId().equalsIgnoreCase(character)) {
                    System.out.println(ch.getName() + ": " + ch.getDialogs().get("default"));

                    boolean answer = false;
                    while (!answer) {
                        String question = sc.next().toLowerCase();
                        if (ch.getDialogs().containsKey(question)) {
                            System.out.println(ch.getName() + ": " + ch.getDialogs().get(question));
                            if (ch.getId().equalsIgnoreCase("captainamerica") && question.equalsIgnoreCase("zbran")) {
                                if (!player.getItems().contains("stit")) {
                                    l.addItem("stit");
                                    System.out.println("[INFO]: Captain America položil na zem svůj starý štít. Teď ho můžeš sebrat.");
                                }

                            } else if (ch.getId().equalsIgnoreCase("redskull") && question.equalsIgnoreCase("hadanka")) {
                                if (!player.getItems().contains("kamen duse")) {
                                    String answerMystery = sc.next().toLowerCase();
                                    if (answerMystery.equals("procesor ") || answerMystery.equals("cpu")) {
                                        l.addItem("kamen duse");
                                        System.out.println("Správně");
                                        System.out.println("Kámen duše leží na zemi před tebou");


                                    }else{
                                        System.out.println("špatná odpověď.Zkus to třeba příště");
                                    }
                                }else {
                                    System.out.println("Kámen už máš.");
                                }
                                answer = true;

                            } else if (ch.getId().equalsIgnoreCase("blackpanther")  ) {

                               if (question.equalsIgnoreCase("brneni")) {
                                   if (!player.getItems().contains("brneni")) {
                                       l.addItem("brneni");

                                   }

                               } else if (question.equalsIgnoreCase("vibranium")) {
                                   if (!player.getItems().contains("thorovo kladivo")) {
                                       String answerMystery2 = sc.next();
                                       if (answerMystery2.equals("1")) {
                                           System.out.println("Správně");
                                           l.addItem("thorovo kladivo");
                                           System.out.println("Thorovo kladivo zde leží");

                                       }else{
                                           System.out.println("špatná odpověď");
                                       }
                                   }else {
                                       System.out.println("Už jsi tady byl.");
                                   }

                                   answer = true;
                               }


                            } else if (ch.getId().equalsIgnoreCase("obchodnik") && question.equalsIgnoreCase("ukol")) {
                                if(player.getItems().contains("brneni")){
                                    System.out.println("Výborně našel jsi brnění");
                                    System.out.println("Děkuji že jsi mi ho přinesl\nTady máš kámen času");
                                    l.addItem("kamen casu");
                                    player.removeItem("brneni");
                                }


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




    @Override
    public boolean exit() {
        return false;
    }
}
