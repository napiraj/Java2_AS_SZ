import gui.MainFrame;
import gui.MainPanel;
import model.ColumnorientedDataLoader;
import model.DataLoader;
import model.DataModel;
import model.LineorientedDataLoader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT & LIN Files","txt","lin");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,"Es wurde keine Datei ausgewaehlt","None File",JOptionPane.WARNING_MESSAGE);

                    }

        Scanner fileScanner = null;
        File selectedFile= null;


       if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            try {
                fileScanner = new Scanner(selectedFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace(); // schöne Ausgabe machen. System.exit -1
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

        DataModel dataModel=null;

        if( loader != null)
            {
                dataModel= loader.loadDataModel(selectedFile);
                // generate Frame
                JFrame frame= new MainFrame(dataModel);
                frame.setTitle(name);
                frame.setVisible(true);
            }





    }

    public static String formatTester(String file) {
        String endung = "";


        if (file.endsWith("txt")) {
            endung = "txt";


        } else if (file.endsWith("lin")) {
            endung = "lin";

        }
         return endung;
    }
}

