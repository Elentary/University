package by.bsu.labs.lab11.action;

import by.bsu.labs.lab10.form.OpenFileDialog;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by amareelez on 10.12.16.
 */

public class Open {
    public static BufferedImage openImage() {
        OpenFileDialog dialog = new OpenFileDialog(new FileFilter() {
            @Override public boolean accept(File file) {
                return file.getName().endsWith(".jpeg");
            }

            @Override public String getDescription() {
                return "*.jpeg";
            }
        });
        try {
            if (dialog.getFile() == null)
                return null;
            return ImageIO.read(dialog.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
