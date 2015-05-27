package gui;

import model.DataLoader;
import model.DataModel;
import model.Variable;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Alexandra on 20.05.2015.
 */
public class MainPanel extends JPanel {
    public MainPanel() {
        ArrayList<Double> values= new ArrayList<Double>();
        values= DataModel.getValue1();
        values.add(getValue1());
        Histogram drawingPanel = new Histogram(values);
        setLayout(new BorderLayout());
        add(drawingPanel);
    }
}
