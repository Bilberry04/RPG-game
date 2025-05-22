import java.util.Scanner;

public class CharacterUpgradeManager {

    public static void spendUpgradePoints(Hero hero) {
        Scanner scanner = new Scanner(System.in);

        while (hero.getUpgradePoints() > 0) {
            System.out.println("You have " + hero.getUpgradePoints() + " upgrade points");
            System.out.println("Choose stat to improve:");
            System.out.println("1. +5 HP");
            System.out.println("2. +1 Strength");
            System.out.println("3. +1 Intelligence");
            System.out.println("4. +1 Dexterity");
            System.out.println("5. +1 Agility");
            System.out.println("6. +1 Crit Chance");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> hero.setHp(hero.getHp()+5);
                case "2" -> hero.setStrength(hero.getStrength()+1);
                case "3" -> hero.setIntelligence(hero.getIntelligence()+1);
                case "4" -> hero.setDexterity(hero.getDexterity()+1);
                case "5" -> hero.setAgility(hero.getAgility()+1);
                case "6" -> hero.setCritChance(hero.getCritChance()+1);
                default -> {
                    System.out.println("Invalid choice");
                    continue;
                }
            }

            hero.spendUpgradePoints();
            System.out.println("Stat upgraded!\n");
        }
    }

}
