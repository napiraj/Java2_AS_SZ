package gui;

import model.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class ScatterPlot extends JPanel{

    private double yminValue;
    private double ymaxValue;
    private double xminValue;
    private double xmaxValue;
    private double sizeOfPoint;
    private Variable xaxis;
    private Variable yaxis;

    public Color getDot_color() {
        return dot_color;
    }

    public void setDot_color(Color dot_color) {
        dot_color = dot_color;
        this.repaint();
    }

    private Color dot_color;

    public int getDotSize() {
        return dotSize;
    }

    public void setDotSize(int pointSize) {
        this.dotSize = pointSize;
    }

    private int dotSize;



    public ScatterPlot(Variable variable1, Variable variable2){

        this.xaxis= variable1;
        this.yaxis=variable2;

        this.dot_color = Color.BLACK;
    }

    @Override
    protected void paintComponent(Graphics g) {

        ArrayList<Double> variable1 = new ArrayList<Double>();
        ArrayList<Double> variable2= new ArrayList<Double>();


        variable1=xaxis.getValue();
        variable2=yaxis.getValue();
        yminValue = yaxis.getMin();
        ymaxValue = yaxis.getMax();
        xminValue=xaxis.getMin();
        xmaxValue=xaxis.getMax();


        double radius= 1; // hier kommt die wählbare Grösse rein
        double panelWidth=getWidth();
        double panelHeight=getHeight();
        double height= (ymaxValue - yminValue);
        double ycoefficient= panelWidth/height;
        double xcoefficient= panelHeight/(xmaxValue-xminValue);
        double widthLimiter= (1-0.92-0.025)*panelWidth;
        double heightLimiter=(1-0.85-0.01)*panelHeight;



        for( int i = 0; i< variable1.size();i++ ){

            double x=(((variable1.get(i)-xminValue)/(xmaxValue-xminValue))*(panelWidth-4*radius)+2*radius);
            double y= (panelHeight-((variable2.get(i)-yminValue)/height)*panelHeight*0.85)- heightLimiter;
            g.setColor(getDot_color());
            g.fillOval((int) (x), (int) (y), (int) radius, (int) radius);

        }

    }

}
