package model;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Alexandra on 12.05.2015.
 */
public class ColumnorientedDataLoader implements DataLoader{
    public DataModel loadDataModel(File file) throws FileNotFoundException {

        Scanner inputScanner = new Scanner(file);


        String variableName1 = " ";
        ArrayList<Double> valuesList1 = new ArrayList<Double>();
        ArrayList<Double> valuesList2 = new ArrayList<Double>();
        Variable variable1 = null;
        Variable variable2 = null;
        ArrayList<String> allValues = new ArrayList<>();

        ArrayList<Variable> allVariables = new ArrayList<Variable>();

        String line = inputScanner.nextLine();
        int numberOfVariables = 0;
        numberOfVariables=line.split("\t").length;

        // Create one Variable per name
        for (int i = 0; i < numberOfVariables; i++) {
            String variableName = line.split("\t")[i];
            allVariables.add(new Variable(variableName));
        }

        // Read Values for each Variabel
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

            DataModel model = new DataModel(allVariables);

            return model;
        }


}
