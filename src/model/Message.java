package model;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class Message {
    private int id_message;
    private String text_message;
    private String author_message;
    private Date date_message;

    public Message() {
    }

    public Message(String text_message, String author_message, String date_message){
        this.text_message = text_message;
        this.author_message = author_message;
        setDate_message(date_message);
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
        int year = Integer.valueOf(date_message.substring(0, 3));
        int month = Integer.valueOf(date_message.substring(5, 6));
        int day = Integer.valueOf(date_message.substring(8, 9));
        Date date = new Date(year, month, day);
        this.date_message = date;
    }

}
