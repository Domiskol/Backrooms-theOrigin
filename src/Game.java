import java.util.HashMap;

public class Game {

    public GameData world;
    private Player player;
    private HashMap<String, Command> commands;

    public void inicialization(){
        Konzole konzole = new Konzole();
        konzole.start();
        commands = new HashMap<>();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        //TODO pridat commands
        commands.put("pohyb", new Movement(player));

    }

    public void start(){
        inicialization();
        //zde bude herni smycka
    }

}