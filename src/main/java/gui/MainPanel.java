package gui;

import model.DataModel;
import model.HistogramModel;
import model.Variable;

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
    private Variable selectedItem;
    private JComboBox secondselectedVariable;
    private Variable selectedItem2;
    private Histogram drawingPanelX;
    private Histogram drawingPanelY;
    private HistogramModel histogramModelXValue;
    private HistogramModel histogramModelYValue;

    public MainPanel(DataModel dataModel) {

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);


        //getTopLevelAncestor().repaint(); ruft das Frame auf um alles neu zu zeichnen

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
        this.drawingScatterPlot = new ScatterPlot(selectedItem, selectedItem2);
        scatterPanel.add(drawingScatterPlot);


        // select first Variable
        this.selectedVariable = new JComboBox<Variable>();

        for (Variable var : dataModel.getAllVariable()) {
            selectedVariable.addItem(var);
        }

        this.selectedVariable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedItem = (Variable) selectedVariable.getSelectedItem();
                drawingScatterPlot.setVariable(selectedItem);
                // histogramModelXValue.setVariableOfHistogramm(selectedItem); funktioniert nicht!!
            }
        });

        selectedVariable.setSelectedItem(dataModel.getAllVariable().get(0));
        buttonPanel.add(selectedVariable);

        // select second Variable
        this.secondselectedVariable = new JComboBox<Variable>();

        for (Variable var : dataModel.getAllVariable()) {
            secondselectedVariable.addItem(var);
        }

        this.secondselectedVariable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedItem2 = (Variable) secondselectedVariable.getSelectedItem();
                drawingScatterPlot.setVariable2(selectedItem2);
                //histogramModelYValue.setVariableOfHistogramm(selectedItem2); funktioniert nicht!!

            }
        });

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
                  drawingScatterPlot.setDotSize(selectedSize);

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

                drawingScatterPlot.setDrawLine(lineButton.isSelected());
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
                              drawingScatterPlot.setDotColor(dotColor);
                        }
             }
        });

        buttonPanel.add(colorButton);

        JPanel histoPanel = new JPanel();
        histoPanel.setLayout(new BoxLayout(histoPanel, BoxLayout.LINE_AXIS));
        histoPanel.setBackground(Color.CYAN);
        scatterPanel.add(histoPanel);

        JLabel titelHistogrammVariable = new JLabel(String.valueOf(selectedItem));
        JLabel titelHistogrammVariable2 = new JLabel(String.valueOf(selectedItem2));

        // Histogram Valriable 1
        histogramModelXValue = new HistogramModel(selectedItem);
        drawingPanelX = new Histogram(histogramModelXValue);
        drawingPanelX.setBackground(Color.WHITE);
        drawingPanelX.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        drawingPanelX.add(titelHistogrammVariable);

        // Histogram Variable 2
        histogramModelYValue = new HistogramModel(selectedItem2);
        drawingPanelY = new Histogram(histogramModelYValue);
        drawingPanelY.setBackground(Color.WHITE);
        drawingPanelY.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        drawingPanelY.add(titelHistogrammVariable2);


        histoPanel.add(drawingPanelX);
        histoPanel.add(drawingPanelY);


    }
}
