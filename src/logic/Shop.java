package logic;

import core.Equipment;
import core.Hero;
import data.ShopItemLoader;

import java.util.List;
import java.util.Scanner;

public class Shop {



    public static void open(Hero hero) {

        List<Equipment> itemsForSale = ShopItemLoader.loadShopItems("src/shop_items.json");

        if (itemsForSale == null || itemsForSale.isEmpty()) {
            System.out.println("logic.Shop is empty");
            return;
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Shop! You have " + hero.getGold() + " gold.");

        for (int i=0; i<itemsForSale.size(); i++) {
            Equipment item = itemsForSale.get(i);
            int price = item.getItemLevel() * 25;

            System.out.println((i + 1) + ". " + item.getName()
            + "Lvl " + item.getItemLevel()
            + ", STR+" + item.getBonusStrength()
            + ", ARM+" + item.getBonusArmor()
            + ") - " + price + " gold");
        }

        System.out.println("Enter item number to buy or 0 to exit:");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= itemsForSale.size()) {
            Equipment selected = itemsForSale.get(choice - 1);
            int price = selected.getItemLevel() * 25;

            if (hero.spendGold(price)) {
                hero.addToInventory(selected);
                System.out.println("Purchased " + selected.getName() + "!");
            } else {
                System.out.println("You don't have enough money to buy this item!");
            }
        } else {
            System.out.println("Leaving shop...");
        }

    }

}
