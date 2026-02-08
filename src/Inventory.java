public class Inventory extends Command{

    private Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getInventory().isEmpty()) {
            return "Tvůj inventář je prázdný.";
        }


        return "V batohu máš: " + player.getInventory().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }


}
