package technofutur.heroesvsmonsters.character.Race;

public enum HeroRace implements Race {
    HUMAN,
    ELF,
    DWARF;

    public static HeroRace fromString(String race) {
        return switch (race.toUpperCase()) {
            case "HUMAN" -> HUMAN;
            case "DWARF" -> DWARF;
            default -> throw new IllegalArgumentException("Unknown race: " + race);
        };
    }
}
