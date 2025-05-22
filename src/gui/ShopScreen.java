package gui;

import core.Equipment;
import core.Hero;
import data.ShopItemLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShopScreen {

    public static void show(Hero hero) {
        JFrame frame = new JFrame("Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        List<Equipment> items = ShopItemLoader.loadShopItems("src/json/shop_items.json");

        if (items == null || items.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Shop is empty");
            return;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        for (Equipment item : items) {
            ImageIcon rawIcon = new ImageIcon(item.getImagePath());
            Image scaledImage = rawIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            JButton button = new JButton(icon);
            button.setToolTipText(item.getName());
            button.setMargin(new Insets(2, 2, 2, 2));

            button.addActionListener(e -> {
                int price = item.getItemLevel() * 25;
                String message = item.getName() + "\n"
                        + "Level: " + item.getItemLevel() + "\n"
                        + "Strength: " + item.getBonusStrength() + "\n"
                        + "Armor: " + item.getBonusArmor() + "\n"
                        + "Price: " + price + " gold\n\n"
                        + "Do you want to buy this item?";

                int choice = JOptionPane.showConfirmDialog(frame, message, "Buy item", JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    if (hero.spendGold(price)) {
                        hero.addToInventory(item);
                        JOptionPane.showMessageDialog(frame, "You bought this item: " + item.getName());

                    } else {
                        JOptionPane.showMessageDialog(frame, "You don't have enough gold to buy item");
                    }
                }
            });

            panel.add(button);
        }

        JScrollPane scroll = new JScrollPane(panel);
        frame.add(scroll);
        frame.setVisible(true);

    }

}
