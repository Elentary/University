package by.bsu.labs.lab13.form;

import by.bsu.labs.lab13.action.Transfer;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JList<String> listLeft;
    private JList<String> listRight;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JRadioButton RadioButtonBSU;
    private JRadioButton RadioButtonBNTU;
    private JRadioButton RadioButtonBSUIR;
    private JLabel label;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);
        listLeft.setModel(new DefaultListModel<>());
        listRight.setModel(new DefaultListModel<>());
        fillLists();

        tabbedPane1.setTitleAt(0, "ListManipulation");
        tabbedPane1.setTitleAt(1, "RadioButtonsIcons");

        buttonRight.addActionListener(actionEvent -> Transfer.transfer(listRight, listLeft));
        buttonLeft.addActionListener(actionEvent -> Transfer.transfer(listLeft, listRight));
        RadioButtonBSU.addActionListener(actionEvent -> label.setText("BSU"));
        RadioButtonBNTU.addActionListener(actionEvent -> label.setText("BNTU"));
        RadioButtonBSUIR.addActionListener(actionEvent -> label.setText("BSUIR"));

        setIcons();
    }

    private void setIcons() {
        ImageIcon icon = new ImageIcon(new ImageIcon(
            this.getClass().getClassLoader().getResource("by/bsu/labs/lab13/icon/bird.png"))
            .getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        RadioButtonBSU.setPressedIcon(icon);
        RadioButtonBNTU.setPressedIcon(icon);
        RadioButtonBSUIR.setPressedIcon(icon);
        icon = new ImageIcon(new ImageIcon(this.getClass().getClassLoader()
            .getResource("by/bsu/labs/lab13/icon/gingerbread-man.png")).getImage()
            .getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        RadioButtonBSU.setSelectedIcon(icon);
        RadioButtonBNTU.setSelectedIcon(icon);
        RadioButtonBSUIR.setSelectedIcon(icon);
        icon = new ImageIcon(new ImageIcon(
            this.getClass().getClassLoader().getResource("by/bsu/labs/lab13/icon/wreath.png"))
            .getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        RadioButtonBSU.setRolloverIcon(icon);
        RadioButtonBNTU.setRolloverIcon(icon);
        RadioButtonBSUIR.setRolloverIcon(icon);
        icon = new ImageIcon(new ImageIcon(
            this.getClass().getClassLoader().getResource("by/bsu/labs/lab13/icon/snowman.png"))
            .getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        RadioButtonBSU.setIcon(icon);
        RadioButtonBNTU.setIcon(icon);
        RadioButtonBSUIR.setIcon(icon);
    }

    private void fillLists() {
        DefaultListModel<String> model = (DefaultListModel<String>) listLeft.getModel();
        for (int i = 0; i < 7; i++) {
            model.addElement(UUID.randomUUID().toString());
        }
        listLeft.updateUI();
        model = (DefaultListModel<String>) listRight.getModel();
        for (int i = 0; i < 11; i++) {
            model.addElement(UUID.randomUUID().toString());
        }
        listRight.updateUI();
    }
}
