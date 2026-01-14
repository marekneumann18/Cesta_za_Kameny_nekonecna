package hrac;

public class Hrac {
    private String jmeno;
    private int zivoty ;

    public Hrac(String jmeno, int zivoty) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

}
