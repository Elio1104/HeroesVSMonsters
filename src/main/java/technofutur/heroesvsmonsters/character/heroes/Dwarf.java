package technofutur.heroesvsmonsters.character.heroes;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import technofutur.heroesvsmonsters.character.Race.HeroRace;
import technofutur.heroesvsmonsters.utils.ImageUtils;

public class Dwarf extends Hero {
    public Dwarf() {
        super();
        this.bonusEndurance = 2;
        this.bonusStrength = 0 ;
        this.race = HeroRace.fromString("DWARF");

        Image image = new Image(getClass().getResourceAsStream("/technofutur/heroesvsmonsters/Dwarf.png"));
        WritableImage croppedImage = ImageUtils.cropImage(image, 150, 0, 85, 128);
        this.setImage(croppedImage);
    }
}
