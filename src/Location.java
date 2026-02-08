
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Location {

    private String id;
    private String name;
    private String description;
    private Map<String, String> exits;
    private List<String> items;
    private transient List<Item> itemsInRoom = new ArrayList<>();

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public String getExitId(String direction) {
        return exits != null ? exits.get(direction) : null;
    }

    public List<String> getInitialItemIds() {
        return items;
    }

    public List<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public Map<String, String> getExits() {
        return exits;
    }


    public void addItem(Item item) {
        if (itemsInRoom == null) {
            itemsInRoom = new ArrayList<>();
        }
        itemsInRoom.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }




    public Item findItem(String itemName) {
        for (Item item : itemsInRoom) {
            if (item.getName().toLowerCase().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    private List<String> characterIds;
    private transient List<GameCharacter> charactersInRoom = new ArrayList<>();

    public void addCharacter(GameCharacter character) {
        charactersInRoom.add(character);
    }

    public List<GameCharacter> getCharactersInRoom() {
        return charactersInRoom;
    }

    public GameCharacter findCharacter(String name) {
        for (GameCharacter c : charactersInRoom) {
            if (c.getName().toLowerCase().equals(name.toLowerCase())) return c;
        }
        return null;
    }
    public List<String> getInitialCharacterIds() {
        return characterIds;
    }



}
