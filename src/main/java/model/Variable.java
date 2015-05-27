package model;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class Variable {
    private String nameOfVariable;
    private ArrayList<Double> valuesOfVariable;



    public Variable(String nameOfVariable, ArrayList<Double> values) {
        this.nameOfVariable = nameOfVariable;
        this.valuesOfVariable = values;
    }



}
