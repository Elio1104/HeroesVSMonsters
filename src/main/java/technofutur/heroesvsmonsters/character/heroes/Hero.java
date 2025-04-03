package technofutur.heroesvsmonsters.character.heroes;

import technofutur.heroesvsmonsters.character.Character;
import technofutur.heroesvsmonsters.character.faction.FactionType;
import technofutur.heroesvsmonsters.inventory.Inventory;
import technofutur.heroesvsmonsters.inventory.Loot;
import javafx.scene.image.Image;

public abstract class Hero extends Character {
    private Image image;
    Inventory inventory;

    public Hero() {
        super();
        this.inventory = new Inventory();
        this.factionType = FactionType.fromString("HERO");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addItemToInventory(Loot item, int amount) {
        this.inventory.addLoot(item, amount);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
