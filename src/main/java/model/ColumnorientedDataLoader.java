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
            return null;
        }

        String variableName1=" ";
        ArrayList<Double> valuesList1=new ArrayList<Double>();
        ArrayList<Double> valuesList2= new ArrayList<Double>();
        Variable variable1=null;
        Variable variable2=null;


        String line = inputScanner.nextLine();
        variableName1 = line.split("\t")[0];
        String variableName2 = line.split("\t")[1];
        while(inputScanner.hasNextLine()) {
            String valueRead1 = inputScanner.next();
            String valueRead2= inputScanner.next();
            valuesList1.add(Double.parseDouble(valueRead1));
            valuesList2.add(Double.parseDouble(valueRead2));

            variable1 = new Variable(variableName1, valuesList1);
            variable2= new Variable(variableName2, valuesList2);



        }

        return new DataModel(variable1,variable2);
    }

}
