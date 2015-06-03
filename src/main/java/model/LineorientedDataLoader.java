package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandra on 12.05.2015.
 */
public class LineorientedDataLoader implements DataLoader {
    public DataModel loadDataModel(File file) { // FileNotFoundException

        Scanner inputScanner = null;

        try {
            inputScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;//  nicht return 0, Ausgaben schreiben e.getMessage
        }

        double valueParse1;
        double valueParse2;
        double numberOfVariables;
        String variableName1 = " ";
        String variableName2 = " ";

        ArrayList<Double> valuesList1 = new ArrayList<Double>();
        ArrayList<Double> valuesList2 = new ArrayList<Double>();

        String line = inputScanner.nextLine();
        numberOfVariables = Double.parseDouble(line);

        variableName1= inputScanner.nextLine();
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
            variable1 = new Variable(variableName1, valuesList1);
            variable2= new Variable(variableName2, valuesList2);


        }


        return new DataModel(variable1,variable2);
    }


}
