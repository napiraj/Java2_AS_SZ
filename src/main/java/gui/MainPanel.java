package gui;

import model.DataLoader;
import model.DataModel;
import model.Variable;
import model.*;

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

    static ArrayList<String> name;
    static double countVariable;
    static ArrayList<Double> valueVariable;

    public MainPanel() {

        DataModel model1 = new DataModel(name, countVariable, valueVariable);

        JPanel panel = new JPanel();


        ArrayList<Double> valuesX= new ArrayList<Double>(valueVariable);

        Histogram drawingVariable1 = new Histogram(valuesX);
      //  Histogram drawingVariable2 = new Histogram(valuesY);
        setLayout(new BorderLayout());
        panel.add(drawingVariable1);
      //  panel.add(drawingVariable2);
    }
}
