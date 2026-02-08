public class Item {

    private String id;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name +  ", description: " + description+ " ";
    }
}
