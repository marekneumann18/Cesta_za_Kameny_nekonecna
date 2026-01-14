package lokace;

public abstract class Lokace {
    protected String nazev,popis;

    public Lokace(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }



    public String getNazev() {
        return nazev;
    }



    public String getPopis() {
        return popis;
    }



}
