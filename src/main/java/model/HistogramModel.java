package model;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by Alexandra on 27.05.2015.
 *
 * Bekommen eine Liste von Werten--> in Klassen einteilen, h�he ver�ndern
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
    private double smallest;
    private double quantityOfList;


    public HistogramModel( Variable varHistogram1){

       this.values1= new ArrayList<Double>();
       this.counterValues = new ArrayList<Integer>();

       this.values1=varHistogram1.getValue();



        this.countClasses=Math.round((double) ((Math.sqrt(values1.size()))));
        this.classWidth=varHistogram1.getMax()- varHistogram1.getMin();
        this.belowclass=varHistogram1.getMin();
        this.smallest=varHistogram1.getMin();
        this.upperclass=0;
        this.realClassWidth=classWidth/countClasses;
        this.counter=1;

        //Collections.sort(values1);


            int a=0;

        for(int i=0; i< countClasses;i++){
            this.upperclass = belowclass+realClassWidth+0.01;

            while(a<(values1.size()-1) ){
                a++;
                if((values1.get(a)<upperclass) && (values1.get(a)>=belowclass)){
                counter++;
                }

            }
            counterValues.add(counter);

            a=0;
            counter=0;

            belowclass=upperclass;


        }
    }


    public double getCountClasses()
    {
        return countClasses;
    }

    public int getCounterValues(int index){
        return this.counterValues.get(index);



    }

    public double getQuantityOfList(){
        quantityOfList =values1.size();
        return quantityOfList;
    }



}
