package gui;

import model.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class ScatterPlot extends JPanel{

    private Variable xaxis;
    private Variable yaxis;
    private int radius;
    private int dotSize=10;
    // private final double WIDTH_FACTOR = 0.055;
    private final double HEIGHT_FACTOR = 0.14;
    private boolean drawLine;

    public Color getDot_color() {
        return dot_color;
    }

    public void setDotColor(Color dot_color) {
        this.dot_color = dot_color;
        this.repaint();
    }

    private Color dot_color;

    public int getDotSize() {

        dotSize = radius * dotSize;
        return this.dotSize;
    }

    public void setDotSize(int pointSize) {
        this.dotSize = pointSize;
        this.repaint();
    }


    public void setDrawLine(boolean drawLine) {
        this.drawLine = drawLine;
        repaint();
    }



    public ScatterPlot(Variable variable1, Variable variable2){

        this.xaxis= variable1;
        this.yaxis=variable2;
        this.dot_color = Color.BLACK;

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Double> variable1 = xaxis.getValues();
        ArrayList<Double> variable2 = yaxis.getValues();

        double yminValue = yaxis.getMin();
        double ymaxValue = yaxis.getMax();
        double xminValue=xaxis.getMin();
        double xmaxValue=xaxis.getMax();


        this.radius= 10;
        double panelWidth=getWidth();
        double panelHeight=getHeight();
        double height= (ymaxValue - yminValue);
       // double ycoefficient= panelWidth/height;
       // double xcoefficient= panelHeight/(xmaxValue-xminValue);
        //double widthLimiter= WIDTH_FACTOR *panelWidth;
        double heightLimiter= HEIGHT_FACTOR *panelHeight;
        double x = 0;
        double y = 0;


            double previousValueX = 0;
            double previousValueY = 0;

            for (int valueIndex = 0; valueIndex < variable1.size(); valueIndex++)
            {
                x = (((variable1.get(valueIndex) - xminValue) / (xmaxValue - xminValue)) * (panelWidth - 4 * dotSize) + 2 * dotSize);
                y = (panelHeight - ((variable2.get(valueIndex) - yminValue) / height) * panelHeight * 0.85) - heightLimiter;
                g.setColor(getDot_color());
                g.fillOval((int) (x), (int) (y), dotSize, dotSize);

                if (valueIndex >= 1 && drawLine) {

                    g.drawLine((int) previousValueX, (int) previousValueY, (int) x, (int) y);
                }
                previousValueX = x;
                previousValueY = y;
            }


        //g.drawString(xaxis.getName(), (int) panelWidth/2, (int) panelHeight - radius);
        //g.drawString(yaxis.getName(), (int) radius, (int) panelHeight/8);

    }

}

