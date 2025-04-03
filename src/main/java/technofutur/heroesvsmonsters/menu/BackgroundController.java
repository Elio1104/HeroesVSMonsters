package technofutur.heroesvsmonsters.menu;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BackgroundController {

    @FXML
    private StackPane root;

    @FXML
    private ImageView backgroundImage;

    @FXML
    public void initialize() {
        backgroundImage.fitWidthProperty().bind(root.widthProperty());
        backgroundImage.fitHeightProperty().bind(root.heightProperty());
    }
}
