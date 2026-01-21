package location;

public  class Location {
    private String name, description;

    public Location() {

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

    @Override
    public String toString() {
        return "Location{" +
                "name ='" + name + '\'' +
                ", description ='" + description + '\'' +
                '}';
    }
}