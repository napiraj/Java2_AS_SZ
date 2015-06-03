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
    private JLabel titleHistogramVariable1;
    private JLabel titleHistogramVariable2;
    private JLabel titleScatterPlot;
    private JPanel scatterPanel;
    private JPanel histoPanel;
    private HistogramModel histogramModel;
    private HistogramModel histogramModel1;
    private Histogram drawingPanel;
    private Histogram drawingPane2;
    private ScatterPlot drawingScatterPlot;
    private JComboBox pointSize;
    private JCheckBox lineButton;
    private Integer selectedSize;

    public MainPanel(DataModel dataModel) {

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);


        //getTopLevelAncestor().repaint(); ruft das Frame auf um alles neu zu zeichnen

        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new GridLayout(4, 1));
        this.buttonPanel.setBackground(Color.WHITE);


        this.add(buttonPanel, BorderLayout.EAST);

        this.titleHistogramVariable1 = new JLabel(dataModel.getVariableX().getName());
        this.titleHistogramVariable2 = new JLabel(dataModel.getVariableY().getName());


        this.titleScatterPlot = new JLabel("ScatterPlot: ");

        this.scatterPanel= new JPanel();
        this.scatterPanel.setLayout(new BoxLayout(scatterPanel, BoxLayout.PAGE_AXIS));
        this.scatterPanel.setBackground(Color.YELLOW);
        this.scatterPanel.add(titleScatterPlot);
        add(scatterPanel, BorderLayout.CENTER);


        this.drawingScatterPlot = new ScatterPlot(dataModel.getVariableX(), dataModel.getVariableY());
        this.scatterPanel.add(drawingScatterPlot);

        this.pointSize = new JComboBox();
        for (int i = 1; i < 20; i++) {

            pointSize.addItem(i);

        }

        // Size of Dot
        pointSize.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                selectedSize = (Integer) pointSize.getSelectedItem();
                drawingScatterPlot.setDotSize(selectedSize);

            }
        });

        buttonPanel.add(pointSize);

        lineButton = new JCheckBox("Line");

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                drawingScatterPlot.setLine = true;

            }
        });

        buttonPanel.add(lineButton);

        histoPanel= new JPanel();
        histoPanel.setLayout(new BoxLayout(histoPanel, BoxLayout.LINE_AXIS));
        histoPanel.setBackground(Color.GREEN);
        scatterPanel.add(histoPanel);


        // Histogram Valriable 1
        histogramModel = new HistogramModel(dataModel.getVariableX());
        drawingPanel = new Histogram(histogramModel);
        drawingPanel.setBackground(Color.CYAN);
        drawingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        drawingPanel.add(titleHistogramVariable1);

        // Histogram Variable 2
        histogramModel1 = new HistogramModel(dataModel.getVariableY());
        drawingPane2 = new Histogram(histogramModel1);
        drawingPane2.setBackground(Color.RED);
        drawingPane2.add(titleHistogramVariable2);


        histoPanel.add(drawingPanel);
        histoPanel.add(drawingPane2);

    }
}
