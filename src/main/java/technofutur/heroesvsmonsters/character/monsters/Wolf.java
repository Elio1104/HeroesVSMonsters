package technofutur.heroesvsmonsters.character.monsters;

import technofutur.heroesvsmonsters.character.Race.MonsterRace;
import technofutur.heroesvsmonsters.inventory.Loot;
import technofutur.heroesvsmonsters.utils.Dice;

public class Wolf extends Monster {

    public Wolf() {
        super(Loot.LEATHER, Dice.roll(4));
        this.bonusEndurance = 0;
        this.bonusStrength = 0;
        this.race = MonsterRace.fromString("WOLF");
    }

    public Wolf(int posX, int posY) {
        super(Loot.LEATHER, Dice.roll(4));
        this.bonusEndurance = 0;
        this.bonusStrength = 0;
        this.race = MonsterRace.fromString("WOLF");
        this.posX = posX;
        this.posY = posY;
    }
}
