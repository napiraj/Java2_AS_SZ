package gui;

import model.DataModel;
import model.HistogramModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Alexandra on 20.05.2015.
 */
public class MainPanel extends JPanel {

    private JPanel buttonPanel;
    private JLabel titleHistogram;
    private JLabel titleScatterPlot;
    private JPanel scatterPanel;
    private JPanel histoPanel;
    private HistogramModel histogramModel;
    private Histogram drawingPanel;
    private Histogram drawingPane2;
    private ScatterPlot drawingScatterPlot;
    private JComboBox pointSize;
    private JButton lineButton;
    private Integer selectedSize;

    public MainPanel(DataModel dataModel) {



        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);


        //getTopLevelAncestor().repaint(); ruft das Frame auf um alles neu zu zeichnen

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBackground(Color.BLUE);


        this.add(buttonPanel, BorderLayout.EAST);

        titleHistogram = new JLabel("Variable Name");

        titleScatterPlot = new JLabel("ScatterPlot: ");

        scatterPanel= new JPanel();
        scatterPanel.setLayout(new BoxLayout(scatterPanel, BoxLayout.PAGE_AXIS));
        scatterPanel.setBackground(Color.GRAY);
        scatterPanel.add(titleScatterPlot);
        add(scatterPanel, BorderLayout.CENTER);


        drawingScatterPlot = new ScatterPlot(dataModel.getVariableX(), dataModel.getVariableY());
        scatterPanel.add(drawingScatterPlot);

        pointSize = new JComboBox();
        for (int i = 1; i < 20; i++) {

            pointSize.addItem(i);

        }

        // Size of Dot
        pointSize.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                selectedSize = (Integer) pointSize.getSelectedItem();
                drawingScatterPlot.setDotSize(selectedSize);
                repaint();
            }});

        buttonPanel.add(pointSize);

        lineButton = new JButton("Line");

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                drawingScatterPlot.makeLine();

                repaint();
            }
        });

        buttonPanel.add(lineButton);

        histoPanel= new JPanel();
        histoPanel.setLayout(new BoxLayout(histoPanel, BoxLayout.LINE_AXIS));
        histoPanel.setBackground(Color.BLACK);
        scatterPanel.add(histoPanel);


        // Histogram Valriable 1
        histogramModel = new HistogramModel();
        drawingPanel = new Histogram(histogramModel);
        drawingPanel.setBackground(Color.CYAN);
        drawingPanel.add(titleHistogram);

        // Histogram Variable 2
        drawingPane2 = new Histogram(histogramModel);
        drawingPane2.setBackground(Color.RED);
        drawingPane2.add(titleHistogram);


        histoPanel.add(drawingPanel);
        histoPanel.add(drawingPane2);

        //


    }
}
