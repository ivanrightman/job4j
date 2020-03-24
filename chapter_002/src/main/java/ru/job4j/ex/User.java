package ru.job4j.ex;

public class User {
    private String username;
    private boolean valid;

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username, boolean valid) {
        this.username = username;
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public boolean isValid() {
        return valid;
    }
}
