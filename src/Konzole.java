
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

    }

    private void proved() {
        System.out.print(">>");
        String prikaz = scanner.next();
        prikaz = prikaz.trim().toLowerCase();
        ulozPrikaz(prikaz);
        if (mapa.containsKey(prikaz)) {
            System.out.println(">> " + mapa.get(prikaz).execute());
            exit = mapa.get(prikaz).exit();
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }
    public void start() {
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
