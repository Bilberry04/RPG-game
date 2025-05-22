package logic;

import core.Enemy;
import core.Equipment;
import core.Hero;

import java.util.List;
import java.util.Random;

public class BattleManager {

    public static void fight(Hero hero, Enemy enemy, List<Equipment> allItems) {
        System.out.println("A wild " + enemy.getName() + " appears!");

        while (enemy.isAlive() && hero.getHp() > 0) {
            hero.attack(enemy);

            if (enemy.isAlive()) {
                enemy.attack(hero);
            }
        }

        if (hero.getHp() > 0) {
            System.out.println(hero.getName() + " wins!");
            hero.experienceUp(enemy.getXpReward());
            dropReward(hero, allItems);
            hero.addGold(enemy.getXpReward());
            System.out.println("You received " + enemy.getGoldReward() + " gold! Total: " + hero.getGold());

                if (hero.getUpgradePoints() > 0) {
                CharacterUpgradeManager.spendUpgradePoints(hero);
                }

        } else {
            System.out.println(enemy.getName() + " has defeated you!");
            int xpLoss = (int)(enemy.getXpReward() * 0.1);
            System.out.println(hero.getName() + " still gains " + xpLoss + " XP from the fight.");
            hero.experienceUp(xpLoss);
        }
    }

    private static void dropReward(Hero hero, List<Equipment> allItems) {
        Random rand = new Random();

        if (rand.nextInt(100) < 50 && allItems != null && !allItems.isEmpty()) {
            int heroLevel = hero.getLevel();

            List<Equipment> matchingItems = allItems.stream()
                    .filter(item -> item.getItemLevel() >= heroLevel - 1 && item.getItemLevel() <= heroLevel + 1)
                    .toList();

            if (!matchingItems.isEmpty()) {
                Equipment droppedItem = matchingItems.get(rand.nextInt(matchingItems.size()));
                System.out.println("[REWARD] " + hero.getName() + " found: " + droppedItem.getName());
                hero.addToInventory(droppedItem);
                hero.showInventory();

            } else {
                System.out.println("No suitable items for your level.");
            }
        } else {
            System.out.println("No loot this time.");
        }
    }
}