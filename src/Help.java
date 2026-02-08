public class Help extends Command {

    @Override
    public String execute() {
        return "help, stop, pohyb";
    }

    @Override
    public boolean exit() {
        return false;
    }
}



