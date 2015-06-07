package gui;

import model.DataModel;
import model.HistogramModel;
import model.Variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 2015.
 * draws the Main Panel components
 */
public class MainPanel extends JPanel {

    private ScatterPlotPanel drawingScatterPlotPanel;
    private JComboBox pointSize;
    private JCheckBox lineButton;
    private Integer selectedSize;
    private JComboBox selectedVariable;
    private Variable selectedItem;
    private JComboBox secondselectedVariable;
    private Variable selectedItem2;
    private HistogramPanel drawingPanelX;
    private HistogramPanel drawingPanelY;
    private HistogramModel histogramModelXValue;
    private HistogramModel histogramModelYValue;

    public MainPanel(DataModel dataModel) {

        selectedItem=dataModel.getAllVariable().get(0);
        selectedItem2=dataModel.getAllVariable().get(1);


        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.setBackground(Color.WHITE);


        this.add(buttonPanel, BorderLayout.EAST);


        JLabel titleScatterPlot = new JLabel("Scatter Plot: ");

        JPanel scatterPanel = new JPanel();
        scatterPanel.setLayout(new BoxLayout(scatterPanel, BoxLayout.PAGE_AXIS));
        scatterPanel.setBackground(Color.WHITE);
        scatterPanel.add(titleScatterPlot);
        add(scatterPanel, BorderLayout.CENTER);

        // new Scatter Plot
        this.drawingScatterPlotPanel = new ScatterPlotPanel(selectedItem, selectedItem2);
        scatterPanel.add(drawingScatterPlotPanel);

        // select first Variable
        this.selectedVariable = new JComboBox<Variable>();

        for (Variable var : dataModel.getAllVariable()) {
            selectedVariable.addItem(var);
        }


        selectedVariable.setSelectedItem(dataModel.getAllVariable().get(0));
        buttonPanel.add(selectedVariable);

        // select second Variable
        this.secondselectedVariable = new JComboBox<Variable>();

        for (Variable var : dataModel.getAllVariable()) {
            secondselectedVariable.addItem(var);
        }

        secondselectedVariable.setSelectedItem(dataModel.getAllVariable().get(1));
        buttonPanel.add(secondselectedVariable);


        // Size of Dot
        this.pointSize = new JComboBox();

        for (int i = 1; i < 20; i++) {

            pointSize.addItem(i);

        }

        pointSize.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e)
              {
                  selectedSize = (Integer) pointSize.getSelectedItem();
                  drawingScatterPlotPanel.setDotSize(selectedSize);

              }
        });
        pointSize.setSelectedItem(10);
        buttonPanel.add(pointSize);


        // Line Button
        lineButton = new JCheckBox("Line");

        lineButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                drawingScatterPlotPanel.setDrawLine(lineButton.isSelected());
            }
        });

        buttonPanel.add(lineButton);


        // Color Button
        JButton colorButton = new JButton("Color");

        colorButton.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {

                 Color dotColor = JColorChooser.showDialog(null, "Choose a Color", Color.black);
                        if (dotColor != null)
                        {
                              drawingScatterPlotPanel.setDotColor(dotColor);
                        }
             }
        });

        buttonPanel.add(colorButton);

        JPanel histoPanel = new JPanel();
        histoPanel.setLayout(new BoxLayout(histoPanel, BoxLayout.LINE_AXIS));
        histoPanel.setBackground(Color.CYAN);
        scatterPanel.add(histoPanel);


        // Histogram Variable 1
        histogramModelXValue = new HistogramModel(selectedItem);
        drawingPanelX = new HistogramPanel(histogramModelXValue);
        drawingPanelX.setBackground(Color.WHITE);
        drawingPanelX.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));


        // Histogram Variable 2
        histogramModelYValue = new HistogramModel(selectedItem2);
        drawingPanelY = new HistogramPanel(histogramModelYValue);
        drawingPanelY.setBackground(Color.WHITE);
        drawingPanelY.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        this.selectedVariable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedItem = (Variable) selectedVariable.getSelectedItem();
                drawingScatterPlotPanel.setVariable(selectedItem);
                histogramModelXValue = new HistogramModel(selectedItem);
                drawingPanelX.setAxis(histogramModelXValue);
                getTopLevelAncestor().repaint();
            }
        });
        this.secondselectedVariable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedItem2 = (Variable) secondselectedVariable.getSelectedItem();
                drawingScatterPlotPanel.setVariable2(selectedItem2);
                histogramModelYValue = new HistogramModel(selectedItem2);
                drawingPanelY.setAxis(histogramModelYValue);
                getTopLevelAncestor().repaint();
            }
        });


        histoPanel.add(drawingPanelX);
        histoPanel.add(drawingPanelY);


    }

}
