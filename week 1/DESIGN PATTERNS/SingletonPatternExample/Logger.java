import java.util.*;

public class Logger {
    private static Logger instance;

    public static Logger instance() {

    }

    public Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void msg() {
        System.out.println("hi");
    }

    public static void txt() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Logger l1 = new Logger();
        Logger l2 = new Logger();
        l1.msg();
        l2.txt();
        l2.msg();
    }
}