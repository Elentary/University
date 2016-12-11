package by.bsu.labs.lab12.applet.action.listener;

import by.bsu.labs.lab12.applet.StringViewer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by amareelez on 11.12.16.
 */

public class KeyStringEditListener extends KeyAdapter {

    @Override public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);

        if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            StringViewer stringViewer = (StringViewer) keyEvent.getComponent();

            StringBuilder stringBuilder = new StringBuilder(stringViewer.getData());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            stringViewer.setData(stringBuilder.toString());
            stringViewer.repaint();
        } else if (keyEvent.getKeyCode() >= KeyEvent.VK_A
            && keyEvent.getKeyCode() <= KeyEvent.VK_Z) {
            StringViewer stringViewer = (StringViewer) keyEvent.getComponent();
            stringViewer.setData(stringViewer.getData() + keyEvent.getKeyChar());
            stringViewer.repaint();
        }
    }
}

