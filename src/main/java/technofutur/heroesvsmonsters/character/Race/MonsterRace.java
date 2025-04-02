package technofutur.heroesvsmonsters.character.Race;

public enum MonsterRace implements Race {
    WOLF,
    ORCA,
    DRAGON;

    public static MonsterRace fromString(String race) {
        return switch (race.toUpperCase()) {
            case "WOLF" -> WOLF;
            case "ORCA" -> ORCA;
            case "DRAGON" -> DRAGON;
            default -> throw new IllegalArgumentException("Unknown race: " + race);
        };
    }
}
