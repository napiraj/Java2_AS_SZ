package model;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class Variable  extends DataModel{
    private String nameOfTheClassVariable;
    private String nameOfTheClassVariable2;
    private ArrayList<Double> valuesOfTheClass1;
    private ArrayList<Double> valuesOfTheClass2;


    public Variable(String name, String name2, ArrayList<Double> valueVariable1, ArrayList<Double> valueVariable2) {
        super(name, name2, valueVariable1, valueVariable2);
        nameOfTheClassVariable=name;
        nameOfTheClassVariable2=name2;
        valuesOfTheClass1 = valueVariable1;
        valuesOfTheClass2= valueVariable2;
    }


}
