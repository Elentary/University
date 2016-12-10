package by.bsu.labs.lab13.action;

import by.bsu.labs.lab13.form.MainDialog;

/**
 * Created by amareelez on 10.12.16.
 */

public class Run {
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
