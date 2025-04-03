package technofutur.heroesvsmonsters.character;

import technofutur.heroesvsmonsters.character.Race.Race;
import technofutur.heroesvsmonsters.character.faction.Faction;
import technofutur.heroesvsmonsters.character.faction.FactionType;
import technofutur.heroesvsmonsters.utils.Dice;
import technofutur.heroesvsmonsters.utils.Modifier;
import technofutur.heroesvsmonsters.utils.Color;

public abstract class Character implements Faction, Race {
    protected String name;

    protected int health;
    protected int current_health;

    protected int strength;
    protected int bonusStrength = 0;

    protected int endurance;
    protected int bonusEndurance = 0;

    protected FactionType factionType;
    protected boolean isAlive;
    protected Race race;

    public Character() {
        this.name = getClass().getSimpleName();
        this.strength = Dice.bestOf(6, 3, 4);
        this.endurance = Dice.bestOf(6, 3, 4);
        this.health = this.endurance + Modifier.getModifier(this.endurance);
        this.current_health = this.health;
        this.isAlive = true;
    }

    public void attack(Character character) {
        System.out.println(Color.yellow(character.getName() + " is attacked by " + this.name));
        character.receive(Dice.roll(4) + Modifier.getModifier(this.strength + this.bonusStrength));
    }

    public void receive(int dmg) {
        if (dmg < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        System.out.println(Color.red(this.name + " receives " + dmg + " damage"));
        this.current_health -= dmg;
        if (this.current_health <= 0) {
            this.current_health = 0;
            this.isAlive = false;
            System.out.println(name + " is dead");
        }
    }

    public void rest() {
        this.current_health = this.health;
    }

    @Override
    public FactionType getFactionType() {
        return factionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrentHealth() {
        return current_health;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public boolean isAlive() {
        return isAlive;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Race getRace() {
        return race;
    }


    @Override
    public String toString() {
        return String.format(
                "%sCharacter: %s%s {\n" +
                        "  %sHealth: %s%d/%d\n" +
                        "  %sStrength: %s%d + %d\n" +
                        "  %sEndurance: %s%d + %d\n" +
                        "  %sFaction Type: %s%s\n" +
                        "  %sIs Alive: %s%b\n" +
                        "  %sRace: %s%s\n" +
                        "%s}",
                Color.BLUE, Color.CYAN, name,
                Color.GREEN, Color.RESET, current_health, health,
                Color.GREEN, Color.RESET, strength, bonusStrength,
                Color.GREEN, Color.RESET, endurance, bonusEndurance,
                Color.GREEN, Color.RESET, factionType,
                Color.GREEN, Color.RESET, isAlive,
                Color.GREEN, Color.RESET, race,
                Color.RESET
        );
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setFactionType(FactionType factionType) {
        this.factionType = factionType;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getBonusEndurance() {
        return bonusEndurance;
    }

    public void setBonusEndurance(int bonusEndurance) {
        this.bonusEndurance = bonusEndurance;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public void setBonusStrength(int bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCurrent_health() {
        return current_health;
    }

    public void setCurrent_health(int current_health) {
        this.current_health = current_health;
    }
}
