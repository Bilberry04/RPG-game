public class Main {
    public static void main(String[] args)
    {
        Hero hero = new Hero();
        hero.setName("Archer");
        hero.setHp(100);
        hero.setStrength(10);
        hero.setArmor(5);
        hero.setCritChance(25);

        Equipment swordAndShield = new Equipment("Eq of Master", 100, 100);
        hero.setEquipment(swordAndShield);

        Enemy enemy = new Enemy("Goblin", 100, 10, 98);

        while (enemy.isAlive() && hero.getHp() > 0) {
            hero.attack(enemy);

            if (enemy.isAlive()) {
                enemy.attack(hero);
            }
        }

        if (hero.getHp() > 0) {
            System.out.println(hero.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }
    }
}