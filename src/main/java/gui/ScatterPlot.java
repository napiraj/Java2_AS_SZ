package gui;

import model.DataModel;
import model.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class ScatterPlot extends JPanel{

    private double minValue;
    private double maxValue;
    private double sizeOfPoint;
    private Variable xaxis;
    private Variable yaxis;



    public ScatterPlot(Variable variable1, Variable variable2){

        this.xaxis= variable1;
        this.yaxis=variable2;




    }

    @Override
    protected void paintComponent(Graphics g) {

        ArrayList<Double> variable1 = new ArrayList<>();
        ArrayList<Double> variable2= new ArrayList<>();


        variable1=xaxis.getValue();
        variable2=yaxis.getValue();
        double min= yaxis.getMin();
        double max= yaxis.getMax();

        double radius= 10;
        double width=getWidth();
        double panelHeight=getHeight();
        double height= (max-min);
        double coefficient= width/height;



        for( int i = 0; i< variable1.size();i++ ){

            double value1=((variable1.get(i))*coefficient);
            double value2= (panelHeight-variable2.get(i));
            g.fillOval((int)(value1),(int) (value2),(int) radius,(int) radius);
            g.setColor(Color.BLUE);

        }

    }

}
