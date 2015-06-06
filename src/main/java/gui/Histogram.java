package gui;

import model.HistogramModel;
import model.Variable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class Histogram extends JPanel{

    private HistogramModel histogramModel;
    private double classes;
    private Variable var;






    public void setAxis(HistogramModel histogramModel){
        this.histogramModel=histogramModel;
        this.classes=histogramModel.getCountClasses();
        //bis hierhin läuft es

        repaint();
        System.out.println("countClass" + histogramModel.getCountClasses() + "\ncounterValues  " + histogramModel.getCounterValues(0) + "\nhighestbar: " + histogramModel.getHighestBar());

    }

    public Histogram(HistogramModel histogramModel)
    {
        this.histogramModel = histogramModel;
        this.classes = histogramModel.getCountClasses();


        for(int i=0;i<classes;i++)
        {
            double countValuesPerClass = histogramModel.getCounterValues(i);
        }
    }



   @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
        int barWidth = (int) (getWidth() / classes);
        for (int i = 0; i <classes ; i++) {
            double value = histogramModel.getCounterValues(i);
            double coefficient=0.87*getHeight()/histogramModel.getHighestBar();
            int barHeight = (int) (value*coefficient);

            int x = i * barWidth;
            int y = getHeight() - barHeight;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x, y, barWidth, barHeight);

        }

    }
}



