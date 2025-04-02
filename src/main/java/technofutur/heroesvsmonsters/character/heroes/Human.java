package technofutur.heroesvsmonsters.character.heroes;

import technofutur.heroesvsmonsters.character.Race.HeroRace;

public class Human extends Hero{
    public Human() {
        super();
        this.bonusEndurance = 1;
        this.bonusStrength = 1;
        this.race = HeroRace.fromString("HUMAN");
    }
}
