package by.bsu.labs.lab10.form;

import by.bsu.labs.lab10.entity.Toy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class CollectionDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonSearch;
    private JTable table1;
    private JComboBox<Integer> comboBoxTo;
    private JComboBox<Integer> comboBoxFrom;
    private JSpinner spinnerMaxCost;
    private JButton buttonExit;
    private JButton buttonOpenFile;
    private File file;

    CollectionDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOpenFile);

        buttonSearch.addActionListener(e -> onSearch());
        buttonExit.addActionListener(e -> onCancel());
        buttonOpenFile.addActionListener(e -> onOpen());

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setColumnCount(4);
        model.setColumnIdentifiers(new Object[] {"Name", "Price", "From", "To"});
    }

    public static void main(String[] args) {
        CollectionDialog dialog = new CollectionDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOpen() {
        OpenFileDialog dialog = new OpenFileDialog();

        file = dialog.getFile();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            TreeSet<String> ages = new TreeSet<>();

            while (line != null) {
                String[] temp = line.split(" ");
                ages.add(temp[2]);
                ages.add(temp[3]);
                line = bufferedReader.readLine();
            }

            for (String s : ages) {
                comboBoxFrom.addItem(Integer.parseInt(s));
                comboBoxTo.addItem(Integer.parseInt(s));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void onCancel() {
        dispose();
    }

    private void onSearch() {
        Integer lowBorder = (Integer) comboBoxFrom.getSelectedItem(), highBorder =
            (Integer) comboBoxTo.getSelectedItem();
        if (lowBorder > highBorder) {
            JOptionPane.showMessageDialog(null, "Low border is bigger than high border");
            return;
        }
        Double maxCost = 1. * (Integer) spinnerMaxCost.getValue();
        if (maxCost < 0) {
            JOptionPane.showMessageDialog(null, "Maximum cost is negative");
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ArrayList<Toy> toys = new ArrayList<>();
            String line = bufferedReader.readLine();
            Double currSum = 0.;

            while (line != null) {
                Toy temp = new Toy(line);
                if (lowBorder <= temp.getLowBorder() && highBorder >= temp.getHighBorder()
                    && currSum + temp.getPrice() <= maxCost) {
                    toys.add(temp);
                    currSum += temp.getPrice();
                }
                line = bufferedReader.readLine();
            }

            toys.sort(Comparator.comparing(Toy::getName));

            DefaultTableModel model = (DefaultTableModel) table1.getModel();

            while (model.getRowCount() != 0)
                model.removeRow(0);
            table1.updateUI();

            for (Toy toy : toys) {
                model.addRow(new Object[] {toy.getName(), toy.getPrice(), toy.getLowBorder(),
                    toy.getHighBorder()});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
