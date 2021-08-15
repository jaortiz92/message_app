import javax.swing.*;
import java.sql.*;

import static ui.UIMenu.*;
import connection.*;
import model.Message;

public class Main {
    public static void main(String[] args) {


        /*String pass = JOptionPane.showInputDialog("Password");
        connection.Connections connection = new connection.ConnectionPostgreSQL("usermessageapp","messagePlatzi");
        Connection connect = connection.get_connection();*/

        showMainMenu();

        /*Message msg = new Message("Donde estoy", "Tintin", "2021/04/30");
        System.out.println(msg.getDate_message());
        System.out.println(msg.getDate_string_message());
        int year = Integer.valueOf(msg.getDate_string_message().substring(0, 4));
        System.out.println(year);*/

    }
}
