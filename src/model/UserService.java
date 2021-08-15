package model;


import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;
import java.util.ArrayList;

public class UserService {
    public static final View view = new ViewTerminal();

    public static void createUser(){

    }

    public static ArrayList<User> listUsers(){
        ArrayList<User> listUsers = new ArrayList<>();
        return listUsers;
    }

    public static void editUser(User user){

    }

    public static User logIn(){
        User user;
        user = new User("", "", "");
        return user;
    }

    public static String codePassword(String password){
        String md5Hex;
        return password;
    }
}
