import java.util.Scanner;

public class Movement extends Command{

    private Player p;
    private Game game;
    private boolean isWin = false;

    public Movement(Player p, Game game) {
        this.p = p;
        this.game = game;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kam chceš jít? (dostupné směry: " + p.getCurrentLocation().getExits().keySet() + ")");
        String direction = sc.nextLine().trim().toLowerCase();


        String targetLocationId = p.getCurrentLocation().getExitId(direction);

        if (targetLocationId != null) {

            Location nextLocation = game.world.findLocation(targetLocationId);

            if (nextLocation != null) {
                p.setCurrentLocation(nextLocation);


                // jestli neni v inventari item tak umre
                if (nextLocation.getId().equals("temna_mistnost")) {

                    boolean hasWeapon = p.findItemInInventory("meč") != null || p.findItemInInventory("nouzový sprej") != null;

                    if (!hasWeapon) {
                        this.isWin = false;

                        return "!!! SMRT !!!\nVstoupil jsi do temné místnosti nepřipraven. Slepá entita tě slyšela dřív, než jsi ji mohl ucítit. Hra končí.";
                    }
                }


                return "Přešel jsi do: " + nextLocation.getName() + "\n" + nextLocation.getDescription();
            }
        }
        Location novaLokace = p.getCurrentLocation();



        if (novaLokace.getId().equals("observacni_sal")) {
            this.isWin = true;
            return "Vydes do mistnosti a pocit stastnosti te naplni...  nasel si vychod!";
        }




        return "Tímto směrem se nedá jít!";
    }


    @Override
    public boolean exit() {
        return isWin;
    }
}