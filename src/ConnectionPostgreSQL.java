import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL implements Connections{
    Connection connection;
    String rute;
    String user;
    String pass;

    public ConnectionPostgreSQL(String pass){

        connection = null;
        rute = "jdbc:postgresql://localhost:5432/message_app";
        user = "postgres";
        this.pass = pass;
    }


    @Override
    public Connection get_connection() {
        try {
            connection = DriverManager.getConnection(rute, user, pass);
            JOptionPane.showMessageDialog(null, "Base de datos conectada con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de coneccion " + e);
        }
        return connection;
    }
}
