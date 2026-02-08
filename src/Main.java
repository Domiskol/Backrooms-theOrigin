class Backrooms{

    public static void main(String[] args){
        Game game = new Game();
        GameData data = new GameData();
        game.world = GameData.loadGameDataFromResources("/gamedata.json");
        System.out.println(game.world.items);


    }

}
