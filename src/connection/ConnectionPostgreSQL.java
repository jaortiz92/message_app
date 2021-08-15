package connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ui.*;

public class ConnectionPostgreSQL implements Connections{
    private Connection connection;
    private String rute;
    private String user;
    private String pass;
    public static final View view = new ViewTerminal();

    public ConnectionPostgreSQL(String user, String pass){
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
