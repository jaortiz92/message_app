package model;


import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;
import java.util.ArrayList;

public class UserService {
    public static final View view = new ViewTerminal();

    public static void createUser(){
        String email = view.readString("Insert email: ");
        String name = view.readString("Insert name: ");
        String passwordUser = view.readString("Insert password: ");
        User user = new User(email, passwordUser, name);
        UserDAO.crateUserDB(user);
    }

    public static void listUsers(){
        ArrayList<User> listUsers = UserDAO.readUsersDB();
        for(User user: listUsers){
            view.show(user.toString());
        }
    }

    public static void editUser(User user){
        user.setNameUser(view.readString("Insert new name"));
        user.setEmail(view.readString("Insert new email"));
        user.setPasswordUser(view.readString("Insert new password"));
        UserDAO.editUserDB(user);
    }

    public static User logIn(){
        User user;
        int attempt = 0;
        String password = "";

        do {
            String email = view.readString("Insert email: ");
            password = view.readString("Insert password: ");
            user = UserDAO.searchUser(email);
            attempt ++;
        } while ((!user.getPasswordUser().equalsIgnoreCase(password)) && (attempt <= 3));

        if (!user.getPasswordUser().equalsIgnoreCase(password)){
            user = null;
        }
        return user;
    }

    public static String codePassword(String password){
        String md5Hex;
        return password;
    }
}
