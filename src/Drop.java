import java.util.*;

public class Drop extends Command{

    private Player player;

    public Drop(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getInventory().isEmpty()) {
            return "Nemáš co zahodit, batoh je prázdný.";
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("V batohu máš: " + player.getInventory());
        System.out.print("Co chceš zahodit? ");
        String nazev = sc.nextLine().trim().toLowerCase();

        // 1. Najdeme předmět v batohu
        Item item = player.findItemInInventory(nazev);

        if (item != null) {
            // 2. Odebereme ho hráči
            player.removeItem(item);

            // 3. Přidáme ho do aktuální místnosti
            // (Předpokládám, že Location má metodu addItem - viz níže)
            player.getCurrentLocation().addItem(item);

            return "Zahodil jsi " + item.getName();
        } else {
            return "Takový předmět u sebe nemáš.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }


}
