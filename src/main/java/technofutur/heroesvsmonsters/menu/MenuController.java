package technofutur.heroesvsmonsters.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import technofutur.heroesvsmonsters.character.heroes.Dwarf;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.character.heroes.Human;
import technofutur.heroesvsmonsters.menu.gameMenu.CheckerboardController;
import technofutur.heroesvsmonsters.menu.gameMenu.GamepadController;
import technofutur.heroesvsmonsters.menu.gameMenu.LeftMenu;
import technofutur.heroesvsmonsters.menu.gameMenu.RightMenu;

import java.io.IOException;

public class MenuController {
    public static LeftMenu leftMenuObj;
    public static RightMenu rightMenuObj;
    public static VBox middleMenu;

    @FXML
    private void handleHumanButton() throws IOException {
        Hero player = new Human();
        player.setPosX(7);
        player.setPosY(7);
        newStory(player);
    }

    @FXML
    private void handleDwarfButton() throws IOException {
        Hero player = new Dwarf();
        player.setPosX(8);
        player.setPosY(8);
        newStory(player);
    }

    private void newStory(Hero hero) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("New Story");

        FXMLLoader backgroundLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/background.fxml"));
        StackPane root = backgroundLoader.load();

        leftMenuObj = new LeftMenu(hero);
        VBox leftMenu = leftMenuObj.getLeftMenu();
        leftMenu.setAlignment(Pos.CENTER);

        VBox middleMenu = new VBox();
        middleMenu.setId("middleMenu");
        middleMenu.setAlignment(Pos.CENTER);

        FXMLLoader checkerboardLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/checkerboard.fxml"));
        GridPane checkerboard = checkerboardLoader.load();

        CheckerboardController checkerboardController = checkerboardLoader.getController();
        checkerboardController.setPlayer(hero);

        middleMenu.getChildren().add(checkerboard);

        FXMLLoader gamepadLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/gamepad.fxml"));
        VBox gamepad = gamepadLoader.load();
        GamepadController gamepadController = gamepadLoader.getController();
        gamepadController.setMapGenerator(checkerboardController.getMapGenerator());
        gamepadController.setCheckerboardController(checkerboardController);

        middleMenu.getChildren().add(gamepad);

        rightMenuObj = new RightMenu();
        VBox rightMenu = rightMenuObj.getRightMenu();
        rightMenu.setAlignment(Pos.CENTER);

        HBox mainContent = new HBox(leftMenu, middleMenu, rightMenu);
        mainContent.setId("mainContent");
        mainContent.setPrefSize(1700, 1000);

        leftMenu.setPrefWidth(mainContent.getPrefWidth() * 0.25);
        middleMenu.setPrefWidth(mainContent.getPrefWidth() * 0.5);
        rightMenu.setPrefWidth(mainContent.getPrefWidth() * 0.25);

        root.getChildren().add(mainContent);

        stage.setScene(new Scene(root, 1700, 1000));
        stage.show();
    }


}