package technofutur.heroesvsmonsters.utils;

import java.util.Arrays;

public class Dice {
    public static int roll(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public static int roll(int sides, int times) {
        int total = 0;
        for (int i = 0; i < times; i++) {
            total += roll(sides);
        }
        return total;
    }

    public static int roll(int sides, int times, int modifier) {
        return roll(sides, times) + modifier;
    }

    public static int bestOf(int sides, int times) {
        int best = 0;
        for (int i = 0; i < times; i++) {
            int roll = roll(sides);
            if (roll > best) {
                best = roll;
            }
        }
        return best;
    }

    public static int bestOf(int sides, int number, int numberOfRolls) {
        int[] rolls = new int[numberOfRolls];
        for (int i = 0; i < numberOfRolls; i++) {
            rolls[i] = roll(sides);
        }
        Arrays.sort(rolls);
        int total = 0;
        for (int i = numberOfRolls - 1; i >= numberOfRolls - number; i--) {
            total += rolls[i];
        }
        return total;
    }
}
