package lokace;

public abstract class Location {
    protected String name, description;

    public Location(String nazev, String popis) {
        this.name = nazev;
        this.description = popis;
    }




    public String getName() {
        return name;
    }



    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
