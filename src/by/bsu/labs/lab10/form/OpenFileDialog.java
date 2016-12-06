package by.bsu.labs.lab10.form;

import javax.swing.*;
import java.io.File;

/**
 * Created by amareelez on 5.12.16.
 */

public class OpenFileDialog extends JDialog {
    private File chosenFile = null;

    public OpenFileDialog() {
        JFileChooser dialog = new JFileChooser();

        dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        dialog.showOpenDialog(this);
        chosenFile = dialog.getSelectedFile();
        setVisible(true);
    }

    public File getFile() {
        return chosenFile;
    }
}

