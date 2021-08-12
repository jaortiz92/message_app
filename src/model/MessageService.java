package model;

import ui.View;
import ui.ViewTerminal;

import java.sql.Connection;
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

    public static void listMessage(){

    }

    public static void deleteMessage(){

    }

    public static void editMessage(){

    }
}
