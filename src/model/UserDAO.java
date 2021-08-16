package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    public static final connection.Connections connection = new connection.ConnectionPostgreSQL("usermessageapp","messagePlatzi");
    public static final Connection connect = connection.get_connection();
    public static final View view = new ViewTerminal();

    public static void crateUserDB(User user){
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO users (email, password_user, name_user) VALUES (?, ?, ?)";
            ps = connect.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordUser());
            ps.setString(3, user.getNameUser());
            // Actualizar datos en la DB
            ps.executeUpdate();
            view.show("User created");
        } catch (SQLException e) {
            view.show("Error " + e);
        }
    }

    public static ArrayList<User> readUsersDB(){
        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<User> resultUsers = new ArrayList<>();

        try {
            String query = "SELECT * FROM users";
            ps = connect.prepareStatement(query);
            // Ejecutar queries datos en la DB
            result = ps.executeQuery();

            while (result.next()){
                resultUsers.add(new User(
                        result.getInt("id_user"),
                        result.getString("email"),
                        result.getString("password_user"),
                        result.getString("name_user")
                ));
            }
        } catch (SQLException e) {
            view.show("Error " + e);
        }
        return resultUsers;
    }

    public static User searchUser(String email){
        PreparedStatement ps = null;
        ResultSet result = null;
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE email = ?";
            ps = connect.prepareStatement(query);
            ps.setString(1, email);
            result = ps.executeQuery();

            while (result.next()) {
                user = new User(result.getInt("id_user"),
                        result.getString("email"),
                        result.getString("password_user"),
                        result.getString("name_user"));
            }

        } catch (SQLException e) {
            view.show("Error " + e);
        }
        return user;
    }

    public static void editUserDB(User user){
        PreparedStatement ps = null;
        try {
            String query = "UPDATE user SET email = ?, password_user = ?, name_user = ? WHERE id_user = ?";
            ps = connect.prepareStatement(query);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordUser());
            ps.setString(3, user.getNameUser());
            ps.setInt(4, user.getId_user());

            int countRowsUpdate = ps.executeUpdate();
            if (countRowsUpdate != 0){
                view.show("User updated");
            }  else {
                view.show("ID: " + user.getNameUser() + " was not found");
            }

        } catch (SQLException e) {
            view.show("User does not updated");
            view.show("Error " + e);
        }
    }

}
