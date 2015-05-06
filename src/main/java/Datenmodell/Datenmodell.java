package Datenmodell;

import java.util.ArrayList;

/**
 * Created by Bina on 06.05.2015.
 */
public interface Datenmodell
{

    public ArrayList<String> getVariableName();


    public double getVariableValue();


    public double getMaxValue();


    public double getMinValue();


    public double getQuantityValue();

    public double stufenHistogramm();
}
