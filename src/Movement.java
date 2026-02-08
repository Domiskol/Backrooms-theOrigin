import java.util.Scanner;

public class Movement extends Command{

    private Player p;
    private Game game; // Potřebujeme přístup k world data

    public Movement(Player p, Game game) {
        this.p = p;
        this.game = game;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kam chceš jít? (dostupné směry: " + p.getCurrentLocation().getExits().keySet() + ")");
        String direction = sc.nextLine().trim().toLowerCase();

        // 1. Zjistíme ID cílové lokace z aktuální místnosti
        String targetLocationId = p.getCurrentLocation().getExitId(direction);

        if (targetLocationId != null) {
            // 2. Najdeme objekt lokace v načtených datech (world)
            Location nextLocation = game.world.findLocation(targetLocationId);

            if (nextLocation != null) {
                p.setCurrentLocation(nextLocation);
                return "Přešel jsi do: " + nextLocation.getName() + "\n" + nextLocation.getDescription();
            }
        }

        return "Tímto směrem se nedá jít!";
    }

    @Override
    public boolean exit() { return false; }
}