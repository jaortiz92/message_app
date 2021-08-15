package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;

public class UserDAO {

    public static final connection.Connections connection = new connection.ConnectionPostgreSQL("usermessageapp","messagePlatzi");
    public static final Connection connect = connection.get_connection();
    public static final View view = new ViewTerminal();

    public static void crateUserDB(User user){

    }

    public static void readUserDB(){

    }

    public static void editUserDB(){

    }

    public static void logIn(){

    }
}
