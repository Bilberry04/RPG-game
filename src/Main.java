import core.Enemy;
import core.Equipment;
import core.Hero;
import data.EnemyLoader;
import core.HeroStorage;
import data.ItemLoader;
import logic.BattleManager;
import logic.HeroManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero hero = HeroManager.loadOrCreateHero();
        List<Enemy> enemies = EnemyLoader.loadEnemiesFromJson("src/json/enemies.json");
        List<Equipment> allItems = ItemLoader.loadItemsFromJson("src/json/items.json");

        if (enemies == null || enemies.isEmpty()) {
            System.out.println("No enemies found.");
            return;
        }

        Enemy enemy = enemies.get(0); // na razie testowo pierwszy
        BattleManager.fight(hero, enemy, allItems);

        HeroStorage.saveHero(hero);
    }
}