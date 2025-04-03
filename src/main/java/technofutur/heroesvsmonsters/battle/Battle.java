package technofutur.heroesvsmonsters.battle;

import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.character.monsters.Monster;
import technofutur.heroesvsmonsters.inventory.Loot;
import technofutur.heroesvsmonsters.utils.Color;

public class Battle {
    private final Hero hero;
    private final Monster monster;

    public Battle(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public void startBattle() {
        System.out.println("Battle started between " + hero.getName() + " and " + monster.getName());

        while (hero.isAlive() && monster.isAlive()) {
            hero.attack(monster);
            if (monster.isAlive()) {
                monster.attack(hero);
            }
        }

        if (hero.isAlive()) {
            System.out.println(hero.getName() + " wins!");
            transferLoot();
        } else {
            System.out.println(monster.getName() + " wins!");
        }
    }

    public Hero getHero() {
        return hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public void heroAttack() {
        hero.attack(monster);
    }

    public void monsterAttack() {
        monster.attack(hero);
    }

    public void transferLoot() {
        Loot loot = monster.getLootDrop().getLoot();
        int amount = monster.getLootDrop().getAmount();
        hero.addItemToInventory(loot, amount);
        System.out.println(Color.cyan(hero.getName() + " received " + amount + " " + loot.name()));
    }
}
