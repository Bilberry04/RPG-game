package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FantasyBackGround {

    public static JLabel getBackGroundWithContent(JComponent content, String imagePath, Dimension size) {

        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            Image scaledImage = originalImage.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel backgroundLabel = new JLabel(scaledIcon);
            backgroundLabel.setLayout(new BorderLayout());

            content.setOpaque(false);
            backgroundLabel.add(content, BorderLayout.CENTER);

            return backgroundLabel;

        } catch (IOException e) {
            e.printStackTrace();
            return new JLabel("Background failed to load.");
        }
    }
}
