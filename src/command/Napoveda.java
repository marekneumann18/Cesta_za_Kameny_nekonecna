package command;

public class Napoveda extends Command {
    @Override
    public String execute() {
        return "Všechno piš bez diakritiky\nMožné příkazy :\njdi {Asgard,New York City,Vormir,Avengers Tower,Titan,Knowhere,Wakanda,Sokovia}\nkonec hry\nmluv\nnapoveda\npouzij (např. stormbreaker nebo thorovo kladivo v lokaci Asgard, kod v Avengers Tower\nseber <predmet>\nutok";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
