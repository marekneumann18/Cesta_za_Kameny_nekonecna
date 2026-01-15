package postavy;

public class Postava {
    protected String jmeno;
    protected int zivoty;
    public Postava(String jmeno, int zivoty) {
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
