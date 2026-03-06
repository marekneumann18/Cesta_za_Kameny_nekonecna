package command;

import player.Player;

import java.io.*;

public class  Ulozit extends  Command{
    private Player player;
    public Ulozit(Player player) {
        this.player = player;

    }

    public  void writeToFile(String fileName) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
        stream.writeObject(this);
        stream.close();
    }

    public static Player readFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName));
        Player player = (Player) stream.readObject();
        return player;
    }

    @Override
    public String execute() {
        try {

            writeToFile("player.dat");


        }
        catch (IOException e) {
            System.out.println("spatne");
        }


        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
