package gui;

import core.Hero;
import javax.swing.*;
import java.awt.*;

public class CharacterCreationScreen {

    public static void show() {
        JFrame frame = new JFrame("Choose your class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Choose class of your hero:", SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        JButton shadowButton = new JButton("\uD83D\uDDE1\uFE0F Shadow");
        JButton conjurerButton = new JButton("\uD83D\uDD2E Conjurer");
        JButton stemheadButton = new JButton("\uD83D\uDEE1\uFE0F StemHead");
        JButton alchemistButton = new JButton("☠\uFE0F Alchemist");

        for (JButton button : new JButton[]{shadowButton, conjurerButton, stemheadButton, alchemistButton}) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(button);
        }

        shadowButton.addActionListener(e -> createHero("Shadow", 80, 8, 15, 12, 2, 15, 5));
        conjurerButton.addActionListener(e -> createHero("Conjurer", 70, 4, 8, 6, 3, 10, 18));
        stemheadButton.addActionListener(e -> createHero("StemHead", 140, 15, 4, 3, 10, 5, 2));
        alchemistButton.addActionListener(e -> createHero("Alchemist", 90, 6, 8, 7, 5, 20, 12));

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private static void createHero(String name, int hp, int strength, int agility, int dexterity, int armor, int critChance, int intelligence) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(hp);
        hero.setStrength(strength);
        hero.setAgility(agility);
        hero.setDexterity(dexterity);
        hero.setArmor(armor);
        hero.setCritChance(critChance);
        hero.setIntelligence(intelligence);
        hero.setLevel(1);
        hero.setExperience(0);

        JOptionPane.showMessageDialog(null, "Created hero with class: " + name + "\n" +
                "HP: " + hp + ", STR: " + strength + ", AGI: " + agility + "\n" +
                "DEX: " + dexterity + ", ARM: " + armor + ", CRIT: " + critChance + ", INT: " + intelligence);
    }
}
