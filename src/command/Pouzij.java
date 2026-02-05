package command;

import game.GameData;
import location.Location;
import player.Player;

import java.util.Scanner;

public class Pouzij extends Command {
    private Player player;
    private GameData data;
    Scanner sc = new Scanner(System.in);
    private boolean unlocked = false;

    public Pouzij(Player player, GameData data) {
        this.player = player;
        this.data = data;
    }

    @Override
    public String execute() {
        System.out.println("Co chceš použít :");
        String use = sc.nextLine().toLowerCase().replaceAll(" ", "");
        if (use.equals("leky") && player.getItems().contains("leky")) {
            player.setHp(player.getHp() + 10);
            player.removeItem("leky");
            return "Uzdravil sis 10 hp";


        }
        for (Location l : data.getLocations()) {
            if (l.getUses().contains(use) && player.getCurrentLocation().equals(l)) {
                    if (use.equals("kod")) {
                        if (!unlocked) {
                            System.out.println("Zadej kod :");
                            String code = sc.nextLine();
                            if (code.equals("1578")) {
                                l.addItem("kamenprostoru");
                                unlocked = true;
                                return "Správně odemkl jsi trezor a našel jsi kámen prostoru";
                            } else {
                                return "Špatně zkus to třeba příště";
                            }
                        }else {
                            return "Trezor je už otevřený";
                        }

                    }else if (use.equals("stormbreaker") || use.equals("thorovokladivo")) {
                        if (!player.getItems().contains("kamenreality")) {
                            player.getCurrentLocation().addItem("kamenreality");

                            return "Zničil jsi bariéru a našel jsi kámen reality";

                        }else{
                            return "Bariéra je už zničená";
                        }

                    }





            }

        }
        return "Taková možnost není";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
