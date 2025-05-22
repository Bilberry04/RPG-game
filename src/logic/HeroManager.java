package logic;

import core.Hero;
import data.HeroStorage;

import java.util.Scanner;

public class HeroManager {

    public static Hero loadOrCreateHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Load existing hero? (y/n)");
        String answer = scanner.nextLine();

        Hero hero;
        if (answer.equalsIgnoreCase("y")) {
            hero = HeroStorage.loadHero("hero.json");
            if (hero == null) {
                System.out.println("Creating new hero...");
                hero = createNewHero(scanner);
            }
        } else {
            hero = createNewHero(scanner);
        }

        return hero;
    }

    private static Hero createNewHero(Scanner scanner) {
        System.out.println("Enter hero's name: ");
        String name = scanner.nextLine();

        System.out.println("Choose class:");
        System.out.println("1. Shadow");
        System.out.println("2. Conjurer");
        System.out.println("3. StemHead");
        System.out.println("4. Alchemist");
        int choice = Integer.parseInt(scanner.nextLine());

        Hero hero = new Hero();
        hero.setName(name);
        hero.setLevel(1);
        hero.setExperience(0);

        switch (choice) {
            case 1: // Shadow
                hero.setHp(80);
                hero.setStrength(8);
                hero.setAgility(15);
                hero.setDexterity(12);
                hero.setArmor(2);
                hero.setCritChance(15);
                hero.setIntelligence(5);
                break;
            case 2: // Conjurer
                hero.setHp(70);
                hero.setStrength(4);
                hero.setAgility(8);
                hero.setDexterity(6);
                hero.setArmor(3);
                hero.setCritChance(10);
                hero.setIntelligence(18);
                break;
            case 3: // StemHead
                hero.setHp(140);
                hero.setStrength(15);
                hero.setAgility(4);
                hero.setDexterity(3);
                hero.setArmor(10);
                hero.setCritChance(5);
                hero.setIntelligence(2);
                break;
            case 4: // Alchemist
                hero.setHp(90);
                hero.setStrength(6);
                hero.setAgility(8);
                hero.setDexterity(7);
                hero.setArmor(5);
                hero.setCritChance(20);
                hero.setIntelligence(12);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Shadow.");
                hero.setHp(80);
                hero.setStrength(8);
                hero.setAgility(15);
                hero.setDexterity(12);
                hero.setArmor(2);
                hero.setCritChance(15);
                hero.setIntelligence(5);
                break;
        }
        return hero;
    }


}