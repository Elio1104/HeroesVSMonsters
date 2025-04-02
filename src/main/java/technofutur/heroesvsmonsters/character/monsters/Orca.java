package technofutur.heroesvsmonsters.character.monsters;

import technofutur.heroesvsmonsters.character.Race.MonsterRace;
import technofutur.heroesvsmonsters.inventory.Loot;
import technofutur.heroesvsmonsters.utils.Dice;

public class Orca extends Monster{
    public Orca() {
        super(Loot.GOLD, Dice.roll(6));
        this.bonusEndurance = 0;
        this.bonusStrength = 1;
        this.race = MonsterRace.fromString("ORCA");
    }
}
