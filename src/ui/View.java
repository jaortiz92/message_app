package ui;

public interface View {
    Integer readInteger(String message);
    String readString(String message);
    void show(String message);
}
