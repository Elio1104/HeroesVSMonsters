package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.inventory.Loot;
import technofutur.heroesvsmonsters.utils.StringUtils;

public class InventoryController {
    @FXML
    private VBox inventoryBox;

    public void setHero(Hero hero) {
        for (Loot item : hero.getInventory().getLootList().keySet()) {
            Label itemLabel = new Label(StringUtils.capitalizeFirstLetter(item.getName()) + " x" + hero.getInventory().getLootAmount(item));
            itemLabel.setStyle("-fx-text-fill: #FFD700; -fx-font-size: 18px;");
            inventoryBox.getChildren().add(itemLabel);
        }
    }

    public void redraw(Hero hero) {
        inventoryBox.getChildren().clear();
        setHero(hero);
    }
}
