import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero hero = HeroManager.loadOrCreateHero();
        List<Enemy> enemies = EnemyLoader.loadEnemiesFromJson("src/enemies.json");
        List<Equipment> allItems = ItemLoader.loadItemsFromJson("src/items.json");

        if (enemies == null || enemies.isEmpty()) {
            System.out.println("No enemies found.");
            return;
        }

        Enemy enemy = enemies.get(0); // na razie testowo pierwszy
        BattleManager.fight(hero, enemy, allItems);

        HeroStorage.saveHero(hero, "hero.json");
    }
}