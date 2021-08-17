package ui;

import javax.swing.*;

public class ViewWindow implements View {

    @Override
    public Integer readInteger(String message) {
        String aux = JOptionPane.showInputDialog(message);
        Integer value = Integer.valueOf(aux);
        return value;
    }

    @Override
    public String readString(String message) {
        String aux = JOptionPane.showInputDialog(message);
        return aux;
    }

    @Override
    public void show(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
