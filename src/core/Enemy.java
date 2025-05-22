package core;

import java.util.List;
import java.util.Random;

public class Enemy {
    private String name;
    private int hp;
    private int strength;
    private int critChance;
    private int xpReward;
    private final List<Equipment> possibleDrops;
    private int goldReward;

    public Enemy(String name, int hp, int strength, int critChance, int xpReward, List<Equipment> possibleDrops, int goldReward) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.critChance = critChance;
        this.xpReward = xpReward;
        this.possibleDrops = possibleDrops;
        this.goldReward = goldReward;
    }

    public void getDamage(int damage){
        hp -= damage;
        if(hp < 0) { hp = 0; }
            System.out.println(this.name + " received " + damage + " damage. HP left: " + hp + "\n") ;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public void attack(Hero hero) {
        Random rand = new Random();
        int damage = this.strength;
        int roll = rand.nextInt(100);

        boolean isCritical = roll < this.critChance;

        if(isCritical){
            damage *= 2;
            System.out.println(this.name + " lands a CRITICAL HIT!");
        }

        System.out.println(this.name + " attacks " + hero.getName() + " for " + damage + " damage!");
        hero.getDamage(damage);
    }

    public int getStrength(){ return strength; }

    public String getName(){ return name; }

    public int getHp(){ return hp; }

    public int getCritical(){ return critChance; }

    public int getXpReward(){ return xpReward; }

    public List<Equipment> getPossibleDrops(){ return possibleDrops; }

    public int getGoldReward(){ return goldReward; }


}
