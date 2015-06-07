package model;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 2015.
 */
public interface DataLoader {
    DataModel loadDataModel(File file) throws FileNotFoundException;

}
