package technofutur.heroesvsmonsters.inventory;

import technofutur.heroesvsmonsters.utils.Color;

import java.util.HashMap;

public class Inventory {
    HashMap<Loot, Integer> lootList;

    public Inventory() {
        lootList = new HashMap<>();
        for (Loot loot : Loot.values()) {
            lootList.put(loot, 0);
        }
    }

    public void addLoot(Loot loot, int amount) {
        lootList.put(loot, lootList.get(loot) + amount);
    }

    public void removeLoot(Loot loot, int amount) {
        if (lootList.get(loot) >= amount) {
            lootList.put(loot, lootList.get(loot) - amount);
        } else {
            System.out.println(Color.red("Not enough " + loot.name() + " in inventory"));
        }
    }

    public int getLootAmount(Loot loot) {
        return lootList.get(loot);
    }

    public HashMap<Loot, Integer> getLootList() {
        return lootList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Color.blue("Inventory")).append("{\n");
        lootList.forEach((loot, amount) ->
                sb.append("  ").append(Color.green(loot.name())).append(": ").append(amount).append("\n")
        );
        sb.append("}");
        return sb.toString();
    }
}
