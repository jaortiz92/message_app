package connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ui.*;

public class ConnectionPostgreSQL implements Connections{
    Connection connection;
    String rute;
    String user;
    String pass;
    View view;

    public ConnectionPostgreSQL(String user, String pass){
        view = new ViewTerminal();
        connection = null;
        rute = "jdbc:postgresql://localhost:5432/message_app";
        this.user = user;
        this.pass = pass;
    }


    @Override
    public Connection get_connection() {
        try {
            connection = DriverManager.getConnection(rute, user, pass);
        } catch (SQLException e) {
            view.show("Error de coneccion " + e);
        }
        return connection;
    }
}
