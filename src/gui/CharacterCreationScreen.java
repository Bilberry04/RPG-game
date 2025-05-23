package gui;

import core.Hero;
import javax.swing.*;
import java.awt.*;

public class CharacterCreationScreen {

    public static void show(JFrame frame) {

        Dimension screenSize = new Dimension(1280, 720);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Choose class of your hero:", SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label);

        JButton shadowButton = new JButton("\uD83D\uDDE1\uFE0F Shadow");
        JButton conjurerButton = new JButton("\uD83D\uDD2E Conjurer");
        JButton stemheadButton = new JButton("\uD83D\uDEE1\uFE0F StemHead");
        JButton alchemistButton = new JButton("☠\uFE0F Alchemist");

        for (JButton button : new JButton[]{shadowButton, conjurerButton, stemheadButton, alchemistButton}) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(button);
        }

        shadowButton.addActionListener(e -> createHero(frame, "Shadow", 80, 8, 15, 12, 2, 15, 5));
        conjurerButton.addActionListener(e -> createHero(frame, "Conjurer", 70, 4, 8, 6, 3, 10, 18));
        stemheadButton.addActionListener(e -> createHero(frame, "StemHead", 140, 15, 4, 3, 10, 5, 2));
        alchemistButton.addActionListener(e -> createHero(frame, "Alchemist", 90, 6, 8, 7, 5, 20, 12));

        JLabel background = FantasyBackGround.getBackGroundWithContent(panel, "images/background/fantasy_forest_blue_green.png", screenSize);
        frame.setContentPane(background);
        frame.revalidate();
        frame.repaint();
    }

    private static void createHero(JFrame frame, String name, int hp, int strength, int agility, int dexterity, int armor, int critChance, int intelligence) {
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

        FancyMessageBox.show("Hero Created",
                "Created hero with class: " + name + "<br><br>" +
                        "HP: " + hp + ", STR: " + strength + ", AGI: " + agility + "<br>" +
                        "DEX: " + dexterity + ", ARM: " + armor + ", CRIT: " + critChance + ", INT: " + intelligence
        );

        HeroViewScreen.show(frame, hero);
    }
}
