package technofutur.heroesvsmonsters.menu.gameMenu;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.mapGenerator.MapGenerator;

public class CheckerboardController {

    @FXML
    private GridPane gridPane;

    private MapGenerator mapGenerator;
    private Hero player;

    public CheckerboardController() {
        this.mapGenerator = new MapGenerator();
    }

    @FXML
    public void initialize() {
        drawMap();
    }

    public void drawMap() {
        gridPane.getChildren().clear();
        int size = 15;
        double rectSize = 40;

        Color color1 = Color.rgb(128, 128, 128, 0.9); // Gris transparent à 10%
        Color color2 = Color.rgb(169, 169, 169, 0.9); // Gris clair transparent à 10%

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle rect = new Rectangle(rectSize, rectSize);
                if ((row + col) % 2 == 0) {
                    rect.setFill(color1);
                } else {
                    rect.setFill(color2);
                }
                gridPane.add(rect, col, row);


                if (mapGenerator.getPlayer() != null && mapGenerator.getPlayer().getPosX() == col && mapGenerator.getPlayer().getPosY() == row) {
                    Text text = new Text("P");
                    gridPane.add(text, col, row);
                    GridPane.setHalignment(text, javafx.geometry.HPos.CENTER);
                    GridPane.setValignment(text, javafx.geometry.VPos.CENTER);
                } else if (mapGenerator.getGrid()[row][col] != null) {
                    Text text = new Text(String.valueOf(mapGenerator.getGrid()[row][col].getClass().getSimpleName().charAt(0)));
                    gridPane.add(text, col, row);
                    GridPane.setHalignment(text, javafx.geometry.HPos.CENTER);
                    GridPane.setValignment(text, javafx.geometry.VPos.CENTER);
                } else if (mapGenerator.getPlayer() == null && col == 7 && row == 7) {
                    Text text = new Text("P");
                    gridPane.add(text, col, row);
                    GridPane.setHalignment(text, javafx.geometry.HPos.CENTER);
                    GridPane.setValignment(text, javafx.geometry.VPos.CENTER);
                }
            }
        }
    }


        /*// Appliquer un cisaillement pour l'effet isométrique
        Shear shear = new Shear(-0.8, 0);
        gridPane.getTransforms().add(shear);
        */



    public void setMap(MapGenerator map) {
        this.mapGenerator = map;
    }

    public void setPlayer(Hero player) {
        System.out.println("setPlayer");
        this.player = player;
        mapGenerator.setPlayer(player);
    }

    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }
}