package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.*;
import java.util.ArrayList;

public class MessageDAO {

    public static final connection.Connections connection = new connection.ConnectionPostgreSQL("usermessageapp","messagePlatzi");
    public static final Connection connect = connection.get_connection();
    public static final View view = new ViewTerminal();

    public static void createMessageDB(Message message){

        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO messages (text_message, id_user, date_message) VALUES (?, ?, ?)";
            ps = connect.prepareStatement(query);
            ps.setString(1, message.getText_message());
            ps.setInt(2, message.getId_user());
            ps.setDate(3, (Date) message.getDate_message());
            // Actualizar datos en la DB
            ps.executeUpdate();
            view.show("Massage created");

        } catch (SQLException e) {
            view.show("Error " + e);
        }

    }

    public static ArrayList<Message> readMessageDB(){

        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Message> resultMessages = new ArrayList<>();

        try {
            String query = "SELECT messages.* , users.name_user FROM messages " +
                    "JOIN users ON messages.id_user = users.id_user";
            ps = connect.prepareStatement(query);
            // Ejecutar queries datos en la DB
            result = ps.executeQuery();

            while (result.next()){
                resultMessages.add(new Message(
                        result.getInt("id_message"),
                        result.getString("text_message"),
                        result.getString("name_user"),
                        result.getString("date_message")
                ));
            }
        } catch (SQLException e) {
            view.show("Error " + e);
        }
        return resultMessages;
    }

    public static ArrayList<Message> readMyMessageDB(User user){

        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Message> resultMessages = new ArrayList<>();

        try {
            String query = "SELECT messages.* , users.name_user FROM messages " +
                            "JOIN users ON messages.id_user = users.id_user " +
                            "WHERE users.id_user = ?";
            ps = connect.prepareStatement(query);
            ps.setInt(1, user.getId_user());
            // Ejecutar queries datos en la DB
            result = ps.executeQuery();

            while (result.next()){
                resultMessages.add(new Message(
                        result.getInt("id_message"),
                        result.getString("text_message"),
                        result.getString("name_user"),
                        result.getString("date_message")
                ));
            }
        } catch (SQLException e) {
            view.show("Error " + e);
        }
        return resultMessages;
    }

    public static void deleteMessageDB(int id_message){

        PreparedStatement ps = null;

        try {
            String query = "DELETE FROM messages WHERE id_message = ?";
            ps = connect.prepareStatement(query);
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

        PreparedStatement ps = null;

        try {
            String query = "UPDATE messages SET text_message = ?, date_message = ? WHERE id_message = ?";
            ps = connect.prepareStatement(query);

            ps.setString(1, message.getText_message());
            ps.setDate(2, message.getDate_message());
            ps.setInt(3, message.getId_message());

            int countRowsUpdate = ps.executeUpdate();
            if (countRowsUpdate != 0){
                view.show("Message updated");
            }  else {
                view.show("ID: " + message.getId_message() + " was not found");
            }


        } catch (SQLException e) {
            view.show("Massage does not updated");
            view.show("Error " + e);
        }
    }

    public static int searchIdUserMessage(int id_message){

        PreparedStatement ps = null;
        int id_user = 0;
        ResultSet result = null;

        try {
          String query = "SELECT id_user FROM messages WHERE id_message = ?";
          ps = connect.prepareStatement(query);
          ps.setInt(1, id_message);

          result = ps.executeQuery();

          while (result.next()){
            id_user = result.getInt("id_user");
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_user;
    }
}
