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

    private ScatterPlot drawingScatterPlot;
    private JComboBox pointSize;
    private JCheckBox lineButton;
    private Integer selectedSize;
    private JComboBox selectedVariable;
    private Integer selectedItem;
    private JComboBox secondselectedVariable;
    private Integer selectedItem2;

    public MainPanel(DataModel dataModel) {

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);


        //getTopLevelAncestor().repaint(); ruft das Frame auf um alles neu zu zeichnen

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.setBackground(Color.WHITE);


        this.add(buttonPanel, BorderLayout.EAST);

        //JLabel titleHistogramVariable1 = new JLabel(dataModel.getVariableX().getName());
        //JLabel titleHistogramVariable2 = new JLabel(dataModel.getVariableY().getName());


        JLabel titleScatterPlot = new JLabel("ScatterPlot: ");

        JPanel scatterPanel= new JPanel();
        scatterPanel.setLayout(new BoxLayout(scatterPanel, BoxLayout.PAGE_AXIS));
        scatterPanel.setBackground(Color.GRAY);
        scatterPanel.add(titleScatterPlot);
        add(scatterPanel, BorderLayout.CENTER);

        this.selectedVariable = new JComboBox();


        selectedVariable.addItem(dataModel.getAllVariable().toString());

        this.selectedVariable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedItem = (Integer) selectedVariable.getSelectedItem();
            }
        });

        buttonPanel.add(selectedVariable);

        this.secondselectedVariable = new JComboBox();


        secondselectedVariable.addItem(dataModel.getAllVariable().toString());

        this.secondselectedVariable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedItem2 = (Integer) secondselectedVariable.getSelectedItem();
            }
        });

        buttonPanel.add(secondselectedVariable);


        this.drawingScatterPlot = new ScatterPlot(dataModel.getAllVariable().get(selectedItem), dataModel.getAllVariable().get(selectedItem2));
        scatterPanel.add(drawingScatterPlot);

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

                drawingScatterPlot.setDrawLine(lineButton.isSelected());

            }});


        buttonPanel.add(lineButton);

        JButton colorButton = new JButton("Color");

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Color dotColor = JColorChooser.showDialog(null, "Choose a Color", Color.black);
                if (dotColor != null)
                {
                    drawingScatterPlot.setDotColor(dotColor);
                }
            }});

        buttonPanel.add(colorButton);



        JPanel histoPanel= new JPanel();
        histoPanel.setLayout(new BoxLayout(histoPanel, BoxLayout.LINE_AXIS));
        histoPanel.setBackground(Color.GREEN);
        scatterPanel.add(histoPanel);


        // Histogram Valriable 1
        HistogramModel histogramModelXValue = new HistogramModel(dataModel.getAllVariable().get(selectedItem));
        Histogram drawingPanelX = new Histogram(histogramModelXValue);
        drawingPanelX.setBackground(Color.CYAN);
        drawingPanelX.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        //drawingPanelX.add(titleHistogramVariable1);

        // Histogram Variable 2
        HistogramModel histogramModelYValue = new HistogramModel(dataModel.getAllVariable().get(selectedItem2));
        Histogram drawingPanelY = new Histogram(histogramModelYValue);
        drawingPanelY.setBackground(Color.RED);
        drawingPanelY.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        //drawingPanelY.add(titleHistogramVariable2);


        histoPanel.add(drawingPanelX);
        histoPanel.add(drawingPanelY);

    }
}
