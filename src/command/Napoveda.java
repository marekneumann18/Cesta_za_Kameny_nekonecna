package command;

public class Napoveda extends Command {
    @Override
    public String execute() {
        return "Možné příkazy :\njdi {Asgard,New York City,Vormir,Avengers Tower,Titan,Knowhere,Wakanda,Sokovia}\nkonec hry\nmluv\nnapoveda\npouzij\nseber\nutok";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
