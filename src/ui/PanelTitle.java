package ui;

import javax.swing.*;
import java.awt.*;

public class PanelTitle extends JPanel {

    private static final String TITLE = "Message APP";

    public PanelTitle(){
        setBackground(Color.LIGHT_GRAY);
        addTitle();
        setVisible(true);
    }

    public void addTitle(){
        JLabel title = new JLabel(TITLE, JLabel.CENTER);
        title.setBackground(Color.DARK_GRAY);
        title.setFont(new Font("arial", Font.BOLD, 30));
        add(title);
    }

}
