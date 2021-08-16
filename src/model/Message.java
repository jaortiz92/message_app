package model;

import java.sql.Date;

public class Message {
    private int id_message;
    private int id_user;
    private String text_message;
    private String author_message;
    private Date date_message;
    private String date_string_message;


    public Message(String text_message, int id_user, String date_message){
        this.text_message = text_message;
        this.id_user = id_user;
        this.date_string_message = date_message;
        setDate_message(date_message);
    }

    public Message(String text_message, String author_message, String date_message, int id_message){
        this.text_message = text_message;
        this.author_message = author_message;
        this.date_string_message = date_message;
        this.id_message = id_message;
        setDate_message(date_message);
    }

    public Message(int id_message, String text_message, String author_message, String date_string_message){
        this.id_message = id_message;
        this.text_message = text_message;
        this.author_message = author_message;
        this.date_string_message = date_string_message;
    }

    public String getDate_string_message() {
        return date_string_message;
    }

    public void setDate_string_message(String date_string_message) {
        this.date_string_message = date_string_message;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getText_message() {
        return text_message;
    }

    public void setText_message(String text_message) {
        this.text_message = text_message;
    }

    public String getAuthor_message() {
        return author_message;
    }

    public void setAuthor_message(String author_message) {
        this.author_message = author_message;
    }

    public Date getDate_message() {
        return date_message;
    }

    public void setDate_message(String date_message) {
        int year = Integer.valueOf(date_message.substring(0, 4));
        int month = Integer.valueOf(date_message.substring(5, 7));
        int day = Integer.valueOf(date_message.substring(8, 10));
        Date date = new Date( year - 1900 , month - 1, day);
        this.date_message = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return //"Message: \n" +
                "ID: " + id_message +
                "\tAuthor: " + author_message +
                "\tDate: " + date_string_message +
                "\n\t'" + text_message + "'";
    }
}
