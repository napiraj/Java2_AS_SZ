package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {

    private Variable x;
    private Variable y;

    private ArrayList<Variable> variables;

    public DataModel(Variable x){
        //this.x =x.getValue(0);
        //this.y=y;

    }

    public  DataModel(ArrayList<Variable> variables){
        this.variables = variables;
    }

   /* public Variable getVariableX(){

        // For Testing only
        if(variables != null && variables.get(0) != null) {
            return variables.get(0);
        }

        // For Testing only
        return new Variable("dummy Variable");
    }

    public Variable getVariableY(){

        //return y;

        if(variables != null && variables.get(1) != null) {
            return variables.get(1);
        }

        return new Variable("dummy Variable");

    }*/

    public ArrayList<Variable> getAllVariable()
    {
        return variables;
    }



}
