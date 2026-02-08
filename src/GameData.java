import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameData {

    public ArrayList<Item> items;
    public ArrayList<GameCharacter> characters;
    public ArrayList<Location> locations;


    public static GameData loadGameDataFromResources(String resourcePath) {

        Gson gson = new Gson();


        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {


            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }


            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }

    public Location findLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)){
                return l;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
    }


    public void initWorld() {
        if (locations == null) return;

        for (Location loc : locations) {
            // Pokud má lokace v JSONu nějaké předměty
            if (loc.getInitialItemIds() != null) {
                for (String itemId : loc.getInitialItemIds()) {
                    // Najdeme skutečný předmět podle ID
                    Item item = findItemById(itemId);
                    if (item != null) {
                        loc.addItem(item); // Vložíme ho do místnosti
                    }
                }
            }
        }
    }
    public Item findItemById(String id) {
        for (Item i : items) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }


}
