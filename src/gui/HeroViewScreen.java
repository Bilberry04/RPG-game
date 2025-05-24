package gui;

import core.Equipment;
import core.Hero;
import javax.swing.*;
import java.awt.*;
import gui.ShopScreen;

public class HeroViewScreen {

    private static JLabel messageLabel;

    public static void show(JFrame frame, Hero hero) {

        Equipment starterSword = new Equipment("Starter Sword", 5, 1, 1);
        hero.addToInventory(starterSword);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("Hero stats: " + hero.getName(), SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(title);

        String[] stats = {
                "Level: " + hero.getLevel(),
                "Experience: " + hero.getExperience(),
                "HP: " + hero.getHp(),
                "Strength: " + hero.getStrength(),
                "Dexterity: " + hero.getDexterity(),
                "Agility: " + hero.getAgility(),
                "Armor: " + hero.getArmor(),
                "Intelligence: " + hero.getIntelligence(),
                "Critical Chance: " + hero.getCritChance() + "%",
                "Gold: " + hero.getGold(),
        };

        for (String stat : stats) {
            JLabel statLabel = new JLabel(stat);
            statLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 5)));
            panel.add(statLabel);
        }

        JButton fightButton = new JButton("⚔\uFE0F Fight");
        JButton shopButton = new JButton("\uD83D\uDED2 Shop");
        JButton exitButton = new JButton("❌ Exit");
        JButton inventoryButton = new JButton("🧳 Inventory");

        for (JButton button : new JButton[]{fightButton, shopButton, exitButton}) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(button);
        }

        messageLabel = new JLabel("Welcome, " + hero.getName() + "!");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setForeground(Color.BLUE);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(messageLabel);

        fightButton.addActionListener(e -> setMessage("You are not ready for battle yet!"));

        shopButton.addActionListener(e -> { ShopScreen.show(hero);
        setMessage("Welcome to the shop!");
                });

        exitButton.addActionListener(e -> {
            frame.dispose();
            setMessage("Goodbye!");
        });

        inventoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(inventoryButton);
        inventoryButton.addActionListener(e -> InventoryScreen.show(frame, hero));


        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel equipTitle = new JLabel("Equipment");
        equipTitle.setFont(new Font("Serif", Font.BOLD, 16));
        equipTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(equipTitle);

        String weapon = (hero.getWeapon() != null) ? hero.getWeapon().getName() : "none";
        String chestplate = (hero.getChestplate() != null) ? hero.getChestplate().getName() : "none";
        String boots = (hero.getBoots() != null) ? hero.getBoots().getName() : "none";
        String gloves = hero.getGloves() != null ? hero.getGloves().getName() : "none";
        String pants = hero.getPants() != null ? hero.getPants().getName() : "none";
        String medallion = hero.getMedallion() != null ? hero.getMedallion().getName() : "none";
        String potion = hero.getPotion() != null ? hero.getPotion().getName() : "none";

        panel.add(new JLabel("Weapon: " + weapon));
        panel.add(new JLabel("Chestplate: " + chestplate));
        panel.add(new JLabel("Boots: " + boots));
        panel.add(new JLabel("Gloves: " + gloves));
        panel.add(new JLabel("Pants: " + pants));
        panel.add(new JLabel("Medallion: " + medallion));
        panel.add(new JLabel("Potion: " + potion));

        //TESTOWE ----------------------------------------------------------------------------------

        JButton testEquip = new JButton("Equip Test Sword");
        testEquip.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(testEquip);

        testEquip.addActionListener(e -> {
            Equipment testSword = new Equipment("Test Sword", 10, 0, 1);
            hero.setWeapon(testSword);
            setMessage("Equip equiped!" + testSword.getName());

            frame.getContentPane().removeAll();
            HeroViewScreen.show(frame, hero);
        });

        JLabel background = FantasyBackGround.getBackGroundWithContent(panel, "images/background/fantasy_forest_blue_green.png", new Dimension(1280, 720));
        frame.setContentPane(background);
        frame.setVisible(true);
    }

    private static void setMessage(String message) {
        if (messageLabel != null) {
            messageLabel.setText(message);
        }
    }

}
