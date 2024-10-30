package ru.job4j.tracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private final int id;
    @EqualsAndHashCode.Include
    private String username;
    private String password;
    private String occupation;

    public User(int id, String username, String password, String occupation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.occupation = occupation;
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