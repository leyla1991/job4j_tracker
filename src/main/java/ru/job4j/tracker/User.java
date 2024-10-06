package ru.job4j.tracker;

public class User {
    private int id;
    private String username;
    private String password;

    private String occupation;

    public User(int id, String username, String password, String occupation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + ", occupation='" + occupation + '\''
                + '}';
    }
}