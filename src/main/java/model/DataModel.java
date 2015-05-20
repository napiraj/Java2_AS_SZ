package model;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {
    private String name;
    private String name2;

    private ArrayList<Double> valueVariable1;
    private ArrayList<Double> valueVariable2;



    public DataModel(String name, String name2, ArrayList<Double> valueVariable1, ArrayList<Double> valueVariable2){
        this.name=name;
        this.name2=name2;
        this.valueVariable1 = valueVariable1;
        this.valueVariable2=valueVariable2;



    }

    public String getName1(){
        return name;
    }
    public String getName2(){
        return name2;
    }

    public ArrayList getValue1(){
        return valueVariable1;
    }
    public ArrayList getValue2(){
        return valueVariable2;
    }

    public int getNumberOfValue(){
        return valueVariable1.size() + valueVariable2.size();
    }

    public double getMin(){
        double smallestValueVariable1= valueVariable1.get(0);
        double smallestValueVariable2= valueVariable2.get(0);
        for (int i= 1; i<valueVariable1.size();i++) {
            if (valueVariable1.get(i) < smallestValueVariable1) {
                smallestValueVariable1 = valueVariable1.get(i);

            }
        }
        for (int i= 1; i<valueVariable2.size();i++){
            if(valueVariable2.get(i)<smallestValueVariable2){
                smallestValueVariable2=valueVariable2.get(i);

            }

        }
        return smallestValueVariable1 + smallestValueVariable2;
    }

    public double getMax(){
        double largestValueVariable1= valueVariable1.get(0);
        double largestValueVariable2= valueVariable2.get(0);
        for (int i= 1; i<valueVariable1.size();i++) {
            if (valueVariable1.get(i) > largestValueVariable1) {
                largestValueVariable1 = valueVariable1.get(i);

            }
        }
        for (int i= 1; i<valueVariable2.size();i++){
            if(valueVariable2.get(i)>largestValueVariable2){
                largestValueVariable2=valueVariable1.get(i);

            }

        }
        return largestValueVariable1 + largestValueVariable2;
    }
    public String toString(){
        return null;
    }
}
