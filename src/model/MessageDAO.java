package model;

import connection.ConnectionPostgreSQL;
import connection.Connections;
import ui.View;
import ui.ViewTerminal;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
    public static void createMessageDB(Message message, Connection connection){
        View view = new ViewTerminal();

        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO messages (text_message, author_message, date_message) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, message.getText_message());
            ps.setString(2, message.getAuthor_message());
            ps.setDate(3, (Date) message.getDate_message());
            ps.executeUpdate();
            view.show("Massage created");

        } catch (SQLException e) {
            view.show("Error " + e);
        }

    }

    public static void readMessageDB(){

    }

    public static void deleteMessageDB(int id_message){

    }

    public static void updateMessageDB(Message message){

    }
}
