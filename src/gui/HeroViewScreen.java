package gui;

import core.Hero;
import javax.swing.*;
import java.awt.*;
import gui.ShopScreen;

public class HeroViewScreen {

    public static void show(Hero hero) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
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

        for (JButton button : new JButton[]{fightButton, shopButton, exitButton}) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(button);
        }

        fightButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Here will fight"));
        shopButton.addActionListener(e -> ShopScreen.show(hero));
        exitButton.addActionListener(e -> frame.dispose());

        frame.add(panel);
        frame.setVisible(true);
    }

}
