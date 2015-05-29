package gui;

import model.DataModel;
import model.HistogramModel;
import model.Variable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



/**
 * Created by Alexandra on 20.05.2015.
 */
public class MainPanel extends JPanel {
    public MainPanel(DataModel dataModel) {



        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);


        JLabel titleHistogram = new JLabel("VariableName ");
       // this.add(titleHistogram, BorderLayout.EAST);
        JLabel titleScatterPlot = new JLabel("ScatterPlot: ");
        // this.add(titleScatterPlot, BorderLayout.SOUTH);

        JPanel scatterPanel= new JPanel();
        scatterPanel.setLayout(new BoxLayout(scatterPanel, BoxLayout.PAGE_AXIS));
        scatterPanel.setBackground(Color.GRAY);
        scatterPanel.add(titleScatterPlot);
        add(scatterPanel, BorderLayout.CENTER);


       ScatterPlot drawingScatterPlot = new ScatterPlot(dataModel.getVariableX(), dataModel.getVariableY());
        scatterPanel.add(drawingScatterPlot);

        JPanel histoPanel= new JPanel();
        histoPanel.setLayout(new BoxLayout(histoPanel, BoxLayout.LINE_AXIS));
        histoPanel.setBackground(Color.BLACK);
        scatterPanel.add(histoPanel);



        HistogramModel histogramModel = new HistogramModel();
        Histogram drawingPanel = new Histogram(histogramModel);
        drawingPanel.setBackground(Color.CYAN);
        drawingPanel.add(titleHistogram);
        Histogram drawingPane2 = new Histogram(histogramModel);
        drawingPane2.setBackground(Color.RED);
        drawingPane2.add(titleHistogram);


        histoPanel.add(drawingPanel);
        histoPanel.add(drawingPane2);
        //hallo comitte mal!!!!!!!!!!!!






    }
}
