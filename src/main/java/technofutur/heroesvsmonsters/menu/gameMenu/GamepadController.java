package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXML;
import technofutur.heroesvsmonsters.mapGenerator.MapGenerator;
import technofutur.heroesvsmonsters.menu.MenuController;

public class GamepadController {

    private MapGenerator mapGenerator;
    private CheckerboardController checkerboardController;

    public void setMapGenerator(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    public void setCheckerboardController(CheckerboardController checkerboardController) {
        this.checkerboardController = checkerboardController;
    }

    @FXML
    private void movePlayerUp() {
        if (!mapGenerator.isEnemyNearby()) {
            mapGenerator.movePlayerUp();
            checkerboardController.drawMap();
            checkEnemyNearby();
        }
    }

    @FXML
    private void movePlayerDown() {
        if (!mapGenerator.isEnemyNearby()) {
            mapGenerator.movePlayerDown();
            checkerboardController.drawMap();
            checkEnemyNearby();
        }
    }

    @FXML
    private void movePlayerLeft() {
        if (!mapGenerator.isEnemyNearby()) {
            mapGenerator.movePlayerLeft();
            checkerboardController.drawMap();
            checkEnemyNearby();
        }
    }

    @FXML
    private void movePlayerRight() {
        if (!mapGenerator.isEnemyNearby()) {
            mapGenerator.movePlayerRight();
            checkerboardController.drawMap();
            checkEnemyNearby();
        }
    }

    @FXML
    private void attack() {
        if (mapGenerator.isEnemyNearby()) {
            mapGenerator.getBattle().heroAttack();
            MenuController.rightMenuObj.updateStats();
            if (!mapGenerator.getBattle().isMonsterAlive()) {
                mapGenerator.endBattle();
                checkerboardController.drawMap();
            } else {
                mapGenerator.getBattle().monsterAttack();
                MenuController.leftMenuObj.updateStats();
            }
        }
    }

    private void checkEnemyNearby() {
        if (mapGenerator.isEnemyNearby()) {
            mapGenerator.startBattle();
        }
    }
}