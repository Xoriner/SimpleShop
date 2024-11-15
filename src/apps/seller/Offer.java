package apps.seller;

public class Offer {
    private int id;
    private String name;
    private String description;
    private String state;

    public Offer(int id, String name, String description, String state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
