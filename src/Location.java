
import java.util.Map;

public class Location {

    private String id;
    private String name;
    private String description;
    private Map<String, String> exits;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public String getExitId(String direction) {
        return exits != null ? exits.get(direction) : null;
    }

    public Map<String, String> getExits() {
        return exits;
    }
}
