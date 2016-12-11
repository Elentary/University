package by.bsu.labs.lab12.applet;

import by.bsu.labs.lab12.applet.action.listener.MouseLabelOnClickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by amareelez on 12.12.16.
 */

public class ButtonClicker extends JApplet {

    @Override public void init() {
        super.init();

        setBackground(Color.LIGHT_GRAY);

        try {
            int rows, cols;
            String parameter = getParameter("rows");
            if (parameter == null)
                rows = 3;
            else
                rows = Integer.parseInt(parameter);

            parameter = getParameter("cols");
            if (parameter == null)
                cols = 3;
            else
                cols = Integer.parseInt(parameter);

            setLayout(new GridLayout(rows, cols));
            MouseListener listener =
                new MouseLabelOnClickListener("Clicked!", "Click me!", Color.ORANGE);
            for (int i = 0; i < rows * cols; i++) {
                Button button = new Button("Click me!");
                button.addMouseListener(listener);
                add(button);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Parameters should be numbers | " + e.getMessage());
        }
    }

    @Override public void start() {
        super.start();

        setFocusable(true);
    }
}
