package datamodel;
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
    public double getMin(){
        return 0;
    }
    public double getMax()
    {
        return 0;
    }
    public String toString(){
        return null;
    }
}
