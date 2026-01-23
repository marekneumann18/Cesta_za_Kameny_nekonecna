package command;

public class Napoveda extends Command {
    @Override
    public String execute() {
        return "nápověda : \nMožné příkazy\njdi\nkonechry\nmluv\nnapoveda\npouzij\nseber\nutok";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
