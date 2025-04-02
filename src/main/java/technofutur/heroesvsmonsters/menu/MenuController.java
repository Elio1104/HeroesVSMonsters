package technofutur.heroesvsmonsters.menu;

import javafx.fxml.FXML;
import technofutur.heroesvsmonsters.battle.Battle;
import technofutur.heroesvsmonsters.character.heroes.Dwarf;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.character.heroes.Human;
import technofutur.heroesvsmonsters.character.monsters.Monster;
import technofutur.heroesvsmonsters.character.monsters.Dragon;
import technofutur.heroesvsmonsters.character.monsters.Orca;
import technofutur.heroesvsmonsters.character.monsters.Wolf;
import technofutur.heroesvsmonsters.utils.Color;

import java.util.Random;

public class MenuController {

    @FXML
    private void handleHumanButton() {
        Hero player = new Human();
        startBattles(player);
    }

    @FXML
    private void handleDwarfButton() {
        Hero player = new Dwarf();
        startBattles(player);
    }

    private void startBattles(Hero player) {
        Random random = new Random();
        int combatCount = 0;

        while (player.isAlive()) {
            Monster monster = getRandomMonster(random);
            Battle battle = new Battle(player, monster);
            battle.startBattle();
            combatCount++;

            if (player.isAlive()) {
                player.rest();
                System.out.println(player);
                System.out.println(player.getInventory());
            }
        }

        System.out.println(Color.black("GAME OVER"));
        System.out.println(Color.black("Number of fights carried out : " + combatCount));
    }

    private Monster getRandomMonster(Random random) {
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> new Dragon();
            case 1 -> new Orca();
            case 2 -> new Wolf();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }
}