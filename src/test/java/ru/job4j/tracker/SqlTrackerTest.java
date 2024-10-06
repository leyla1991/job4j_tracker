package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement
                     = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindItByGeneratedIdThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Assertions.assertThat(tracker
                .findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test");
        tracker.add(item);
        tracker.delete(item.getId());
        Assertions.assertThat(tracker
                .findById(item.getId())).isNull();
        Assertions.assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void whenFindAllItemsIsSuccessful() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        Assertions.assertThat(tracker
                .findAll()).containsAll(List.of(item1, item2));
    }

    @Test
    public void whenFindByNameIsSuccessFul() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Assertions.assertThat(tracker
                .findByName(item.getName())).contains(item);

    }

    @Test
    public void whenFindByIdIsSuccessful() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        int id = item.getId();
        Assertions.assertThat(tracker
                .findById(id)).isEqualTo(item);
    }

    @Test
    public void whenDeleteOneItemDoesNotRemoveOtherItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        Assertions.assertThat(tracker.findAll()).isNotEmpty();
    }
}




