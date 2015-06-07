package model;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 2015.
 */
public class HistogramModel {
    private double countClasses;
    private ArrayList<Integer> counterValues;
    //private String nameOfHistogramVariable;
    private ArrayList<Double> values1;
    private Variable varHistogram;


    public HistogramModel(Variable varHistogram) {

        this.varHistogram = varHistogram;
        if (varHistogram == null) {
            System.out.println("Error");
            System.exit(-1);
        }


        this.counterValues = new ArrayList<Integer>();


        this.values1 = varHistogram.getValues();


        this.countClasses = Math.round((Math.sqrt(values1.size())));

        // round up
        double diffMaxMin = Math.ceil(varHistogram.getMax() - varHistogram.getMin());
        double lowerLimitOfClass = varHistogram.getMin();
        double upperLimitOfClass;
        double realClassWidth = diffMaxMin / countClasses;
        int counter = 0;

        int a = 0;

        for (int i = 0; i < countClasses; i++) {
            upperLimitOfClass = lowerLimitOfClass + realClassWidth + 0.01;
            lowerLimitOfClass = lowerLimitOfClass - 0.01;

            while (a < (values1.size())) {

                if ((values1.get(a) < upperLimitOfClass) && (values1.get(a) > lowerLimitOfClass)) {
                    counter++;
                }
                a++;

            }
            counterValues.add(counter);

            a = 0;
            counter = 0;

            lowerLimitOfClass = upperLimitOfClass;

        }
    }


    public double getCountClasses() {
        return countClasses;
    }

    public String getNameOfHistogramVariable() {
        String nameOfHistogramVariable = varHistogram.getName();
        return nameOfHistogramVariable;
    }

    public ArrayList<Integer> getCounterValues() {
        return this.counterValues;

    }

    public double getHighestBar() {
        double highestBar = counterValues.get(0);

        for (int i = 1; i < counterValues.size(); i++) {
            if (counterValues.get(i) > highestBar) {
                highestBar = counterValues.get(i);

            }
        }

        return highestBar;
    }

}