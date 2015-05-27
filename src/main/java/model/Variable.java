package model;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class Variable  extends DataModel{
    private String name;

    private ArrayList<Double> values;

    public Variable(String name, ArrayList<Double> valueVariable) {
        super(name, values);
        name=name;

        values= valueVariable;
    }

    public String getName(){
        return name;
    }

    public ArrayList getValue(){
        return values;
    }

    public int getNumberOfValue1(){
        return values.size();
    }


    public double getMin() {
        double smallestValueVariable1 = values.get(0);

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) < smallestValueVariable1) {
                smallestValueVariable1 = values.get(i);

            }


        }
        return smallestValueVariable1;
    }



    public double getMax(){
        double largestValueVariable1= values.get(0);

        for (int i= 1; i<values.size();i++) {
            if (values.get(i) > largestValueVariable1) {
                largestValueVariable1 = values.get(i);

            }
        }

        return largestValueVariable1;
    }





}
