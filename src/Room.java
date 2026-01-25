
import java.util.Map;
public class Room {
    private String id;
    private String name;
    private String description;
    private Map<String, String> exits;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Map<String, String> getExits() {
        return exits;
    }


    public String getExit(String direction) {
        return exits.get(direction);
    }
}



