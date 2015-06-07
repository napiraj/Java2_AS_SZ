package model;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandra Stümer and Sabrina Zgraggen LST VZ 2013 on 2015.
 */
public class LineorientedDataLoader implements DataLoader {
    public DataModel loadDataModel(File file) throws FileNotFoundException {

        Scanner inputScanner= new Scanner(file);
        ArrayList<Variable> allVariables = new ArrayList<Variable>();

        double numberOfVariables;


        if(inputScanner.hasNextLine()){
        String line = inputScanner.nextLine();
        numberOfVariables = Double.parseDouble(line);



        // Read all variable names and add a variable each.
        for(int a = 0; a < numberOfVariables; a++) {
            String variableName = inputScanner.nextLine();
            Variable variable = new Variable(variableName);
            allVariables.add(variable);
        }

        // Read separator
        String separator= inputScanner.nextLine();

        // Read all values for each variable
        for(int a = 0; a < numberOfVariables; a++) {
            Variable variable = allVariables.get(a);


            String valueLine = inputScanner.nextLine();
            String[] values = valueLine.split(separator);

            ArrayList<Double> valuesAsDouble = new ArrayList<Double>();

            for (int i = 0; i < values.length; i++) {
                Double value = Double.parseDouble(values[i]);
                valuesAsDouble.add(value);
            }


            variable.setValues(valuesAsDouble);
        }  }
        else{
            JOptionPane.showMessageDialog(null, "File is empty", "Empty File", JOptionPane.WARNING_MESSAGE);
            System.exit(-1);
        }

        return new DataModel(allVariables);

    }


}
