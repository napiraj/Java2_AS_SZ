package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandra on 12.05.2015.
 */
public class LineorientedDataLoader implements DataLoader {
    public DataModel loadDataModel(File file) throws FileNotFoundException {

        Scanner inputScanner= new Scanner(file);

        double numberOfVariables;

        //ArrayList<Double> valuesList1 = new ArrayList<Double>();
        //ArrayList<Double> valuesList2 = new ArrayList<Double>();

        // while in has.next
        String line = inputScanner.nextLine();
        numberOfVariables = Double.parseDouble(line);

        ArrayList<Variable> allVariables = new ArrayList<Variable>();

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

            for(int i=0; i < values.length; i ++){
                Double value = Double.parseDouble(values[i]);
                valuesAsDouble.add(value);
            }

            variable.setValues(valuesAsDouble);
        }

        return new DataModel(allVariables);


    }


}
