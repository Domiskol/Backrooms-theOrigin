public class Help extends Command {

    @Override
    public String execute() {
        return "help, stop";
    }

    @Override
    public boolean exit() {
        return false;
    }
}



