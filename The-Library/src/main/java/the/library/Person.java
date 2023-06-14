package the.library;

import java.io.Serializable;

public class Person implements Serializable {

    private String username;

    private String email;

    private String address;

    public Person(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public Person(String[] row) {
        this.username = row[1];
        this.email = row[2];
        this.address = row[3];
    }

    public Person(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        } else {
            this.username = username;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must contain @ symbol");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getDetails() {
        return "Username: " + Utils.RED + username + Utils.RESET + "\nEmail: " + Utils.RED + email + Utils.RESET
                + "\nAddress: " + Utils.RED + address + Utils.RESET;
    }

    public String getDetails(String username, String email) {
        return "Username: " + Utils.RED + username + Utils.RESET + "\nEmail: " + Utils.RED + email + Utils.RESET;
    }

    public String toString() {
        return username + ", with email: " + email;
    }

}
