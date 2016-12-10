package by.bsu.labs.lab13.action;

import javax.swing.*;
import java.util.Arrays;

/**
 * Created by amareelez on 10.12.16.
 */

public class Transfer {
    public static void transfer(JList<String> from, JList<String> to) {
        DefaultListModel<String> modelFrom = (DefaultListModel<String>) from.getModel(), modelTo =
            (DefaultListModel<String>) to.getModel();
        int[] selectedIndices = from.getSelectedIndices();
        Arrays.sort(selectedIndices);
        for (int index : selectedIndices) {
            modelTo.addElement(modelFrom.elementAt(index));
        }
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            modelFrom.removeElementAt(selectedIndices[i]);
        }
        from.clearSelection();
        to.clearSelection();
        from.updateUI();
        to.updateUI();
    }
}
