package model;


public class User {
    private int id_user;
    private String email;
    private String passwordUser;
    private String nameUser;


    public User(String email, String passwordUser, String nameUser){
        this.email = email;
        this.passwordUser = passwordUser;
        this.nameUser = nameUser;
    }

    public User(String email, String passwordUser){
        this.email = email;
        this.passwordUser = passwordUser;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
