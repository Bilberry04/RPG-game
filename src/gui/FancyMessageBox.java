package gui;

import javax.swing.*;
import java.awt.*;

public class FancyMessageBox {

    public static void show (String title, String message) {
        JDialog dialog = new JDialog();
        dialog.setTitle(title);
        dialog.setModal(true);
        dialog.setSize(350, 200);
        dialog.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(30, 30, 30));
        panel.setBorder(BorderFactory.createLineBorder(new Color(180, 140, 70), 4));

        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>" + message + "</div></html>", SwingConstants.CENTER);
        messageLabel.setForeground(new Color(230, 220, 180));
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton okButton = new JButton("Continue →");
        okButton.setFocusPainted(false);
        okButton.setBackground(new Color(60, 50, 30));
        okButton.setForeground(new Color(200, 180, 120));
        okButton.addActionListener(e -> dialog.dispose());

        panel.add(messageLabel, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        dialog.setContentPane(panel);
        dialog.setUndecorated(false);
        dialog.setVisible(true);
    }

}
