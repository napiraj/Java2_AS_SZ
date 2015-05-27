package gui;

import model.DataModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bina on 20.05.2015.
 */
public class ControlFrame extends JFrame{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    public ControlFrame(DataModel data) {

        {
            createComponents();
            setSize(FRAME_WIDTH, FRAME_HEIGHT);
            setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setTitle("Hier kommt der Name der Datei hin: ");
        }

    }


    private void createComponents()
    {
        JPanel panel1 = new MainPanel();
        JButton button = new JButton("Hallo");
        panel1.add(button);


    }

}
