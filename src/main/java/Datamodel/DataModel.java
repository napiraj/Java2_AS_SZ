package datamodel;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {
    private String name;
    private ArrayList<Double> valueVariable1;
    private ArrayList<Double> valueVariable2;


    public DataModel(String name,ArrayList<Double> valueVariable1, ArrayList<Double> valueVariable2){
        this.name=name;
        this.valueVariable1 = valueVariable1;
        this.valueVariable2=valueVariable2;



    }

    public String getName(){
        return name;
    }
    public ArrayList getWerte(){
        return valueVariable1;
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
