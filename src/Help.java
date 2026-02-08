public class Help extends Command {

    @Override
    public String execute() {
        return "help, stop, pohyb, seber, inventory, drop, mluv";
    }

    @Override
    public boolean exit() {
        return false;
    }
}



