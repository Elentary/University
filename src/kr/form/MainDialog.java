package kr.form;

import kr.action.ComparatorCustom;
import kr.action.OpenFile;
import kr.entity.ForestTree;
import kr.entity.FruitTree;
import kr.entity.Tree;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOpen;
    private JTable table1;

    private JTextField textFieldName;
    private JSpinner spinnerAge;
    private JComboBox comboBoxClass;
    private JComboBox comboBoxType;
    private JSpinner spinnerDays;
    private JTextField textFieldMass;
    private JTextField textFieldLogAmount;

    private JButton buttonCount;
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonEdit;
    private JButton buttonFinishEdit;
    private JButton buttonOK;
    private ArrayList<Tree> trees = new ArrayList<>();
    private int Index, deleteIndex;
    private boolean canDelete = false;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);

        buttonOpen.addActionListener(onOpen());
        buttonCount.addActionListener(onCount());
        buttonAdd.addActionListener(onAdd());
        buttonDelete.addActionListener(onDelete());
        buttonEdit.addActionListener(onEdit());
        buttonFinishEdit.addActionListener(onFinishEdit());
    }

    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private ActionListener onFinishEdit() {
        return actionEvent -> {
            canDelete = true;
            buttonDelete.doClick();
            Index = -1;
            buttonAdd.doClick();
            buttonFinishEdit.setEnabled(false);
            clearComponents();
            table1.setEnabled(true);
        };
    }

    private void clearComponents() {
        textFieldName.setText(" ");
        textFieldMass.setText(" ");
        textFieldLogAmount.setText(" ");
        spinnerDays.setValue(0);
        spinnerAge.setValue(0);
        comboBoxClass.setSelectedIndex(0);
        comboBoxType.setSelectedIndex(0);
    }

    private ActionListener onEdit() {
        return actionEvent -> {
            try {
                if (table1.getSelectedRows() != null) {
                    if (table1.getSelectedRows().length > 1) {
                        throw new Exception("Two or more trees selected. Choose one");
                    }
                    int index = table1.getSelectedRows()[0];
                    Index = index;
                    clearComponents();
                    textFieldName.setText(trees.get(index).getName());
                    spinnerAge.setValue(trees.get(index).getAge());
                    comboBoxClass.setSelectedIndex((trees.get(index) instanceof FruitTree) ? 0 : 1);
                    comboBoxType.setSelectedIndex(
                        (trees.get(index).getType() == kr.entity.Type.Pine) ? 0 : 1);
                    if (trees.get(index) instanceof FruitTree) {
                        spinnerDays.setValue(((FruitTree) trees.get(index)).getStorageDays());
                        textFieldMass.setText(
                            String.valueOf(((FruitTree) trees.get(index)).getStorageDays()));
                    } else if (trees.get(index) instanceof ForestTree) {
                        textFieldLogAmount.setText(
                            String.valueOf(((ForestTree) trees.get(index)).getAmountOfLog()));
                    }
                    buttonFinishEdit.setEnabled(true);
                    table1.setEnabled(false);
                } else
                    throw new Exception("Nothing is chosen to edit");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        };
    }

    private ActionListener onDelete() {
        return actionEvent -> {
            if (!canDelete) {
                canDelete = true;
                deleteIndex = (table1.getSelectedRows() != null ? table1.getSelectedRows()[0] : -1);
                return;
            }
            canDelete = false;
            if (table1.getSelectedRows() != null || Index != -1) {
                if (deleteIndex != table1.getSelectedRows()[0]) {
                    deleteIndex = -1;
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) table1.getModel();

                int[] rows = table1.getSelectedRows();
                if (Index != -1) {
                    rows = new int[] {Index};
                }
                Arrays.sort(rows);
                for (int i = rows.length - 1; i >= 0; i--) {
                    model.removeRow(rows[i]);
                    trees.remove(rows[i]);
                }
                deleteIndex = -1;
                showTable();
            }

        };
    }

    private ActionListener onAdd() {
        return actionEvent -> {
            try {
                Tree tree;
                if (comboBoxClass.getSelectedIndex() == 0) {
                    tree = new FruitTree();
                    tree.setName(textFieldName.getText());
                    tree.setAge((Integer) spinnerAge.getValue());
                    tree.setType((comboBoxType.getSelectedIndex() == 0) ?
                        (kr.entity.Type.Pine) :
                        (kr.entity.Type.Leaf));
                    ((FruitTree) tree).setMass(Double.parseDouble(textFieldMass.getText()));
                    ((FruitTree) tree).setStorageDays((Integer) spinnerDays.getValue());
                    trees.add(tree);
                } else if (comboBoxClass.getSelectedIndex() == 1) {
                    tree = new ForestTree();
                    tree.setName(textFieldName.getText());
                    tree.setAge((Integer) spinnerAge.getValue());
                    tree.setType((comboBoxType.getSelectedIndex() == 0) ?
                        (kr.entity.Type.Pine) :
                        (kr.entity.Type.Leaf));
                    ((ForestTree) tree)
                        .setAmountOfLog(Double.parseDouble(textFieldLogAmount.getText()));
                    trees.add(tree);
                }
                trees.sort(new ComparatorCustom());
                showTable();
                clearComponents();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " found");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insufficient data detected");
            }
        };
    }

    private ActionListener onCount() {
        return actionEvent -> {
            int count = 0;
            for (Tree tree : trees) {
                if (comboBoxType.getSelectedIndex() == 0 && tree.getType() == kr.entity.Type.Pine) {
                    count++;
                } else if (comboBoxType.getSelectedIndex() == 1
                    && tree.getType() == kr.entity.Type.Leaf) {
                    count++;
                }
            }
            JOptionPane.showMessageDialog(null, count + String
                .format(" matching %s found", comboBoxType.getSelectedItem().toString()));
        };
    }

    private ActionListener onOpen() {
        return actionEvent -> {
            ArrayList<Tree> temp = OpenFile.readTrees();

            if (temp == null) {
                return;
            }

            trees = temp;
            trees.sort(new ComparatorCustom());
            showTable();
        };
    }

    private void showTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setColumnCount(6);
        model.setColumnIdentifiers(
            new Object[] {"Name", "Age", "Type", "LogAmount", "MassGathered", "StorageDays"});
        while (model.getRowCount() != 0)
            model.removeRow(0);
        for (Tree tree : trees) {
            if (tree instanceof ForestTree)
                model.addRow(new Object[] {tree.getName(), tree.getAge(), tree.getType(),
                    ((ForestTree) tree).getAmountOfLog(), "", ""});
            else if (tree instanceof FruitTree)
                model.addRow(new Object[] {tree.getName(), tree.getAge(), tree.getType(), "",
                    ((FruitTree) tree).getMass(), ((FruitTree) tree).getStorageDays()});
        }
        table1.updateUI();
    }

    @Override public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getButtonOpen() {
        return buttonOpen;
    }

    public JTable getTable1() {
        return table1;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JSpinner getSpinnerAge() {
        return spinnerAge;
    }

    public JComboBox getComboBoxClass() {
        return comboBoxClass;
    }

    public JComboBox getComboBoxType() {
        return comboBoxType;
    }

    public JSpinner getSpinnerDays() {
        return spinnerDays;
    }

    public JTextField getTextFieldMass() {
        return textFieldMass;
    }

    public JTextField getTextFieldLogAmount() {
        return textFieldLogAmount;
    }

    public JButton getButtonCount() {
        return buttonCount;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    public JButton getButtonFinishEdit() {
        return buttonFinishEdit;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public int getIndex() {
        return Index;
    }
}
