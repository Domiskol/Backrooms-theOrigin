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
                return "Přešel jsi do: " + nextLocation.getName() + "\n" + nextLocation.getDescription();
            }
        }
        Location novaLokace = p.getCurrentLocation();

        if (!novaLokace.getCharactersInRoom().isEmpty()) {
            for (GameCharacter c : novaLokace.getCharactersInRoom()) {

                if ("kreslir".equals(c.getName())) {
                    System.out.println("!!! POZOR !!!");
                    System.out.println("V rohu místnosti vidíš: " + c.getName());
                    System.out.println(c.getSpeech());

                }
            }
        }



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