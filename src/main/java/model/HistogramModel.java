package model;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

/**
 * Created by Alexandra on 27.05.2015.
 *
 * Bekommen eine Liste von Werten--> in Klassen einteilen, höhe verändern
 */
public class HistogramModel {
    private ArrayList<Double> values1 ;
    private ArrayList<Double> values2;
    private double countClasses;
    private double classWidth;
    private double belowclass;
    private double upperclass;
    private double realClassWidth;
    private int counter;
    private ArrayList<Integer> counterValues;



    public HistogramModel( Variable variable1, Variable variable2){
        values1= new ArrayList<Double>();
        values2= new ArrayList<Double>();
        counterValues = new ArrayList<Integer>();

        values1=variable1.getValue();
        values2=variable2.getValue();
        countClasses=Math.round((double) ((Math.sqrt(values1.size()))));
        classWidth=variable1.getMax()-variable1.getMin();
        belowclass=variable1.getMin();
        upperclass=0;
        realClassWidth=classWidth/countClasses;
        counter=0;

        Collections.sort(values1);
        Collections.sort(values2);
        int a=0;
        for(int i=0; i< countClasses;i++){
            upperclass= belowclass+realClassWidth;

            while(values1.get(a)<upperclass ){
                a++;
                counter++;

            }

            counterValues.add(counter);
            counter=0;

            belowclass=upperclass;

        }


    }

    public double getCountClasses()
    {
        return countClasses;
    }

    public int getCounterValues(int index){
        return counterValues.get(index);

    }


}
