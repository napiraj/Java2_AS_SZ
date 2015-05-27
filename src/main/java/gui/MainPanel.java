package gui;

import model.DataModel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



/**
 * Created by Alexandra on 20.05.2015.
 */
public class MainPanel extends JPanel {
    public MainPanel() {

        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JLabel titleHistogram = new JLabel("VariableName ");
        this.add(titleHistogram, BorderLayout.EAST);
        JLabel titleScatterPlot = new JLabel("ScatterPlot: ");
        this.add(titleScatterPlot, BorderLayout.SOUTH);


        ArrayList<Double> values= new ArrayList<Double>();
        ArrayList<Double> xasi = new ArrayList<Double>();
        ArrayList<Double> yaxi = new ArrayList<Double>();

        for (int a = 0; a < values.size(); a++)
        {
            values.add((Double) DataModel.getValue1().get(a));
        }

        for (int i = 0; i < xasi.size(); i++)
        {
            xasi.add(values.get(i));
        }

        for (int b = 0; b < xasi.size(); b++)
        {
            xasi.add(values.get(b));
        }

        Histogram drawingPanel = new Histogram(values);
        setLayout(new BorderLayout());
        add(drawingPanel);


        ScatterPlot drawingScatterPlot = new ScatterPlot(xasi, yaxi);

        add(drawingScatterPlot);
    }
}
