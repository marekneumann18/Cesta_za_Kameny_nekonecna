package command;

/**
 * The Command class is an abstract base class for all commands in the game.
 * It defines the basic structure of a command, including its execution and exit behavior.
 * @author Marek
 */
public abstract class Command {
    protected String command;

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command.
     * This method must be implemented by all concrete command classes.
     * @return A string representing the result of the command execution.
     */
    public abstract String execute();

    /**
     * Determines whether the command should cause the game to exit.
     * This method must be implemented by all concrete command classes.
     * @return true if the game should exit, false otherwise.
     */
    public abstract boolean exit();
}
