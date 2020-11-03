package designpatterns.functionalcommand;

public class Main {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        Receiver receiver1 = new Receiver();
        Receiver receiver2 = new Receiver();

        invoker.register(receiver1::action1);
        invoker.execute();

        invoker.register(receiver2::action2);
        invoker.execute();

        invoker.register(receiver2::action1);
        invoker.execute();

        invoker.register(() -> System.out.println("extra-command"));
        invoker.execute();

        invoker.register(() -> new Receiver().action2());
        invoker.execute();
    }
}
