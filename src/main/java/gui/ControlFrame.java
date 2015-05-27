package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bina on 25.05.2015.
 */
public class ControlFrame extends JFrame{

    private final int FRAME_WIDTH = 200;
    private final int FRAME_HEIGHT = 200;

    public ControlFrame()

    {
        setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center on screen

    }

}
