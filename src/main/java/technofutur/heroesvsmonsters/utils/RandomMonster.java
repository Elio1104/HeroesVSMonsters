package technofutur.heroesvsmonsters.utils;

import technofutur.heroesvsmonsters.character.monsters.Dragon;
import technofutur.heroesvsmonsters.character.monsters.Monster;
import technofutur.heroesvsmonsters.character.monsters.Orca;
import technofutur.heroesvsmonsters.character.monsters.Wolf;

import java.util.Random;

public class RandomMonster {
    public static Monster getRandomMonster() {
        Random random = new Random();
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> new Dragon();
            case 1 -> new Orca();
            case 2 -> new Wolf();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public static Monster getRandomMonster(int posX, int posY) {
        Random random = new Random();
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> new Dragon(posX, posY);
            case 1 -> new Orca(posX, posY);
            case 2 -> new Wolf(posX, posY);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }
}
