package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import technofutur.heroesvsmonsters.character.heroes.Hero;

import java.io.IOException;

public class LeftMenu {
    private VBox leftMenu;
    private StatsController statsController;
    private InventoryController inventoryController;
    private Hero hero;

    public LeftMenu(Hero hero) throws IOException {
        this.hero = hero;
        leftMenu = new VBox();
        leftMenu.setId("leftMenu");

        leftMenu.getChildren().add(ppLoader(hero));

        leftMenu.getChildren().add(statsLoader(hero));

        leftMenu.getChildren().add(inventoryLoader(hero));
    }

    public VBox getLeftMenu() {
        return leftMenu;
    }

    private VBox ppLoader(Hero hero) throws IOException {
        FXMLLoader ppLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/pp.fxml"));
        VBox ppRoot = ppLoader.load();
        ImageView playerImage = (ImageView) ppRoot.lookup("#playerImage");
        playerImage.setImage(hero.getImage());

        return ppRoot;
    }

    private VBox statsLoader(Hero hero) throws IOException {
        FXMLLoader statsLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/stats.fxml"));
        VBox statsRoot = statsLoader.load();
        statsController = statsLoader.getController();
        statsController.setHero(hero);

        return statsRoot;
    }

    private VBox inventoryLoader(Hero hero) throws IOException {
        FXMLLoader inventoryLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/inventory.fxml"));
        VBox inventoryRoot = inventoryLoader.load();
        inventoryController = inventoryLoader.getController();
        inventoryController.setHero(hero);

        return inventoryRoot;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void updateStats() {
        statsController.redraw(hero);
    }

    public void updateInventory() {
        inventoryController.redraw(hero);
    }
}
