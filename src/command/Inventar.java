package command;


import player.Player;


import java.util.Scanner;

public class Inventar extends Command {
    private Player player;
    private Scanner sc = new Scanner(System.in);

    public Inventar(Player player) {
        this.player = player;
    }




    @Override
    public String execute() {
        System.out.println("Co chceš udělat\n\n1) zobrazit inventář\n2) zahodit předmět ");
        String choise = sc.nextLine().toLowerCase().replace(" ", "");
        if (choise.equals("1")) {
            return "Tvůj inventar : " + player.getItems();
        } else if (choise.equals("2")) {
            System.out.println("Jaký předmět chces zahodit :");
            String item = sc.nextLine().toLowerCase().trim().replace(" ", "");
            for (String item1 : player.getItems()) {
                if (item1.equals(item)) {
                    player.removeItem(item);
                    player.getCurrentLocation().addItem(item);
                    return "Zahodil jsi " + item;

                }

            }
            return "Takový předmět nemáš";

        }
        return "Taková možnost není";

    }

    @Override
    public boolean exit() {
        return false;
    }





}
