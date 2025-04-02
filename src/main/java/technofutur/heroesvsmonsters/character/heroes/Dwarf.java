package technofutur.heroesvsmonsters.character.heroes;

import technofutur.heroesvsmonsters.character.Race.HeroRace;

public class Dwarf extends Hero {
    public Dwarf() {
        super();
        this.bonusEndurance = 2;
        this.bonusStrength = 0 ;
        this.race = HeroRace.fromString("DWARF");
    }
}
