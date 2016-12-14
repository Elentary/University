package kr.action;

import by.bsu.labs.lab10.exception.DataFormatException;
import by.bsu.labs.lab10.form.OpenFileDialog;
import kr.entity.ForestTree;
import kr.entity.FruitTree;
import kr.entity.Tree;
import kr.entity.Type;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by amareelez on 14.12.16.
 */

public class OpenFile {
    public static ArrayList<Tree> readTrees() {
        OpenFileDialog dialog = new OpenFileDialog();

        try {
            if (dialog.getFile() == null)
                throw new RuntimeException("File was not chosen");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(dialog.getFile()))) {
            String line = reader.readLine();
            ArrayList<Tree> trees = new ArrayList<>();

            if (line == null) {
                throw new Exception("File is empty");
            }

            while (line != null) {
                String[] data = line.split(" ");
                if (data.length == 4) {
                    trees.add(
                        new ForestTree(data[0], Integer.parseInt(data[1]), Type.valueOf(data[2]),
                            Double.parseDouble(data[3])));
                } else if (data.length == 5) {
                    trees.add(
                        new FruitTree(data[0], Integer.parseInt(data[1]), Type.valueOf(data[2]),
                            Double.parseDouble(data[3]), Integer.parseInt(data[4])));
                } else {
                    throw new DataFormatException(line);
                }
                line = reader.readLine();
            }

            return trees;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Reading error, check you file system");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Incorrect number format");
        } catch (DataFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
