package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import technofutur.heroesvsmonsters.character.heroes.Hero;

import java.io.IOException;

public class LeftMenu {
    VBox leftMenu;

    public LeftMenu(Hero hero) throws IOException {
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
        StatsController statsController = statsLoader.getController();
        statsController.setHero(hero);

        return statsRoot;
    }

    private VBox inventoryLoader(Hero hero) throws IOException {
        FXMLLoader inventoryLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/inventory.fxml"));
        VBox inventoryRoot = inventoryLoader.load();
        InventoryController inventoryController = inventoryLoader.getController();
        inventoryController.setHero(hero);

        return inventoryRoot;
    }
}
