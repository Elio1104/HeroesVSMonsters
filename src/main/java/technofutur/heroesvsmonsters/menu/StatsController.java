package technofutur.heroesvsmonsters.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.inventory.Loot;
import technofutur.heroesvsmonsters.utils.StringUtils;

public class StatsController {

    @FXML
    private GridPane statsGrid;

    @FXML
    private VBox inventoryBox;

    public void setHero(Hero hero) {
        addStatRow("Name :", hero.getName());
        addStatRow("Health :", hero.getCurrentHealth() + " / " + hero.getHealth());
        addStatRow("Strength :", hero.getStrength() + " + " + hero.getBonusStrength());
        addStatRow("Endurance :", hero.getEndurance() + " + " + hero.getBonusEndurance());
        addStatRow("Race :", StringUtils.capitalizeFirstLetter(hero.getRace().toString()));
        addStatRow("Faction :", StringUtils.capitalizeFirstLetter(hero.getFactionType().toString()));
        addStatRow("Alive :", hero.isAlive() ? "Yes" : "No");

        for (Loot item : hero.getInventory().getLootList().keySet()) {
            Label itemLabel = new Label(StringUtils.capitalizeFirstLetter(item.getName()) + " x" + hero.getInventory().getLootAmount(item));
            itemLabel.setStyle("-fx-text-fill: #FFD700;");
            inventoryBox.getChildren().add(itemLabel);
        }
    }

    private void addStatRow(String key, String value) {
        Label keyLabel = new Label(key);
        keyLabel.setStyle("-fx-text-fill: #FFD700;");
        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-text-fill: #FFD700;");
        statsGrid.addRow(statsGrid.getRowCount(), keyLabel, valueLabel);
    }
}