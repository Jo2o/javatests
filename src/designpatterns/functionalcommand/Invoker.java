package designpatterns.functionalcommand;

public class Invoker {

    private Command command;

    public void register(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

}
