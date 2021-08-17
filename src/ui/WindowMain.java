package ui;

import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame {

    private PanelTitle panelTitle;
    private PanelMain panel;


    public WindowMain(){
        setSize(800, 600);
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(2,2));

        startComponents();
        setTitle("Message App");
        setResizable(true);
        //setLocationRelativeTo(null); //Centrar
        setVisible(true);
    }

    public void startComponents(){

        panelTitle = new PanelTitle();
        getContentPane().add(panelTitle, BorderLayout.NORTH);

        panel = new PanelMain();
        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
