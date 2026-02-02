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
                            if (ch.getId().equalsIgnoreCase("captainamerica") && ch.getDialogs().containsKey("zbran")) {
                                if (!l.getItems().contains("stit")) {
                                    l.addItem("stit");
                                    System.out.println("[INFO]: Captain America položil na zem svůj starý štít. Teď ho můžeš sebrat.");
                                }

                            } else if (ch.getId().equalsIgnoreCase("redskull") && ch.getDialogs().containsKey("hadanka")) {
                                String answerMystery = sc.next().toLowerCase();
                                if (answerMystery.equals("procesor ") || answerMystery.equals("cpu")) {
                                    l.addItem("kamen duse");
                                    System.out.println("Správně");
                                    System.out.println("Kámen duše leží na zemi před tebou");

                                }else{
                                    System.out.println("špatná odpověď");
                                }

                            } else if (ch.getId().equalsIgnoreCase("blackpanther")  ) {
                               if (ch.getDialogs().containsKey("brneni")) {
                                   l.addItem("brneni");
                               } else if (ch.getDialogs().containsKey("vibranium")) {
                                   String answerMystery2 = sc.next().toLowerCase();
                                   if (answerMystery2.equals("1")) {
                                       l.addItem("thorovo kladivo");
                                       System.out.println("Správně");
                                       System.out.println("Thorovo kladivo zde leží");

                                   }else{
                                       System.out.println("špatná odpověď");
                                   }
                               }

                                //TODO  obchodnik
                            } else if (ch.getId().equalsIgnoreCase("obchodnik") && ch.getDialogs().containsKey("ukol")){
                                if(player.getItems().contains("brneni")){


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
