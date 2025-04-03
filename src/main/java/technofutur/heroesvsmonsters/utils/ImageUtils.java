package technofutur.heroesvsmonsters.utils;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;

public class ImageUtils {

    public static WritableImage cropImage(Image image, double minX, double minY, double width, double height) {
        ImageView imageView = new ImageView(image);
        imageView.setViewport(new Rectangle2D(minX, minY, width, height));

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        return imageView.snapshot(params, null);
    }
}