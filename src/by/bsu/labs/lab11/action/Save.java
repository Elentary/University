package by.bsu.labs.lab11.action;

import by.bsu.labs.lab11.form.SaveFileDialog;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by amareelez on 8.12.16.
 */

public class Save {
    public static void saveImage(RenderedImage image) {
        SaveFileDialog dialog = new SaveFileDialog(new FileFilter() {
            @Override public boolean accept(File file) {
                return file.getName().endsWith(".jpeg");
            }

            @Override public String getDescription() {
                return "*.jpeg";
            }
        });
        try {
            if (dialog.getFile() == null)
                return;
            File file = new File((dialog.getFile().getAbsolutePath().endsWith(".jpeg") ?
                dialog.getFile().getAbsolutePath() :
                (dialog.getFile().getAbsolutePath() + ".jpeg")));
            ImageIO.write(image, "jpeg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
