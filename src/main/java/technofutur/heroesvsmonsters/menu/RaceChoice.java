package technofutur.heroesvsmonsters.menu;

import technofutur.heroesvsmonsters.character.heroes.Dwarf;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.character.heroes.Human;

import java.util.Scanner;

public class RaceChoice {
    public static Hero ChoiceMenu() {
        Hero player = null;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Choose : Human or Dwarf ?");
            String choice = scanner.nextLine();
            switch (choice) {
                case "Human":
                    player = new Human();
                    break;
                case "Dwarf":
                    player = new Dwarf();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (player == null);

        return player;
    }
}
