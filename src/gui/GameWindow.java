package gui;

import javax.swing.*;
import gui.CharacterCreationScreen;
import gui.MainMenuScreen;

import java.awt.*;

public class GameWindow {
    public static void main(String[] args) {

        Dimension screenSize = new Dimension(1280, 720);

        JFrame frame = new JFrame("RPG Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Welcome Hero!", SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton button = new JButton("Play");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(button);

        JLabel background = FantasyBackGround.getBackGroundWithContent(panel, "images/background/fantasy_forest_blue_green.png", new Dimension(1280, 720));
        frame.setContentPane(background);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        button.addActionListener(e -> {
            MainMenuScreen.show(frame);
        });
    }
}
