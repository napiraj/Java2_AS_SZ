package Datamodel;


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
        double valueParse1;
        double valueParse2;
        String variableName1=" ";
        ArrayList<Double> valuesList1=new ArrayList<Double>();
        ArrayList<Double> valuesList2= new ArrayList<Double>();


        String line = inputScanner.nextLine();
        variableName1 = line.split("\t")[0];
        String variableName2 = line.split("\t")[1];
        while(inputScanner.hasNextLine()) {
            String valueRead1 = inputScanner.next();
            String valueRead2= inputScanner.next();
            valueParse1 = Double.parseDouble(valueRead1);
            valueParse2= Double.parseDouble(valueRead2);
            valuesList1.add(valueParse1);
            valuesList2.add(valueParse2);

            Variable variable1 = new Variable(variableName1, valuesList1);
            //Variable variable2 = new Variable();

        }

        return new Variable(variableName1,valuesList1);
    }


}
