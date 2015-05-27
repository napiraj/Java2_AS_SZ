package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class Histogram extends JPanel{

    private ArrayList<Double> values;
    private double classesOfValue;

    public Histogram(ArrayList values) {
        this.values = values;
        this.classesOfValue = 0;
    }


    @Override
    protected void paintComponent(Graphics g) {
        double classesOfValue = Math.round((double) ((values.size() /(Math.sqrt(values.size())))));

        int barWidth = (int) (getWidth() / classesOfValue); //width = Breite, Methode holt sich die min. Breite des Frame + teilt sie durch Arraygrösse
        for (int i = 0; i < values.size(); i++) {
            double value = values.get(i);
            int barHeight = (int) (value / 100 * getHeight());

            int x = (int) ((int) i * barWidth);
            int y = getHeight() - barHeight;

            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.BLUE);
            g.drawRect(x, y, barWidth, barHeight);
        }
    }

}



