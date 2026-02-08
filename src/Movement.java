public class Movement extends Command{

    private Player p;

    public Movement(Player p) {
        this.p = p;
    }

    @Override
    public String execute() {
        //TODO dodelat pohyb

        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}