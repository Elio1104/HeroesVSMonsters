package technofutur.heroesvsmonsters;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader backgroundLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/background.fxml"));
        StackPane root = backgroundLoader.load();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/fxml/mainMenu.fxml"));
        VBox menuRoot = menuLoader.load();
        root.getChildren().add(menuRoot);

        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setTitle("Heroes VS Monsters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
