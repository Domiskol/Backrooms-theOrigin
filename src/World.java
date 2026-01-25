
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
public class World {

    private String startRoom;
    private Map<String, Room> rooms;
    public static World load(String path) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(path), World.class);
    }


    public Room getRoom(String id) {
        return rooms.get(id);
    }

    public Room getStartRoom() {
        return rooms.get(startRoom);
    }
    public boolean hasRoom(String id) {
        return rooms.containsKey(id);
    }
}

