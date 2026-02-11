package command;

/**
 * The Napoveda class represents the "help" command.
 * It provides the player with a list of available commands.
 * @author Marek
 */
public class Napoveda extends Command {
    /**
     * Executes the "help" command.
     * @return A string containing the list of available commands and other helpful information.
     */
    @Override
    public String execute() {
        return "Všechno piš bez diakritiky\nMožné příkazy :\njdi {Asgard,New York City,Vormir,Avengers Tower,Titan,Knowhere,Wakanda,Sokovia}\nkonec hry\nmluv\nnapoveda\npouzij (např. stormbreaker nebo thorovo kladivo v lokaci Asgard, kod v Avengers Tower\nseber <predmet>\nutok";
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
