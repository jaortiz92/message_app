package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    public static void createMessage(Connection connection){
        View view = new ViewTerminal();
        String text_message = view.readString("Write the message:");
        String author_message = view.readString("Your name: ");
        String date_message = view.readString("Date (2020/12/31): ");

        Message message = new Message(text_message, author_message, date_message);
        MessageDAO.createMessageDB(message, connection);
    }

    public static void listMessage(Connection connection){
        View view = new ViewTerminal();

        ArrayList<Message> results = new ArrayList<>();
        results = MessageDAO.readMessageDB(connection);
        for (Message result: results){
            view.show(result.toString() + "\n");
        }
    }

    public static void deleteMessage(Connection connection){
        View view = new ViewTerminal();

        int id_message;
        id_message = view.readInteger("Insert message's id to delete");
        MessageDAO.deleteMessageDB(id_message, connection);
    }

    public static void editMessage(Connection connection){
        View view = new ViewTerminal();
        int id_message = view.readInteger("Write id to change: ");
        String text_message = view.readString("Write the message: ");
        String author_message = view.readString("Your name: ");
        String date_message = view.readString("Date (2020/12/31): ");

        Message message = new Message(text_message, author_message, date_message, id_message);
        MessageDAO.updateMessageDB(message, connection);
    }
}
