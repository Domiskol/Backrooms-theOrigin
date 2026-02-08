import java.util.Scanner;

public class Pickup extends Command {

    private Player player;

    public Pickup(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {

        Location currentLocation = player.getCurrentLocation();

        // pojistka
        if (currentLocation == null) {
            return "Chyba: Nejsi v žádné místnosti.";
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Předměty v místnosti: " + currentLocation.getItemsInRoom());
        System.out.print("Co chceš sebrat? ");
        String nazevPredmetu = sc.nextLine().trim().toLowerCase();

        Item item = currentLocation.findItem(nazevPredmetu);

        if (item != null) {
            currentLocation.removeItem(item);
            player.pickUpItem(item);

            return "Sebral jsi: " + item.getName();
        } else {
            return "Takový předmět tu nevidím.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }



}
