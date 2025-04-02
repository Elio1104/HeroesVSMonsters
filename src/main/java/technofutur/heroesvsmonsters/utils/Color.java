package technofutur.heroesvsmonsters.utils;

public class Color {

    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public static String colorize(String message, String color) {
        return color + message + RESET;
    }

    public static String black(String message) {
        return colorize(message, BLACK);
    }

    public static String red(String message) {
        return colorize(message, RED);
    }

    public static String green(String message) {
        return colorize(message, GREEN);
    }

    public static String yellow(String message) {
        return colorize(message, YELLOW);
    }

    public static String blue(String message) {
        return colorize(message, BLUE);
    }

    public static String purple(String message) {
        return colorize(message, PURPLE);
    }

    public static String cyan(String message) {
        return colorize(message, CYAN);
    }

    public static String white(String message) {
        return colorize(message, WHITE);
    }
}
