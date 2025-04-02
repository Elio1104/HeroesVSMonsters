package technofutur.heroesvsmonsters.character.monsters;

import technofutur.heroesvsmonsters.character.Race.MonsterRace;
import technofutur.heroesvsmonsters.inventory.Loot;
import technofutur.heroesvsmonsters.utils.Dice;

public class Dragon extends Monster{
    public Dragon() {
        super(Loot.GOLD, Dice.roll(6));
        this.bonusEndurance = 1;
        this.bonusStrength = 0;
        this.race = MonsterRace.fromString("DRAGON");
    }
}
