package model;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {

    private ArrayList<String> ListOfnamesOfVariable;
    private double countVariables;
    private ArrayList<Double> valuesOfVariable;


    public DataModel(ArrayList<String> nameOfVariable, double countVariables, ArrayList<Double> valuesOfVariable){
        this.ListOfnamesOfVariable = nameOfVariable;
        this.countVariables = countVariables;
        this.valuesOfVariable = valuesOfVariable;

    }


    public ArrayList<String> getVariableName()
    {
        return this.ListOfnamesOfVariable;
    }
    public ArrayList<Double> getValues(String whichVariable)
    {
        return valuesOfVariable;
    }

    public double getCountVariables(){
        return countVariables;
    }

    public int getNumberOfValues(String whichVariable){
        return valuesOfVariable.size();
    }

    public double getMin(String whichVariable) {
        double smallestValueVariable1 = valuesOfVariable.get(0);

        for (int i = 1; i < valuesOfVariable.size(); i++) {
            if (valuesOfVariable.get(i) < smallestValueVariable1) {
                smallestValueVariable1 = valuesOfVariable.get(i);

            }
        }
        return smallestValueVariable1;

    }

    public double getMax(String whichVariable){
        double largestValueVariable1= valuesOfVariable.get(0);

        for (int i= 1; i<valuesOfVariable.size();i++) {
            if (valuesOfVariable.get(i) > largestValueVariable1) {
                largestValueVariable1 = valuesOfVariable.get(i);

            }
        }

        return largestValueVariable1;
    }


    public String toString(){
        return null;
    }
}
