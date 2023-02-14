package ru.job4j.oop.tracker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    private Item itemGet(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getString("name"),
                resultSet.getInt("id"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            try (ResultSet generateKey = ps.getGeneratedKeys()) {
                if (generateKey.next()) {
                    item.setId(generateKey.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement("UPDATE items set name = ?, created = ? where id =?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.setInt(3, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items where id = ?")) {
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    itemList.add(itemGet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            ps.setString(1, key);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                        itemList.add(itemGet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    item = itemGet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
