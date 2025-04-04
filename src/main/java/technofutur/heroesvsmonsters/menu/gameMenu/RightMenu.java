package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import technofutur.heroesvsmonsters.character.monsters.Monster;

import java.io.IOException;

public class RightMenu {
    VBox rightMenu;
    StatsController statsController;
    Monster monster;

    public RightMenu() throws IOException {
        this.monster = null;
        rightMenu = new VBox();
        rightMenu.setId("leftMenu");

        rightMenu.getChildren().add(statsLoader(monster));
    }

    public VBox getRightMenu() {
        return rightMenu;
    }

    private VBox statsLoader(Monster monster) throws IOException {
        FXMLLoader statsLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/stats.fxml"));
        VBox statsRoot = statsLoader.load();
        statsController = statsLoader.getController();
        if (monster == null)
            return statsRoot;

        statsController.setMonster(monster);
        return statsRoot;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;

    }

    public void updateStats() {
        statsController.redraw(monster);
    }

    public void clearStats() {
        statsController.clear();
    }
}
