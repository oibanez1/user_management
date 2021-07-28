package com.example.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.example.model.User;

public class UserDAO implements DAO<User> {

    public UserDAO(){}

    public Connection getConnection() throws FileNotFoundException, IOException{
        Connection connection = null;
        Properties properties = new Properties();
        FileReader reader = new FileReader("db.properties");
        properties.load(reader);
        try{
            String driver = properties.getProperty("MYSQL_DB_DRIVER_CLASS");
            String url = properties.getProperty("MYSQL_DB_URL");
            String user = properties.getProperty("MYSQL_DB_USERNAME");
            String password = properties.getProperty("MYSQL_DB_PASSWORD");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password)
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    @Override
    public User get(int id) {
        return null;
    }
    @Override
    public List<User> getAll() {
        return null;
    }
    @Override
    public void add(User newUser) {

    }
    @Override
    public boolean delete(int id) {
        return false;
    }
    @Override
    public boolean update(User user) {
        return false;
    }
}
