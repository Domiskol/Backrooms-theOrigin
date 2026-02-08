import java.util.*;

public class Player{

  /*  @Override
    public String execute() {
        return ;
    }

    @Override
    public boolean exit() {
        return false;
   }
*/
    private Location currentLocation;
    private List<Item> inventory = new ArrayList<>();

    public Location getCurrentLocation() {

        return currentLocation;
    }

    public void setCurrentLocation(Location location) {

        this.currentLocation = location;
    }

    public void pickUpItem(Item item) {
        inventory.add(item);
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


