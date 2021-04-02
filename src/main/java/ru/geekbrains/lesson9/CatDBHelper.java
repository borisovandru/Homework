package ru.geekbrains.lesson9;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatDBHelper {
    private Connection connection;

    public void deleteCat(int id) throws SQLException {
        String DELETE_CAT = "delete from cats where id = ?;";
        try(PreparedStatement ps = connection.prepareStatement(DELETE_CAT)) {
            ps.setInt(1, id);
            ps.execute();
        }
    }

    public void updateCat(String name, int id) throws SQLException {
        String UPDATE_CAT = "update cats set name = ? where id = ?;";
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_CAT)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void addCat(Cat cat) throws SQLException {
        String ADD_CAT = "insert into cats(name, color) values(?, ?);";
        try(PreparedStatement ps = connection.prepareStatement(ADD_CAT)) {
            ps.setString(1, cat.getName());
            ps.setString(2, cat.getColor());
            ps.execute();
        }
    }

    public Cat getCatByName(String name) throws SQLException {
        String GET_BY_NAME = "select * from cats where name = ? order by name asc limit 1;";
        try(PreparedStatement ps = connection.prepareStatement(GET_BY_NAME)) {
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new RuntimeException("No such cat!!!");
            Cat cat = new Cat(rs.getInt(1), rs.getString(2), rs.getString(3));
            rs.close();
            return  cat;
        }
    }

    public void createTable() throws SQLException {
        try(Statement st = connection.createStatement()) {
            String CREATE_DB = "create table if not exists cats(id integer primary key autoincrement not null, name text not null, color text not null);";
            st.execute(CREATE_DB);
        }
    }

    public List<Cat> getAllCats() throws SQLException {
        try(Statement st = connection.createStatement()) {
            List<Cat> cats = new ArrayList<>();
            String GET_ALL = "select * from cats;";
            ResultSet rs = st.executeQuery(GET_ALL);
            while (rs.next()) {
                cats.add(new Cat(rs.getInt("ID"), rs.getString("NAME"), rs.getString("COLOR")));
            }
            rs.close();
            return cats;
        }
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (connection != null) return;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cats.db");
    }

    public void closeConnection() {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Something wrong with closing connection!");
            e.printStackTrace();
        }
    }

}