package gui;

import model.HistogramModel;
import model.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexandra Stümer and Sabrina Zgraggen LST VZ 2013 on 20.05.2015.
 *
 */
public class Histogram extends JPanel{

    private HistogramModel histogramModel;
    private double classes;
    private ArrayList<Integer> counterValues;
    private double highestBar;




    public void setAxis(HistogramModel histogramModel){
        this.histogramModel=histogramModel;
        this.classes=histogramModel.getCountClasses();
        this.counterValues=histogramModel.getCounterValues();
        this.highestBar=histogramModel.getHighestBar();
        this.repaint();

    }

    public Histogram(HistogramModel histogramModel)
    {

        this.histogramModel = histogramModel;
        this.classes = histogramModel.getCountClasses();
        this.counterValues=histogramModel.getCounterValues();
        this.highestBar=histogramModel.getHighestBar();

    }


   @Override
   // hier liegt ein Problem vor, er painted die neue Werte nicht
    protected void paintComponent(Graphics g) {

       super.paintComponent(g);
       int width = getWidth();
       int heigh = getHeight();
        int barWidth = (int) (getWidth() / classes);

        for (int i = 0; i <classes ; i++) {
            double value =counterValues.get(i);

            double coefficient=0.87*getHeight()/highestBar;
            int barHeight = (int) (value*coefficient);


            int x = i * barWidth;
            int y = getHeight() - barHeight;
            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x, y, barWidth, barHeight);


            g.drawString(histogramModel.getNameOfHistogramVariable(), width / 3, heigh / 12);
        }

    }
}



