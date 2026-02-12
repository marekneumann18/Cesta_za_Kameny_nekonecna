package command;

import player.Player;

/**
 * The Napoveda class represents the "help" command.
 * It provides the player with a list of available commands.
 * @author Marek
 */
public class Napoveda extends Command {
    private Player player;
    public Napoveda(Player player){
        this.player = player;
    }
    /**
     * Executes the "help" command.
     * the map is from chatgpt
     * @return A string containing the list of available commands and other helpful information.
     */
    @Override
    public String execute() {
        String id = player.getCurrentLocation().getId();

        // Definice vzhledu lokací (pokud tam hráč je, ohraničíme ji [X])
        String as = id.equals("asgard") ? "[ ASGARD ]" : "  Asgard  ";
        String so = id.equals("sokovia") ? "[ SOKOVIA ]" : "  Sokovia ";
        String to = id.equals("avengerstower") ? "[ TOWER ]" : "  Tower   ";
        String vo = id.equals("vormir") ? "[ VORMIR ]" : "  Vormir  ";
        String ny = id.equals("newyorkcity") ? "[  NYC  ]" : "   NYC    ";
        String kn = id.equals("knowhere") ? "[ KNOWHERE ]" : " Knowhere ";
        String wa = id.equals("wakanda") ? "[ WAKANDA ]" : "  Wakanda ";
        String ti = id.equals("titan") ? "[ TITAN ]" : "  Titan   ";

        return "\n" +
                "       " + as + " ────────── " + so + "\n" +
                "           │                    │\n" +
                "           │                    │\n" +
                "       " + to + " ────────── " + vo + "\n" +
                "        /      \\                |\n" +
                "       /        \\               │\n" +
                "   " + ny + "    " + kn + " ────┘\n" +
                "        │             |\n" +
                "        │             │\n" +
                "   " + wa + "     " + ti + "\n" +
                "\n\n" +
                "══ Legend: [ TEXT ] = Tvoje poloha ══\n"
                + "\n" +
         "Možné příkazy :\njdi {Asgard,New York City,Vormir,Avengers Tower,Titan,Knowhere,Wakanda,Sokovia}\nkonec hry\nmluv\nnapoveda\npouzij (např. stormbreaker nebo thorovo kladivo v lokaci Asgard, kod v Avengers Tower\nseber <predmet>\nutok";
    }

    /**
     * The "help" command does not cause the game to exit.
     * @return false.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
