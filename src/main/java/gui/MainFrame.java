package gui;

import model.DataModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 25.05.2015.
 * Design des Frames
 */
public class MainFrame extends JFrame{

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 400;

    public MainFrame(DataModel dataModel)

    {
        setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center on screen

        MainPanel mainPanel = new MainPanel(dataModel);
        add(mainPanel);


    }



}
