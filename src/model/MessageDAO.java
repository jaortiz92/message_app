package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.*;
import java.util.ArrayList;

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
            // Actualizar datos en la DB
            ps.executeUpdate();
            view.show("Massage created");

        } catch (SQLException e) {
            view.show("Error " + e);
        }

    }

    public static ArrayList<Message> readMessageDB(Connection connection){
        View view = new ViewTerminal();

        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Message> resultMessages = new ArrayList<>();

        try {
            String query = "SELECT * FROM messages";
            ps = connection.prepareStatement(query);
            // Ejecutar queries datos en la DB
            result = ps.executeQuery();

            while (result.next()){
                resultMessages.add(new Message(
                        result.getInt("id_message"),
                        result.getString("text_message"),
                        result.getString("author_message"),
                        result.getString("date_message")
                ));
            }
        } catch (SQLException e) {
            view.show("Error " + e);
        }
        return resultMessages;
    }

    public static void deleteMessageDB(int id_message, Connection connection){
        View view = new ViewTerminal();

        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Message> resultMessages = new ArrayList<>();

        try {
            String query = "DELETE FROM messages WHERE id_message = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_message);

            int countRowsUpdate = ps.executeUpdate();
            if (countRowsUpdate != 0){
                view.show("Message eliminated");
            }  else {
                view.show("ID: " + id_message + " was not found");
            }


        } catch (SQLException e) {
            view.show("Massage does not eliminate");
            view.show("Error " + e);
        }

    }

    public static void updateMessageDB(Message message){

    }
}
