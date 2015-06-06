package model;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Alexandra Stümer und Sabrina Zgragen LST VZ 2013 on 12.05.2015.
 */
public interface DataLoader {
    DataModel loadDataModel(File file) throws FileNotFoundException;

}
