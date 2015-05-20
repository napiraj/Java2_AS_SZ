package Datamodel;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class Variable  extends DataModel{
    private String nameOfTheClassVariable;
    private ArrayList<Double> valuesOfTheClass1;
    private ArrayList<Double> valuesOfTheClass2;


    public Variable(String name, ArrayList<Double> valueVariable1, ArrayList<Double>valueVariable2) {
        super(name, wert);
        nameOfTheClassVariable=name;
        valuesOfTheClass1 = valueVariable1;
        valuesOfTheClass2= valueVariable2;
    }
}
