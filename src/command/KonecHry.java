package command;

public class KonecHry extends Command {
    @Override
    public String execute() {
        return "ukončil jsi hru";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
