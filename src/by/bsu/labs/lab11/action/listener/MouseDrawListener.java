package by.bsu.labs.lab11.action.listener;

import by.bsu.labs.lab11.form.DrawPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by amareelez on 7.12.16.
 */

public class MouseDrawListener extends MouseAdapter {

    @Override public void mousePressed(MouseEvent mouseEvent) {
        ((DrawPanel) mouseEvent.getComponent()).newLine();
    }

    @Override public void mouseReleased(MouseEvent mouseEvent) {

    }
}
