package technofutur.heroesvsmonsters.character.monsters;

import technofutur.heroesvsmonsters.character.Character;
import technofutur.heroesvsmonsters.character.faction.FactionType;
import technofutur.heroesvsmonsters.inventory.Loot;

public abstract class Monster extends Character {
    protected LootDrop lootDrop;

    public Monster(Loot loot, int amount) {
        this.factionType = FactionType.fromString("MONSTER");
        this.lootDrop = new LootDrop(loot, amount);
    }

    public LootDrop getLootDrop() {
        return lootDrop;
    }

    public static class LootDrop {
        private final Loot loot;
        private final int amount;

        public LootDrop(Loot loot, int amount) {
            this.loot = loot;
            this.amount = amount;
        }

        public Loot getLoot() {
            return loot;
        }

        public int getAmount() {
            return amount;
        }
    }
}
