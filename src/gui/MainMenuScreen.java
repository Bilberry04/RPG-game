package gui;

import core.Hero;
import data.HeroStorage;

import javax.swing.*;
import java.awt.*;

public class MainMenuScreen {

    public static void show() {

        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("RPG GAME - Main Menu", SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(title);

        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton exitButton = new JButton("Exit");


        for (JButton button : new JButton[]{newGameButton, loadGameButton, exitButton}) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(button);
        }

        newGameButton.addActionListener(e -> {
            frame.dispose();
            CharacterCreationScreen.show();
        });

        loadGameButton.addActionListener(e -> {
            Hero loadedHero = HeroStorage.loadHero("src/json/hero.json");
            if (loadedHero != null) {
                JOptionPane.showMessageDialog(frame, "Loaded hero: " + loadedHero.getName());
                HeroViewScreen.show(loadedHero);

            } else {
                JOptionPane.showMessageDialog(frame, "Failed to load hero");
            }
        });

        exitButton.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
