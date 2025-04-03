package technofutur.heroesvsmonsters.character.heroes;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import technofutur.heroesvsmonsters.character.Race.HeroRace;
import technofutur.heroesvsmonsters.utils.ImageUtils;

public class Human extends Hero{
    public Human() {
        super();
        this.bonusEndurance = 1;
        this.bonusStrength = 1;
        this.race = HeroRace.fromString("HUMAN");

        Image image = new Image(getClass().getResourceAsStream("/technofutur/heroesvsmonsters/Human.png"));
        WritableImage croppedImage = ImageUtils.cropImage(image, 155, 0, 85, 128);
        this.setImage(croppedImage);
    }
}
