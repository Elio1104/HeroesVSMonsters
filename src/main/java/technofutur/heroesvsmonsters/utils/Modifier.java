package technofutur.heroesvsmonsters.utils;

public class Modifier {
    public static int getModifier(int value) {
        if (value < 5)
            return -1;
        else if (value < 10)
            return 0;
        else if (value < 15)
            return 1;
        else
            return 2;
    }
}
