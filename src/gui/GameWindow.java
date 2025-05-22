package gui;

import javax.swing.*;
import gui.CharacterCreationScreen;
import gui.MainMenuScreen;

import java.awt.*;

public class GameWindow {
    public static void main(String[] args) {

        JFrame frame = new JFrame("RPG Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel label = new JLabel("Welcome Hero!", SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton button = new JButton("Play");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Going next...");
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        button.addActionListener(e -> {
            frame.dispose();
            MainMenuScreen.show();
        });
    }
}
