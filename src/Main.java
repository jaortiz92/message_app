import javax.swing.*;
import java.sql.*;

import static ui.UIMenu.*;
import connection.*;
import model.Message;

public class Main {
    public static void main(String[] args) {


        String pass = JOptionPane.showInputDialog("Password");
        connection.Connections connection = new connection.ConnectionPostgreSQL(pass);
        Connection connect = connection.get_connection();

        showMenu(connect);
    }
}
