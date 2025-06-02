package gui;

import core.Equipment;
import core.Hero;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryScreen {

    public static void show(JFrame frame, Hero hero) {
        JDialog dialog = new JDialog(frame, "Inventory", true);
        dialog.setSize(600, 500);
        dialog.setLocationRelativeTo(frame);

        List<Equipment> items = hero.getInventory();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(30, 30, 30));

        JLabel title = new JLabel("Inventory", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(title, BorderLayout.NORTH);

        DefaultListModel<Equipment> model = new DefaultListModel<>();
        for (Equipment item : items) {
            model.addElement(item);
        }

        JList<Equipment> itemList = new JList<>(model);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setBackground(new Color(50, 50, 50));
        itemList.setForeground(Color.WHITE);
        itemList.setFont(new Font("Monospaced", Font.PLAIN, 14));
        itemList.setSelectionBackground(new Color(70, 130, 180));
        JScrollPane scrollPane = new JScrollPane(itemList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        String[] slots = { "Weapon", "Chestplate", "Boots", "Gloves", "Pants", "Potion", "Medallion" };
        JComboBox<String> slotSelector = new JComboBox<>(slots);

        JButton equipButton = new JButton("Equip");
        equipButton.setFont(new Font("Serif", Font.BOLD, 16));
        equipButton.setForeground(Color.WHITE);
        equipButton.setBackground(new Color(70, 130, 180));

        equipButton.addActionListener(e -> {
            Equipment selected = itemList.getSelectedValue();
            String selectedSlot = (String) slotSelector.getSelectedItem();

            if (selected != null && selectedSlot != null) {
                switch (selectedSlot) {
                    case "Weapon" : hero.setWeapon(selected); break;
                    case "Chestplate" : hero.setArmor(selected); break;
                    case "Boots" : hero.setBoots(selected); break;
                    case "Gloves" : hero.setGloves(selected); break;
                    case "Pants" : hero.setPants(selected); break;
                    case "Potion" : hero.setPotion(selected); break;
                    case "Medallion" : hero.setMedallion(selected); break;
                    default: JOptionPane.showMessageDialog(dialog, "Unknown item type: " + selectedSlot); return;
                }
                JOptionPane.showMessageDialog(dialog, "Equipped " + selected.getName() + " as" + selectedSlot + "!");
                dialog.dispose();
                frame.getContentPane().removeAll();
                HeroViewScreen.show(frame, hero);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.add(equipButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setContentPane(mainPanel);
        dialog.setVisible(true);

    }

}
