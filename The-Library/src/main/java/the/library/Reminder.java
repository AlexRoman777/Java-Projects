package the.library;

import java.io.Serializable;

public class Reminder implements Serializable {

    private String username;
    private String email;
    private String type;
    private String returnDate;
    private String address;

    public Reminder(String username, String email, String type, String returnDate, String address) {
        this.username = username;
        this.email = email;
        this.type = type;
        this.returnDate = returnDate;
        this.address = address;
    }

    public Reminder(String[] row) {
        this.username = row[1];
        this.email = row[2];
        this.type = row[3];
        this.returnDate = row[4];
        this.address = row[5];
    }

    public Reminder() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        } else {
            this.username = username;
        }
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must contain @ symbol");
        }
    }

    public void setType(String type) {
        if (type.equals("Book") || type.equals("CD") || type.equals("Movie") || type.equals("Game")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Type must be Book, CD, Movie or Game");
        }
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hello " + username + " you have a " + type + " that is due to be returned on " + returnDate
                + " please return it to or you will be charged a late fee.";
    }

}
