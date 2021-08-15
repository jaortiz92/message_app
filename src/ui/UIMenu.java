package ui;

import model.Message;
import model.MessageService;
import model.User;
import model.UserService;

import java.sql.Connection;
import java.util.Scanner;


public class UIMenu {

    public static final View view = new ViewTerminal();
    public static User userLogged;

    public static void showMainMenu(){
        int option = 0;

        do {
            String show = "__________________" +
                        "\n\t\tRed Social" +
                        "\n\t1. Sign in" +
                        "\n\t2. Sign up" +
                        "\n\t3. Exit" +
                        "\n__________________";
            option = view.readInteger(show);

            switch (option){
                case 1:
                    userLogged = UserService.logIn();
                    showMenuFirth();
                    break;
                case 2:
                    UserService.createUser();
                    break;
                case 3:
                    view.show("Good bye!!!");
                    break;
                default:
                    view.show(option + " it's not a correct option");
                    break;
            }
        } while (option != 3);
    }

    public static void showMenuFirth(){
        int option = 0;

        do {
            String show = "__________________" +
                        "\nHello " + userLogged.getNameUser() +
                        "\n\tHave a great day!!!" +
                        "\n\t1. Look Messages" +
                        "\n\t2. Look Users" +
                        "\n\t3. Log out" +
                        "\n\t__________________";

            option = view.readInteger(show);

            switch (option) {
                case 1:
                    showMenuMessages();
                    break;
                case 2:
                    showMenuUsers();
                    break;
                case 3:
                    break;
                default:
                    view.show(option + " it's not a correct option");
                    break;

            }
        } while (option != 3);
    }

    public static void showMenuMessages(){
        int option = 0;

        do {
            String show = "__________________" +
                        "\n\t\tMenu of messages" +
                        "\n\t1. Create message" +
                        "\n\t2. List messages" +
                        "\n\t3. Edit message" +
                        "\n\t4. Delete message" +
                        "\n\t5. Exit" +
                        "\n__________________";

            option = view.readInteger(show);

            switch (option) {
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.editMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                case 5:
                    break;
                default:
                    view.show(option + " it's not a correct option");
                    break;
            }
        } while (option != 5);
    }

    public static void showMenuUsers(){
        int option = 0;

        do {
            String show = "__________________" +
                        "\n\t\tMenu of users" +
                        "\n\t1. Edit profile" +
                        "\n\t2. Look users" +
                        "\n\t3. Exit";

            option = view.readInteger(show);

            switch (option) {
                case 1:
                    UserService.editUser(userLogged);
                    break;
                case 2:
                    UserService.listUsers();
                    break;
                case 3:
                    break;
            }

        } while (option != 3);
    }
}
