
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private Player player;
    private Game game;
    private boolean exit = false;
    private HashMap<String, Command> mapa = new HashMap<>();
    public static String souborPrikazu = "souborPrikazu.txt";
    private Scanner scanner = new Scanner(System.in);


    public Konzole(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    private void inicializace(){

        mapa.put("help", new Help());
        mapa.put("stop", new Quit());
        mapa.put("pohyb", new Movement(player, game));
        mapa.put("seber", new Pickup(player));
        mapa.put("inventory", new Inventory(this.player));
        mapa.put("drop", new Drop(this.player));
        mapa.put("mluv", new Talk(this.player));

    }

    private void proved() {
        System.out.print(">>");
        String prikaz = scanner.next();
        prikaz = prikaz.trim().toLowerCase();
        ulozPrikaz(prikaz);

        if (mapa.containsKey(prikaz)) {
            Command c = mapa.get(prikaz);
            String result = c.execute();
            System.out.println(">> " + result);
            this.exit = c.exit();

            String locId = player.getCurrentLocation().getId();
            if (locId.equals("observacni_sal")) {
                System.out.println(">> VYHRÁL JSI!");
                this.exit = true;

            } else if (result.contains("SMRT")) {
                this.exit = true;
            }
        }



    }
    public void start() {
        System.out.println("Hlavní postava hry Dominik pochází ze školy jménem Ječná, která poslední roky\n" +
                "prochází obdobím pojmenovaném žáky školy \"The Disappearing\". Ze školy zmizelo\n" +
                "záhadně a bez vysvětlení 6 žáku v období 3 měsíců. Dominik šel chodbou při hodině na\n" +
                "záchod a kromě tvrdé země, kterou by měl cítit pod svými chodidly, ucítil prázdnotu jako\n" +
                "kdyby padal z výšky. Dál si už nic nepamatuje. Hra začíná když se Dominik vzbudí ve\n" +
                "vysoké místnosti z bílými stěnami a žlutými světly vydávající bzučivý nepříjemný zvuk. ");
        inicializace();
        try {
            resetSouboruProPrikazy();
            do {
                proved();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    private void ulozPrikaz(String prikaz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, true))) {
            bw.write(prikaz);
            bw.newLine();
        } catch (Exception e) {

        }
    }
    private void resetSouboruProPrikazy() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, false))) {
        } catch (Exception e) {
        }
    }



}
