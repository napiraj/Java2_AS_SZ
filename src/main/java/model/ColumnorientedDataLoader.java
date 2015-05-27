package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Alexandra on 12.05.2015.
 */
public class ColumnorientedDataLoader implements DataLoader{
    public DataModel loadDataModel(File file){
        Scanner inputScanner=null;

        try {
            inputScanner= new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }

        String variableName1=" ";
        String variableName2=" ";
        ArrayList<String> allVariables = new ArrayList<String>();
        ArrayList<Double> valuesList1=new ArrayList<Double>();
        ArrayList<Double> valuesList2= new ArrayList<Double>();


        String line = inputScanner.nextLine();
        double countVariables = line.split("\t").length;

        variableName1 = line.split("\t")[0];
        variableName2 = line.split("\t")[1];
        allVariables.add(variableName1);
        allVariables.add(variableName2);

        while(inputScanner.hasNextLine()) {
            String valueRead1 = inputScanner.next();
            String valueRead2= inputScanner.next();

            valuesList1.add(Double.parseDouble(valueRead1));
            valuesList2.add(Double.parseDouble(valueRead2));

        }
        ArrayList<Double> valuesOfVariable = new ArrayList<Double>();

        for (int i = 0; i < valuesList1.size(); i++){
        valuesOfVariable.add(valuesList1.get(i));}

        for (int i = 0; i < valuesList2.size(); i++){
            valuesOfVariable.add(valuesList2.get(i));}


       /* Variable var1 = new DataModel(allVariables, valuesList1);
        Variable var2 = new Variable(variableName2, valuesList1);

        ArrayList<Variable> varlist = new ArrayList<Variable>();
        varlist.add(var1);
        varlist.add(var2); */

        return new DataModel(allVariables, countVariables, valuesOfVariable);
    }

}
