package command;

/**
 * The KonecHry class represents the "end game" command.
 * It is used to exit the game.
 * @author Marek
 */
public class KonecHry extends Command {
    /**
     * Executes the "end game" command.
     * @return A message indicating that the game is ending.
     */
    @Override
    public String execute() {
        return "ukončil jsi hru";
    }

    /**
     * The "end game" command causes the game to exit.
     * @return true.
     */
    @Override
    public boolean exit() {
        return true;
    }
}
