package command;

import player.Item;
import player.Player;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inventar extends Command {
    private ArrayList<Item> items;
    private Player player;
    private Scanner sc = new Scanner(System.in);

    public Inventar(Player player) {
        this.player = player;
    }

    public Inventar() {
        items = new ArrayList<>();
    }


    @Override
    public String execute() {
        System.out.println("Co chceš udělat\n\n1) zobrazit inventář\n2) zahodit předmět ");
        String choise = sc.nextLine().toLowerCase().replace(" ", "");
        if (choise.equals("1")) {
            return "Tvůj inventar : " + player.getItems();
        } else if (choise.equals("2")) {
            System.out.println("Jaký předmět chces zahodit :");
            String item = sc.nextLine().toLowerCase().replace(" ", "");
            for (String item1 : player.getItems()) {
                if (item1.equals(item)) {
                    return "Zahodil jsi " + item;

                }
                return "Takový předmět nemáš";
            }

        }
        return "Taková možnost není";

    }

    @Override
    public boolean exit() {
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item items) {
        this.items.add(items);
    }

    public void removeItem(Item items) {
        this.items.remove(items);
        player.getCurrentLocation().addItem(items.getName());
    }

}
