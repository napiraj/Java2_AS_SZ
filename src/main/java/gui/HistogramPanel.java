package gui;

import model.HistogramModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexandra Stümer and Sabrina Zgraggen LST VZ 2013 on 2015.
 * draws the histogram
 */
public class HistogramPanel extends JPanel{

    private HistogramModel histogramModel;
    private double classes;
    private ArrayList<Integer> counterOfValues;
    private double highestBar;



    public void setAxis(HistogramModel histogramModel){
        this.histogramModel=histogramModel;
        this.classes=histogramModel.getCountClasses();
        this.counterOfValues =histogramModel.getCounterValues();
        this.highestBar=histogramModel.getHighestBar();
        this.repaint();

    }

    public HistogramPanel(HistogramModel histogramModel)
    {
        this.histogramModel = histogramModel;
        this.classes = histogramModel.getCountClasses();
        this.counterOfValues =histogramModel.getCounterValues();
        this.highestBar=histogramModel.getHighestBar();
    }


   @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);

       int width = getWidth();
       int height = getHeight();
        int barWidth = (int) (getWidth() / classes);

        for (int i = 0; i <classes ; i++) {
            double value = counterOfValues.get(i);

            double coefficient=0.87*getHeight()/highestBar;
            int barHeight = (int) (value*coefficient);


            int x = i * barWidth;
            int y = getHeight() - barHeight;
            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x, y, barWidth, barHeight);


            g.drawString(histogramModel.getNameOfHistogramVariable(), width / 3, height / 12);
        }

    }
}



