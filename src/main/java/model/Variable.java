package model;
import java.util.ArrayList;

/**
 * Created by Alexandra Stümer and Sabrina Zgraggen LST VZ 2013 on 2015.
 */
public class Variable {
    private String name;

    private ArrayList<Double> values;

    public Variable(String name){
        this.name = name;
        this.values = new ArrayList<Double>();
    }

   /* public Variable(String name, ArrayList<Double> valueVariable) {

        this.name= name;
        this.values= valueVariable;
    } */

    public void setValues(ArrayList<Double> values){
        this.values = values;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList getValues(){
        return this.values;
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


    @Override
    public String toString(){
        return name;
    }

}
