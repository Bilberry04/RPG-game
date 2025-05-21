import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {
    private String name;
    private int level;
    private int experience;
    private int hp;
    private int agility;
    private int critChance;
    private int armor;
    private int strength;
    private int intelligence;
    private int dexterity;
    private Equipment equipment;

    public void attack(Enemy enemy) {

        int baseDamage = this.strength;
        if (equipment != null) {
            baseDamage += equipment.getBonusStrength();
        }
        int damage = baseDamage;


        Random rand = new Random();
        boolean isCritical = rand.nextInt(100) < this.critChance;
        if (isCritical) {
            damage *= 2;
            System.out.println(this.name + "lands a CRITICAL HIT!");
        }


        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage!");
        enemy.getDamage(damage);
    }


    public void getDamage(int damage) {

        int totalArmor = this.armor;
        if (equipment != null) {
            totalArmor += equipment.getBonusArmor();
        }

        int finalDamage = damage - totalArmor;
        if (finalDamage < 0) { finalDamage = 0; }

        this.hp -= finalDamage;
        if (this.hp < 0) { this.hp = 0; }

        System.out.println(this.name + " received " + finalDamage + " damage. HP left: " + this.hp);
    }



    public void experienceUp(int xp) {
        this.experience += xp;
        System.out.println(name + " gains " + xp + " XP. Total XP: " + this.experience);
        checkLevelUp();
    }

    public void checkLevelUp() {
        int requiredXP = this.level * 100;
        while (this.experience >= requiredXP) {
            this.experience -= requiredXP;
            levelUp();
            requiredXP = this.level * 100;
        }
    }

    public void levelUp() {
        this.level++;
        this.hp += 20;
        this.strength += 5;
        this.armor += 2;

        System.out.println(name + " leveled up to level " + this.level + "!");
        System.out.println("Stats increased HP: " + this.hp + "Strength: " + this.strength + "Armor: " + this.armor);
    }


    List<Equipment> inventory = new ArrayList<>();

    public void addToInventory(Equipment item) {
        inventory.add(item);
        System.out.println(this.name + " added " + item.getName() + " to Inventory!");
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println(this.name + "'s inventory is empty!");
            return;
        }

        System.out.println(this.name + "'s inventory:");
        for (int i=0; i<inventory.size(); i++) {
            Equipment item = inventory.get(i);
            System.out.println((i+1) + ". " + item.getName() + " (Lvl " + item.getItemLevel()
            + ", +STR: " + item.getBonusStrength()
                    + ", ARM: " + item.getBonusArmor() + ")");
        }
    }



    public void heal(int count) { }

    public String getName() { return name; }
    public void setName(String newName) { this.name = newName; }

    public int getLevel() { return level; }
    public void setLevel(int newLevel) { this.level = newLevel; }

    public int getExperience() { return experience; }
    public void setExperience(int newExperience) { this.experience = newExperience; }

    public int getHp() { return hp; }
    public void setHp(int newHp) { this.hp = newHp; }

    public int getAgility() { return agility; }
    public void setAgility(int newAgility) { this.agility = newAgility; }

    public int getCritChance() { return critChance; }
    public void setCritChance(int newcritChance) { this.critChance = newcritChance; }

    public int getArmor() { return armor; }
    public void setArmor(int newArmor) { this.armor = newArmor; }

    public int getStrength() { return strength; }
    public void setStrength(int newStrength) { this.strength = newStrength; }

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int newIntelligence) { this.intelligence = newIntelligence; }

    public int getDexterity() { return dexterity; }
    public void setDexterity(int newDexterity) { this.dexterity = newDexterity; }

    public Equipment getEquipment() { return equipment; }
    public void setEquipment(Equipment equipment) { this.equipment = equipment; }


}
