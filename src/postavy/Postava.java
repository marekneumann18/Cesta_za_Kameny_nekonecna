package postavy;

public class Postava {
    protected String name;
    protected int hp;
    public Postava(String jmeno, int zivoty) {
        this.name = jmeno;
        this.hp = zivoty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
