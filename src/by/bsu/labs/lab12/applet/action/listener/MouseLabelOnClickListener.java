package by.bsu.labs.lab12.applet.action.listener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by amareelez on 12.12.16.
 */

public class MouseLabelOnClickListener extends MouseAdapter {
    private String pressed, released;
    private Color entered, exited;

    public MouseLabelOnClickListener(String pressed, String released, Color entered) {
        super();

        this.pressed = pressed;
        this.released = released;
        this.entered = entered;
        this.exited = entered;
    }

    @Override public void mousePressed(MouseEvent mouseEvent) {
        super.mousePressed(mouseEvent);

        ((Button) mouseEvent.getComponent()).setLabel(pressed);
        mouseEvent.getComponent().setBackground(entered);
    }

    @Override public void mouseReleased(MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);

        ((Button) mouseEvent.getComponent()).setLabel(released);
    }

    @Override public void mouseEntered(MouseEvent mouseEvent) {
        super.mouseEntered(mouseEvent);

        exited = mouseEvent.getComponent().getBackground();
        mouseEvent.getComponent().setBackground(entered);
    }

    @Override public void mouseExited(MouseEvent mouseEvent) {
        super.mouseExited(mouseEvent);

        mouseEvent.getComponent().setBackground(exited);
    }
}
