package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {
    private String name;
    private String name2;

    private static ArrayList<Double> valueVariable1;
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

    public static ArrayList getValue1(){
        return valueVariable1;
    }
    public ArrayList getValue2(){
        return valueVariable2;
    }

    public int getNumberOfValue1(){
        return valueVariable1.size();
    }

    public int getNumberOfValue2(){
        return valueVariable2.size();
    }

    public double getMin1() {
        double smallestValueVariable1 = valueVariable1.get(0);

        for (int i = 1; i < valueVariable1.size(); i++) {
            if (valueVariable1.get(i) < smallestValueVariable1) {
                smallestValueVariable1 = valueVariable1.get(i);

            }


        }
        return smallestValueVariable1;
    }
    public double getMin2(){

        double smallestValueVariable2= valueVariable2.get(0);
        for (int i= 1; i<valueVariable2.size();i++){
            if(valueVariable2.get(i)<smallestValueVariable2){
                smallestValueVariable2=valueVariable2.get(i);

            }

        }
        return smallestValueVariable2;
    }


    public double getMax1(){
        double largestValueVariable1= valueVariable1.get(0);

        for (int i= 1; i<valueVariable1.size();i++) {
            if (valueVariable1.get(i) > largestValueVariable1) {
                largestValueVariable1 = valueVariable1.get(i);

            }
        }

        return largestValueVariable1;
    }

    public double getMax2(){

        double largestValueVariable2= valueVariable2.get(0);
        for (int i= 1; i<valueVariable2.size();i++){
            if(valueVariable2.get(i)>largestValueVariable2){
                largestValueVariable2=valueVariable1.get(i);

            }

        }
        return largestValueVariable2;
    }

    public String toString(){
        return null;
    }
}
