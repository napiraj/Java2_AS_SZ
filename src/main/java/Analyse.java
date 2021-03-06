import gui.MainFrame;
import model.ColumnorientedDataLoader;
import model.DataLoader;
import model.DataModel;
import model.LineorientedDataLoader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 2015.
 */
public class Analyse {

    public static void main(String[] args) {
        String name = "";

        //File Chooser
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT & LIN Files","txt","lin");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,"No File selected","No File",JOptionPane.WARNING_MESSAGE);

                    }

        Scanner fileScanner = null;
        File selectedFile= null;


       if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            try {
                fileScanner = new Scanner(selectedFile);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File exists no longer"+e.getMessage(), "No File", JOptionPane.WARNING_MESSAGE);
                 System.exit(-1);
            }

            name = selectedFile.getName();

        }


        DataLoader loader= null;


        if (Objects.equals(formatTester(name), "txt"))
        {
            loader= new ColumnorientedDataLoader();
        }

        else if(Objects.equals(formatTester(name), "lin"))
        {
            loader = new LineorientedDataLoader();
        }

        DataModel dataModel=null;

        if( loader != null)
            {
                try {
                    dataModel= loader.loadDataModel(selectedFile);
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "File cannot be read"+ e.getMessage(), "None File", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

                // generate Frame
                JFrame frame= new MainFrame(dataModel);
                frame.setTitle(name);
                frame.setVisible(true);
            }

    }

    private static String formatTester(String file) {
        String endung = "";


        if (file.endsWith("txt")) {
            endung = "txt";


        } else if (file.endsWith("lin")) {
            endung = "lin";

        }
         return endung;
    }
}

