package technofutur.heroesvsmonsters.character.faction;

public interface Faction {

    FactionType getFactionType();

    default boolean isHero() {
        return getFactionType() == FactionType.HERO;
    }

    default boolean isMonster() {
        return getFactionType() == FactionType.MONSTER;
    }
}
