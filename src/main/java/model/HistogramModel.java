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
    private double countClasses;
    private double classWidth;
    private double belowclass;
    private double upperclass;
    private double realClassWidth;
    private int counter;
    private ArrayList<Integer> counterValues;


    public HistogramModel( Variable varHistogram1){
        this.values1= new ArrayList<Double>();
        counterValues = new ArrayList<Integer>();

        values1=varHistogram1.getValue();

        countClasses=Math.round((double) ((Math.sqrt(values1.size()))));
        classWidth=varHistogram1.getMax()- varHistogram1.getMin();
        belowclass=varHistogram1.getMin();
        upperclass=0;
        realClassWidth=classWidth/countClasses;
        counter=0;

        Collections.sort(values1);


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
