package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.*;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username){
        //GRAB FROM DATABASE, JAVA OBJECT CREATION
        String sql = "SELECT * FROM users WHERE username LIKE ?";
        String searchUsername = "%" + username + "%";
        //if username is found, creates new user obj. if username is not found, just returns null
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, searchUsername);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
        return null;
    }

    @Override
    public Long insert(User user){
        try {
            String sql = createInsertQuery(user);
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            //returning only first POSITION
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private String createInsertQuery(User user) {
        return "INSERT INTO users(username, email, password) VALUES "
                + "(" + user.getUsername() + ", "
                + "'" + user.getEmail() +"', "
                + "'" + user.getPassword() + "')";
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email")
        );
    }

}
