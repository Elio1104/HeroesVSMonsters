package technofutur.heroesvsmonsters;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/technofutur/heroesvsmonsters/menu.fxml"));
        StackPane root = loader.load();
        Scene scene = new Scene(root, 1200, 1000);
        primaryStage.setTitle("Heroes VS Monsters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
