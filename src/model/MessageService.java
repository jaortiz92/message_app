package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    public static final View view = new ViewTerminal();

    public static void createMessage(){
        String text_message = view.readString("Write the message:");
        String author_message = view.readString("Your name: ");
        String date_message = view.readString("Date (2020/12/31): ");

        Message message = new Message(text_message, author_message, date_message);
        MessageDAO.createMessageDB(message);
    }

    public static void listMessage(){

        ArrayList<Message> results = new ArrayList<>();
        results = MessageDAO.readMessageDB();
        for (Message result: results){
            view.show(result.toString() + "\n");
        }
    }

    public static void deleteMessage(){

        int id_message;
        id_message = view.readInteger("Insert message's id to delete");
        MessageDAO.deleteMessageDB(id_message);
    }

    public static void editMessage(){

        int id_message = view.readInteger("Write id to change: ");
        String text_message = view.readString("Write the message: ");
        String author_message = view.readString("Your name: ");
        String date_message = view.readString("Date (2020/12/31): ");

        Message message = new Message(text_message, author_message, date_message, id_message);
        MessageDAO.updateMessageDB(message);
    }
}
