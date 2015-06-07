package model;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Alexandra Stümer and Sabrina Zgraggen LST VZ 2013 on 2015.
 *
 */
public class ColumnorientedDataLoader implements DataLoader{

    public DataModel loadDataModel(File file) throws FileNotFoundException {

        Scanner inputScanner = new Scanner(file);

        ArrayList<Variable> allVariables = new ArrayList<Variable>();
        if(inputScanner.hasNextLine()) {
        String line = inputScanner.nextLine();
        int numberOfVariables;
        numberOfVariables=line.split("\t").length;

            // Create one Variable per name
            for (int i = 0; i < numberOfVariables; i++) {
                String variableName = line.split("\t")[i];
                allVariables.add(new Variable(variableName));
            }

            // Read Values for each Variable
            while (inputScanner.hasNextLine()) {
                String lineValues = inputScanner.nextLine();
                String[] stringValues = lineValues.split("\t");

                // for each Variable, parse current value and add it to the list of values.
                for (int a = 0; a < numberOfVariables; a++) {
                    Double value = Double.parseDouble(stringValues[a]);

                    Variable variable = allVariables.get(a);

                    ArrayList<Double> actualValues = variable.getValues();
                    actualValues.add(value);

                    variable.setValues(actualValues);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "File is empty", "Empty File", JOptionPane.WARNING_MESSAGE);
            System.exit(-1);
        }

        return new DataModel(allVariables);
        }

}
