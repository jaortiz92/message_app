package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    public static final View view = new ViewTerminal();

    public static void createMessage(User user){
        String text_message = view.readString("Write the message:");
        int author_message = user.getId_user();
        String date_message = view.readString("Date (2020/12/31): ");

        Message message = new Message(text_message, author_message, date_message);
        MessageDAO.createMessageDB(message);
    }

    public static void listMessage(){
        ArrayList<Message> results;
        results = MessageDAO.readMessageDB();
        for (Message result: results){
            view.show(result.toString() + "\n");
        }
    }

    public static void listMessage(boolean myMessages, User user){

        ArrayList<Message> results;
        results = MessageDAO.readMyMessageDB(user);

        for (Message result: results){
            view.show(result.toString() + "\n");
        }
    }


    public static void deleteMessage(User user){

        boolean myMessage = false;
        int id_message;
        do {
            id_message = view.readInteger("Insert message's id to delete: ");
            if (MessageDAO.searchIdUserMessage(id_message) == user.getId_user()){
                myMessage = true;
            } else {
                view.show("That Id message is not owned by " + user.getNameUser());
            }
        } while (!myMessage);

        MessageDAO.deleteMessageDB(id_message);
    }

    public static void editMessage(User user){

        boolean myMessage = false;
        int id_message;
        do {
            id_message = view.readInteger("Write id to change: ");
            if (MessageDAO.searchIdUserMessage(id_message) == user.getId_user()){
                myMessage = true;
            } else {
                view.show("That Id message is not owned by " + user.getNameUser());
            }
        } while (!myMessage);


        String text_message = view.readString("Write the message: ");
        String author_message = user.getNameUser();
        String date_message = view.readString("Date (2020/12/31): ");

        Message message = new Message(text_message, author_message, date_message, id_message);
        MessageDAO.updateMessageDB(message);
    }
}
