package technofutur.heroesvsmonsters.character.faction;

public enum FactionType {
    HERO,
    MONSTER,
    NEUTRAL;

    public static FactionType fromString(String faction) {
        return switch (faction.toUpperCase()) {
            case "HERO" -> HERO;
            case "MONSTER" -> MONSTER;
            default -> throw new IllegalArgumentException("Unknown faction: " + faction);
        };
    }
}
