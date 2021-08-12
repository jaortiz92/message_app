import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String pass = JOptionPane.showInputDialog("Password");

        Connections connection = new ConnectionPostgreSQL(pass);
        Connection connect = connection.get_connection();


    }
}
