import java.util.*;

public class Player{


    private Location currentLocation;
    private List<Item> inventory = new ArrayList<>();
    private int maxCapacity = 5;

    public Location getCurrentLocation() {

        return currentLocation;
    }

    public void setCurrentLocation(Location location) {

        this.currentLocation = location;
    }

    public boolean pickUpItem(Item item) {
        if (inventory.size() < maxCapacity) {
            inventory.add(item);
            return true;
        }
        return false;
    }

    public int getInventorySize() {
        return inventory.size();
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getInventoryContent() {
        if (inventory.isEmpty()){
            return "Tvůj batoh je prázdný.";
        }
        return "V batohu máš: " + inventory.toString();
    }
    public void removeItem(Item item) {
        inventory.remove(item);
    }


    public List<Item> getInventory() {
        return inventory;
    }
    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().toLowerCase().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

}


