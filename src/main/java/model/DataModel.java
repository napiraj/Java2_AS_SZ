package model;
import java.util.ArrayList;

/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 13.05.2015.
 */
public class DataModel {

    private ArrayList<Variable> variables;

    public DataModel(Variable variable){
    }

    public  DataModel(ArrayList<Variable> variables){
        this.variables = variables;
    }


    public ArrayList<Variable> getAllVariable()
    {
        return variables;
    }



}
