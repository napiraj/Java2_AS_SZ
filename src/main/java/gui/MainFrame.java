package gui;

import model.DataModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bina on 25.05.2015.
 */
public class MainFrame extends JFrame{

    private final int FRAME_WIDTH = 300;
    private final int FRAME_HEIGHT = 300;

    public MainFrame(DataModel dataModel)

    {
        setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center on screen

        MainPanel mainPanel = new MainPanel(dataModel);
        add(mainPanel);


    }



}
