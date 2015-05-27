package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexandra on 20.05.2015.
 */
public class Histogram extends JPanel{

    private final ArrayList<Double> values;

    public Histogram(ArrayList<Double> values) {
        this.values = values;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int barWidth = getWidth() / values.size();
        for (int i = 0; i < values.size(); i++) {
            double value = values.get(i);
            int barHeight = (int) (value / 100 * getHeight());

            int x = i * barWidth;
            int y = getHeight() - barHeight;

            g.setColor(Color.ORANGE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.YELLOW);
            g.drawRect(x, y, barWidth, barHeight);
        }
    }

}



