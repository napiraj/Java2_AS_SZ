package datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alexandra on 12.05.2015.
 */
public class LineorientedDataLoader implements DataLoader{
    public DataModel loadDataModel(File file){

        Scanner inputScanner=null;

        try {
            inputScanner= new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;
        }



        return null;
    }


}