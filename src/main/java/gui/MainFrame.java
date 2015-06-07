package gui;

import model.DataModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexandra Stümer und Sabrina Zgraggen LST VZ 2013 on 2015.
 * Frame Layout
 */
public class MainFrame extends JFrame{

    public MainFrame(DataModel dataModel)

    {
        int FRAME_WIDTH = 400;
        int FRAME_HEIGHT = 400;
        setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center on screen
        this.setLocationRelativeTo(null);

        MainPanel mainPanel = new MainPanel(dataModel);
        add(mainPanel);

    }
}
