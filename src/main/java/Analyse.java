import Datamodel.ColumnorientedDataLoader;
import Datamodel.DataLoader;
import Datamodel.DataModel;
import Datamodel.LineorientedDataLoader;
import Datamodel.Variable;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandra on 12.05.2015.
 */
public class Analyse {

    public static void main(String[] args) {
        String name = "";
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        Scanner fileScanner = null;
        File selectedFile= null;


        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            try {
                fileScanner = new Scanner(selectedFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            name = selectedFile.getName();

            System.out.println(formatTester(name));

        }


        DataLoader loader= null;


        if ( formatTester(name)=="txt"){
            System.out.println("hier kommt das spaltenorientiertes java programm rein");

            loader= new ColumnorientedDataLoader();
            System.out.println(loader);




        }

        else if( formatTester(name)=="lin")
        {
            System.out.println("hier kommt ein zeilenorientiertes java programm");

            loader = new LineorientedDataLoader();

        }

        if( loader != null)
        {
            DataModel format= loader.loadDataModel(selectedFile);


            System.out.println(format.getName() + format.getWerte());


        }




    }

    public static String formatTester(String file) {
        String endung = "";


        if (file.endsWith("txt")) {
            endung = "txt";
            //Spaltenorientiert test

        } else if (file.endsWith("lin")) {
            endung = "lin";


        }


        return endung;
    }
}
