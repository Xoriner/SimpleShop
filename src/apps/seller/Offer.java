package apps.seller;

public class Offer {
    private int id;
    private String name;
    private String description;
    private int state;

    public Offer(int id, String name, String description, int state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }
}
