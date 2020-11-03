package codeadvent.paintrobot;

public class Logger {

    public static void log(String msg, boolean enabled) {
        if (!enabled) return;
        System.out.println(msg);
    }

}
