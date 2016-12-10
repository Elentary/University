package by.bsu.labs.lab11.form;

import by.bsu.labs.lab11.action.Open;
import by.bsu.labs.lab11.action.Save;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOpen;
    private JButton buttonSave;
    private JButton buttonRed;
    private JButton buttonGreen;
    private JButton buttonBlue;
    private JScrollPane scrollPanel;
    private JPanel drawPanel;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);


        buttonRed.addActionListener(actionEvent -> ((DrawPanel) drawPanel).setColor(Color.RED));
        buttonGreen.addActionListener(actionEvent -> ((DrawPanel) drawPanel).setColor(Color.GREEN));
        buttonBlue.addActionListener(actionEvent -> ((DrawPanel) drawPanel).setColor(Color.BLUE));

        buttonSave.addActionListener(actionEvent -> {
            BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),
                BufferedImage.TYPE_INT_RGB);
            drawPanel.paintAll(image.createGraphics());
            Save.saveImage(image);
        });
        buttonOpen.addActionListener(actionEvent -> {
            BufferedImage image = Open.openImage();
            if (image == null)
                return;
            ((DrawPanel) drawPanel).loadImage(image);
            scrollPanel.updateUI();
        });
    }

    private void createUIComponents() {
        drawPanel = new DrawPanel();
    }
}
