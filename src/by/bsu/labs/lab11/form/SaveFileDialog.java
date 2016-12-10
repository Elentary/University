package by.bsu.labs.lab11.form;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by amareelez on 8.12.16.
 */

public class SaveFileDialog extends JDialog {
    private File chosenFile = null;

    public SaveFileDialog() {
        JFileChooser dialog = new JFileChooser();

        dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        dialog.setDialogType(JFileChooser.SAVE_DIALOG);
        dialog.showSaveDialog(this);
        chosenFile = dialog.getSelectedFile();
    }

    public SaveFileDialog(FileFilter filter) {
        JFileChooser dialog = new JFileChooser();

        dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        dialog.setAcceptAllFileFilterUsed(false);
        dialog.addChoosableFileFilter(filter);
        dialog.setDialogType(JFileChooser.SAVE_DIALOG);
        dialog.showSaveDialog(this);
        chosenFile = dialog.getSelectedFile();
    }

    public File getFile() {
        return chosenFile;
    }
}
