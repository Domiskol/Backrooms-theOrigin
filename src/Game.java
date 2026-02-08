import java.util.HashMap;

public class Game {

    public GameData world;
    private Player player;


    public void inicialization(){


        world = GameData.loadGameDataFromResources("/gamedata.json");

        this.player = new Player();
        if (!world.locations.isEmpty()) {
            player.setCurrentLocation(world.locations.get(0));
        }
        Konzole konzole = new Konzole(this.player, this);
        konzole.start();

    }


    public void start(){
        inicialization();

    }

}