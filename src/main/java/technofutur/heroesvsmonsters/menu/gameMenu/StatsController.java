package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.utils.StringUtils;

public class StatsController {

    @FXML
    private GridPane statsGrid;

    public void setHero(Hero hero) {
        addStatRow("Name :", hero.getName());
        addStatRow("Health :", hero.getCurrentHealth() + " / " + hero.getHealth());
        addStatRow("Strength :", hero.getStrength() + " + " + hero.getBonusStrength());
        addStatRow("Endurance :", hero.getEndurance() + " + " + hero.getBonusEndurance());
        addStatRow("Race :", StringUtils.capitalizeFirstLetter(hero.getRace().toString()));
        addStatRow("Faction :", StringUtils.capitalizeFirstLetter(hero.getFactionType().toString()));
        addStatRow("Alive :", hero.isAlive() ? "Yes" : "No");
    }

    private void addStatRow(String key, String value) {
        Label keyLabel = new Label(key);
        keyLabel.setStyle("-fx-text-fill: #FFD700; -fx-font-size: 18px;");
        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-text-fill: #FFD700; -fx-font-size: 18px;");
        statsGrid.addRow(statsGrid.getRowCount(), keyLabel, valueLabel);
    }
}