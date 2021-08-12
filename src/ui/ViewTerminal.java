package ui;

import java.util.Scanner;

public class ViewTerminal implements  View{
    Scanner sc;

    public ViewTerminal() {
        sc = new Scanner(System.in);
    }

    @Override
    public Integer readInteger(String message) {
        System.out.println(message);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    @Override
    public String readString(String message) {
        System.out.println(message);
        String option = sc.nextLine();
        return option;
    }

    @Override
    public void show(String message){
        System.out.println(message);
    }

}
