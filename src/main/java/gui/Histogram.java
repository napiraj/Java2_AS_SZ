package gui;

import model.HistogramModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class Histogram extends JPanel{




    private HistogramModel histogramModel;
    private double classes;
    private double countValuesPerClass;
    private double coefficient;

    public Histogram(HistogramModel histogramModel) {
        this.histogramModel = histogramModel;
        classes=histogramModel.getCountClasses();
        for(int i=0;i<classes;i++) {
            countValuesPerClass = histogramModel.getCounterValues(i);
        }


    }


   @Override
    protected void paintComponent(Graphics g) {
        int barWidth = (int) (getWidth() / classes); //width = Breite, Methode holt sich die min. Breite des Frame + teilt sie durch Arraygrösse
        for (int i = 0; i <classes ; i++) {
            double value = histogramModel.getCounterValues(i);
            coefficient=0.87*getHeight()/histogramModel.getHighestBar();
            int barHeight = (int) (value*coefficient);

            int x = (int) ((int) i * barWidth);
            int y = getHeight() - barHeight;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x, y, barWidth, barHeight);
        }

    }

}



