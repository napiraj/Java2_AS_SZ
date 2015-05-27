package gui;

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
    private ArrayList<Double> xaxis;
    private ArrayList<Double> yaxis;


    public ScatterPlot(ArrayList<Double> xaxis, ArrayList<Double> yaxis){

        this.minValue = 0;
        this.maxValue = 0;
        sizeOfPoint = 0;

        this.xaxis = xaxis;
        this.yaxis = yaxis;

    }

    @Override
    protected void paintComponent(Graphics g) {

        ArrayList<Integer> castValue = new ArrayList<Integer>();

        for (int a = 0; a< xaxis.size(); a++)
        {
            castValue.add((xaxis.get(a)));
        }

        for (int i = 0; i < xaxis.size(); i++) {
            g.drawLine(xaxis.get(i), yaxis.get(i), xaxis.get(i), yaxis.get(i));

            g.setColor(Color.BLACK);
        }
    }

}
