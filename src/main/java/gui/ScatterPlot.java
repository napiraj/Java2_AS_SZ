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
    private int radius;
    private double panelWidth;
    private double panelHeight;
    private double height;
    private double ycoefficient;
    private double xcoefficient;
    private double widthLimiter;
    private double heightLimiter;
    private int dotSize=10;
    boolean line;
    private final double WIDTH_FACTOR = 0.055;
    private final double HEIGHT_FACTOR = 0.14;
    private ArrayList<Double> variable1;
    private ArrayList<Double> variable2;
    private boolean setLine;

    public Color getDot_color() {
        return dot_color;
    }

    public void setDot_color(Color dot_color) {
        dot_color = dot_color;
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


    public boolean isSetLine() {
        return setLine;
    }

    public void setSetLine(boolean setLine) {
        this.setLine = setLine;
    }


    public ScatterPlot(Variable variable1, Variable variable2){

        this.xaxis= variable1;
        this.yaxis=variable2;
        this.line = false;
        this.dot_color = Color.BLACK;

    }

    @Override
    protected void paintComponent(Graphics g) {

       // this.variable1 = new ArrayList<Double>();
       // this.variable2= new ArrayList<Double>();


        variable1 = xaxis.getValue();
        variable2 = yaxis.getValue();
        this.yminValue = yaxis.getMin();
        this.ymaxValue = yaxis.getMax();
        this.xminValue=xaxis.getMin();
        this.xmaxValue=xaxis.getMax();


        this.radius= 10;
        this.panelWidth=getWidth();
        this.panelHeight=getHeight();
        this.height= (ymaxValue - yminValue);
        this.ycoefficient= panelWidth/height;
        this.xcoefficient= panelHeight/(xmaxValue-xminValue);
        this.widthLimiter= WIDTH_FACTOR *panelWidth; // realisiert als Konstante (1-0.92-0.025)*panelWidth;
        this.heightLimiter= HEIGHT_FACTOR *panelHeight; // (1-0.85-0.01)*panelHeight;
        double x = 0;
        double y = 0;


        if (!line) {
            for (int i = 0; i < variable1.size(); i++) {

                x = (((variable1.get(i) - xminValue) / (xmaxValue - xminValue)) * (panelWidth - 4 * dotSize) + 2 * dotSize);
                y = (panelHeight - ((variable2.get(i) - yminValue) / height) * panelHeight * 0.85) - heightLimiter;
                g.setColor(getDot_color());
                g.fillOval((int) (x), (int) (y), dotSize, dotSize);

            }
        }
        else if (line)
        {
            double firstValueX = xminValue;
            double firstValueY = yminValue;

            for (int c = 0; c < variable1.size(); c++)
            {
                x = (((variable1.get(c) - xminValue) / (xmaxValue - xminValue)) * (panelWidth - 4 * dotSize) + 2 * dotSize);
                y = (panelHeight - ((variable2.get(c) - yminValue) / height) * panelHeight * 0.85) - heightLimiter;
                g.setColor(getDot_color());
                g.fillOval((int) (x), (int) (y), dotSize, dotSize);

                g.drawLine((int) firstValueX,(int) firstValueY, (int)(x), (int)(y));
                firstValueX = x;
                firstValueY = y;
            }
            line = false;
        }

        g.drawString(xaxis.getName(), (int) panelWidth/2, (int) panelHeight - radius);
        g.drawString(yaxis.getName(), (int) radius, (int) panelHeight/8);

    }

}

