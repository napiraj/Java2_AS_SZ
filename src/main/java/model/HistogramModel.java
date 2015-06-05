package model;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by Alexandra on 27.05.2015.
 *
 * Bekommen eine Liste von Werten--> in Klassen einteilen, h�he ver�ndern
 */
public class HistogramModel {
    private double countClasses;
    private ArrayList<Integer> counterValues;



    public HistogramModel( Variable varHistogram1){
        if(varHistogram1==null) {
            return;
        }

       ArrayList<Double> values1= new ArrayList<Double>();
       this.counterValues = new ArrayList<Integer>();

       values1=varHistogram1.getValues();


        this.countClasses=Math.round((double) ((Math.sqrt(values1.size()))));
        double diffMaxMin =Math.ceil((double)varHistogram1.getMax()- varHistogram1.getMin());// rundet immer auf
        double belowclass=varHistogram1.getMin();
        double smallest=varHistogram1.getMin();
        double upperclass=0;
        double realClassWidth=diffMaxMin /countClasses;
        int counter=0;

            int a=0;

        for(int i=0; i< countClasses;i++){
            upperclass = belowclass+realClassWidth+0.01;
            belowclass=belowclass-0.01;

            while(a<(values1.size()) ){

                if((values1.get(a)<upperclass) && (values1.get(a)>belowclass)){
                counter++;
                }
                a++;

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



    public double getHighestBar(){
        double highestBar= counterValues.get(0);

        for (int i= 1; i<counterValues.size();i++) {
            if (counterValues.get(i) > highestBar) {
                highestBar =counterValues.get(i);

            }
        }

        return highestBar;
    }



}
