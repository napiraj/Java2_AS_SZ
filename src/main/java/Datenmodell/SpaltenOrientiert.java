package Datenmodell;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Bina on 06.05.2015.
 */
public class SpaltenOrientiert implements Datenmodell
{

    @Override
    public ArrayList<String> getVariableName()
    {
        ArrayList<String> sortiert = new ArrayList<String>();
        while (in.hasNextLine) {
            String variableName = in.nextLine();
            int i = 0;

            while (!Character.isWhitespace(variableName.charAt(i)))
            {
                i++;
            }

            sortiert.add(variableName.substring(0, i));
            sortiert.add(variableName.substring(i));

        }
        return sortiert;
    }

    @Override
    public double getVariableValue()
    {

        return 0;
    }

    @Override
    public double getMaxValue() {
        return 0;
    }

    @Override
    public double getMinValue() {
        return 0;
    }

    @Override
    public double getQuantityValue() {
        return 0;
    }

    @Override
    public double stufenHistogramm() {
        return 0;
    }
}
