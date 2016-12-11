package by.bsu.labs.lab12.applet.action.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by amareelez on 12.12.16.
 */

public class KeyCtrlPressedListener extends KeyAdapter {

    @Override public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);

        if (keyEvent.getKeyCode() == KeyEvent.VK_CONTROL) {
            MouseMotionListener[] listeners = keyEvent.getComponent().getMouseMotionListeners();
            for (MouseMotionListener listener : listeners) {
                if (listener instanceof MouseDragDropListener) {
                    ((MouseDragDropListener) listener).setActive(true);
                }
            }
        }
    }

    @Override public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);

        if (keyEvent.getKeyCode() == KeyEvent.VK_CONTROL) {
            MouseMotionListener[] listeners = keyEvent.getComponent().getMouseMotionListeners();
            for (MouseMotionListener listener : listeners) {
                if (listener instanceof MouseDragDropListener) {
                    ((MouseDragDropListener) listener).setActive(false);
                }
            }
        }
    }
}
