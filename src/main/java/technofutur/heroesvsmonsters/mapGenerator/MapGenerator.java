package technofutur.heroesvsmonsters.mapGenerator;

import technofutur.heroesvsmonsters.battle.Battle;
import technofutur.heroesvsmonsters.character.heroes.Hero;
import technofutur.heroesvsmonsters.character.monsters.Monster;
import technofutur.heroesvsmonsters.menu.MenuController;
import technofutur.heroesvsmonsters.utils.RandomMonster;

public class MapGenerator {
    private final int WIDTH = 15;
    private Hero player;
    private final Monster[][] grid;
    private Battle battle;

    public MapGenerator() {
        this.grid = new Monster[WIDTH][WIDTH];
        generateMap();
        putEnemies();
    }

    public MapGenerator(Hero player) {
        this.grid = new Monster[WIDTH][WIDTH];
        this.player = player;
        generateMap();
        putEnemies();
    }

    private void generateMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = null;
            }
        }
    }

    private void putEnemies() {
        for (int i = 0; i < 15; i++) {
            putEnemy();
        }
    }

    private void putEnemy() {
        int x;
        int y;
        do {
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * WIDTH);
        } while (!cellValid(x, y));

        grid[x][y] = RandomMonster.getRandomMonster(x, y);
    }

    private boolean cellValid(int x, int y) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= WIDTH) {
            return false;
        } else if (x == 7 && y == 7) {
            return false;
        } else if (grid[x][y] != null) {
            return false;
        } else {
            return !isEnemyNearby(x, y);
        }
    }

    private boolean isEnemyNearby(int x, int y) {
        int radius = 2;
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < WIDTH && (grid[newX][newY] != null || (newX == 7 && newY == 7))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEnemyNearby() {
        int playerX = player.getPosX();
        int playerY = player.getPosY();
        System.out.println("x : " + playerX + " y : " + playerY);
        int radius = 1; // Vérifier les cases adjacentes

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i == 0 && j == 0) continue;
                if (Math.abs(i) + Math.abs(j) > radius) continue;// Ignorer la position du joueur
                int newX = playerY + i;
                int newY = playerX + j;
                if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < WIDTH && grid[newX][newY] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void placePlayer(Hero player) {
        this.player = player;
        player.setPosX(8);
        player.setPosY(8);
    }

    public Monster[][] getGrid() {
        return grid;
    }

    public void displayMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 8 && j == 8 && player != null) {
                    System.out.print("P ");
                } else if (grid[i][j] != null) {
                    System.out.print(grid[i][j].getClass().getSimpleName().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public Hero getPlayer() {
        return player;
    }

    public void setPlayer(Hero player) {
        this.player = player;
    }

    public void movePlayerUp() {
        if (player.getPosY() > 0) {
            player.setPosY(player.getPosY() - 1);
        }
    }

    public void movePlayerDown() {
        if (player.getPosY() < WIDTH - 1) {
            player.setPosY(player.getPosY() + 1);
        }
    }

    public void movePlayerLeft() {
        if (player.getPosX() > 0) {
            player.setPosX(player.getPosX() - 1);
        }
    }

    public void movePlayerRight() {
        if (player.getPosX() < WIDTH - 1) {
            player.setPosX(player.getPosX() + 1);
        }
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public void startBattle() {
        if (isEnemyNearby()) {
            battle = new Battle(player, getEnemyNearby());
            MenuController.rightMenuObj.setMonster(battle.getMonster());
            MenuController.rightMenuObj.updateStats();
        }
    }

    public void endBattle() {
        battle.restHero();
        grid[battle.getMonster().getPosX()][battle.getMonster().getPosY()] = null;
        battle = null;
        MenuController.rightMenuObj.setMonster(null);
        MenuController.rightMenuObj.clearStats();
    }

    private Monster getEnemyNearby() {
        int playerX = player.getPosX();
        int playerY = player.getPosY();
        System.out.println("x : " + playerX + " y : " + playerY);
        int radius = 1;

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i == 0 && j == 0) continue;
                if (Math.abs(i) + Math.abs(j) > radius) continue;
                int newX = playerY + i;
                int newY = playerX + j;
                if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < WIDTH && grid[newX][newY] != null) {
                    return grid[newX][newY];
                }
            }
        }
        return null;
    }
}