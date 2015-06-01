import gui.MainFrame;
import gui.MainPanel;
import model.ColumnorientedDataLoader;
import model.DataLoader;
import model.DataModel;
import model.LineorientedDataLoader;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
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

        }


        DataLoader loader= null;


        if ( formatTester(name)=="txt")
        {
            loader= new ColumnorientedDataLoader();
        }

        else if( formatTester(name)=="lin")
        {
            loader = new LineorientedDataLoader();
        }
        else if( formatTester(name)=="null")
        {
            JOptionPane.showMessageDialog(null,"Falsche Datei, Unterstuetzt nur \".lin\" und \".txt\"-Dateien","Wrong File",JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Es wurde keine Datei ausgewaehlt","None File",JOptionPane.WARNING_MESSAGE);
        }
        DataModel dataModel=null;

        if( loader != null)
        {
            dataModel= loader.loadDataModel(selectedFile);
            // generate Frame
            JFrame frame= new MainFrame(dataModel);
            frame.setTitle(name);
            frame.setVisible(true);
        }
        else{

            }





    }

    public static String formatTester(String file) {
        String endung = "";


        if (file.endsWith("txt")) {
            endung = "txt";


        } else if (file.endsWith("lin")) {
            endung = "lin";

        }
        else if(file.length()!=0){
            endung="null";
        }




        return endung;
    }
}

