package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandra on 13.05.2015.
 */
public class DataModel {

    private Variable x;
    private Variable y;



    public DataModel(Variable x, Variable y){
        this.x =x;
        this.y=y;

    }

    public Variable getVariableX(){
        return x;
    }

    public Variable getVariableY(){
        return y;
    }




}
