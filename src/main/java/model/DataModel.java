package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {

    private Variable variable;
    private ArrayList<Variable> variables;

    public DataModel(Variable variable){
        this.variable = variable;
    }

    public  DataModel(ArrayList<Variable> variables){
        this.variables = variables;
    }


    public ArrayList<Variable> getAllVariable()
    {
        return variables;
    }



}
