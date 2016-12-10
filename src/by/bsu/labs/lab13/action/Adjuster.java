package by.bsu.labs.lab13.action;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by amareelez on 11.12.16.
 */

public class Adjuster {
    public static ImageIcon adjust(JComponent component, ImageIcon icon) {
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
            BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        graphics.drawImage(icon.getImage(), 0, 0, 10, 10, null);
        return new ImageIcon(image);
    }
}
