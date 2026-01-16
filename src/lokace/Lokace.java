package lokace;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.InputStream;

public abstract class Lokace {
    protected String nazev,popis;

    public Lokace(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }
    public void create () {
        ObjectMapper parser = new ObjectMapper();

        try {
            InputStream input = new FileInputStream("res/Location.json");
            Lokace lokace = parser.readValue(input, Lokace.class);
            System.out.println(lokace);



        }catch (FileNotFoundException e){
            System.out.println("nefunguje");
        } catch (Exception e) {
            System.out.println("nefunguje ");
        }
    }



    public String getNazev() {
        return nazev;
    }



    public String getPopis() {
        return popis;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
}
