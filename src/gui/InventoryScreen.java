package gui;

import core.Equipment;
import core.Hero;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryScreen {

    public static void show(JFrame frame, Hero hero) {
        JDialog dialog = new JDialog(frame, "Inventory", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(frame);

        List<Equipment> items = hero.getInventory();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        DefaultListModel<Equipment> model = new DefaultListModel<>();

        System.out.println("Inventory size: " + hero.getInventory().size());

        for (Equipment item : items) {
            model.addElement(item);
        }

        JList<Equipment> itemList = new JList<>(model);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(itemList), BorderLayout.CENTER);

        JButton equipButton = new JButton("Equip as weapon");

        equipButton.addActionListener(e -> {
            Equipment selected = itemList.getSelectedValue();
            System.out.println("Selected: " + selected);

            if (selected != null) {
                hero.setWeapon(selected);
                hero.getInventory().remove(selected);
                JOptionPane.showMessageDialog(dialog, "Equipped " + selected.getName() + " as Weapon!");
                dialog.dispose();

                frame.getContentPane().removeAll();
                HeroViewScreen.show(frame, hero);
            }

        });

        panel.add(equipButton, BorderLayout.SOUTH);

        dialog.setContentPane(panel);
        dialog.setVisible(true);

    }

}
