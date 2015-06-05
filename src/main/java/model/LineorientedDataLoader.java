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


        double valueParse1;
        double valueParse2;
        double numberOfVariables;
        String variableName1 = " ";
        String variableName2 = " ";

        ArrayList<Double> valuesList1 = new ArrayList<Double>();
        ArrayList<Double> valuesList2 = new ArrayList<Double>();

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


        /*variableName1= inputScanner.nextLine();
        variableName2= inputScanner.nextLine();

        String separator= inputScanner.nextLine();
        ArrayList<String> separatedLine1= new ArrayList<String>();
        Variable variable1=null;
        Variable variable2= null;


        while(inputScanner.hasNextLine()){
            String[] lineVariable1= inputScanner.nextLine().split(separator);
            for(int i=0; i<lineVariable1.length;i++) {
                valuesList1.add(Double.parseDouble(lineVariable1[i]));
            }
            String[] lineVariable2=inputScanner.nextLine().split(separator);
            for(int i=0; i<lineVariable2.length;i++) {
                valuesList2.add(Double.parseDouble(lineVariable2[i]));
            }
            //variable1 = new Variable(, valuesList1);
            //variable2= new Variable(variableName2, valuesList2);


        }*/


        //return new DataModel(variable1);
    }


}
