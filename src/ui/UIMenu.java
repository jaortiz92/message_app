package ui;

import model.Message;
import model.MessageService;

import java.sql.Connection;
import java.util.Scanner;


public class UIMenu {


    public static void showMenu(Connection connection){
        View view = new ViewTerminal();

        int option = 0;

        do {
            String show = "__________________" +
                        "\n\t\tApplication of message" +
                        "\n\t1. Create message" +
                        "\n\t2. List messages" +
                        "\n\t3. Edit message" +
                        "\n\t4. Delete message" +
                        "\n\t5. Exit";

            option = view.readInteger(show);

            switch (option) {
                case 1:
                    MessageService.createMessage(connection);
                    break;
                case 2:
                    MessageService.listMessage(connection);
                    break;
                case 3:
                    MessageService.editMessage(connection);
                    break;
                case 4:
                    MessageService.deleteMessage(connection);
                    break;
                case 5:
                    view.show("Good Bye!!!");
                    break;
                default:
                    view.show(option + " it's not a correct option");
                    break;
            }
        } while (option != 5);


    }
}
