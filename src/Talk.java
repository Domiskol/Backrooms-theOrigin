import java.util.*;


public class Talk extends Command{

    private Player player;

    public Talk(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        Location l = player.getCurrentLocation();

        if (l.getCharactersInRoom().isEmpty()) {
            return "Nikdo tu není, mluvíš si pro sebe.";
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Postavy v místnosti: ");
        for (GameCharacter c : l.getCharactersInRoom()) {
            System.out.println("- " + c.getName());
        }

        System.out.print("S kým chceš mluvit? ");
        String jmeno = sc.nextLine().trim();

        GameCharacter target = l.findCharacter(jmeno);

        if (target != null) {
            return target.getName() + " říká: \"" + target.getSpeech() + "\"";
        } else {
            return "Tahle postava tu není.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }


}
