package com.example.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.example.model.User;

public class UserDAO implements DAO<User> {

    public UserDAO(){}

    private static final String SELECT_BY_ID = "SELECT userId, userName, email, country, userAge from users WHERE userId=?";
    private static final String SELECT_ALL = "SELECT * from users";
    private static final String ADD_USER = "INSERT INTO users" + " (userName, email, country, userAge) VALUES" + " (?,?,?,?);";
    private static final String UPDATE_USER = "UPDATE users set userName=?, email=?, country=?, userAge=? WHERE userId=?";
    private static final String DELETE_BY_ID = "DELETE from users WHERE userId=?";

    public Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader("db.properties");
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try{
            String driver = properties.getProperty("MYSQL_DB_DRIVER_CLASS");
            String url = properties.getProperty("MYSQL_DB_URL");
            String user = properties.getProperty("MYSQL_DB_USERNAME");
            String password = properties.getProperty("MYSQL_DB_PASSWORD");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return connection;
    }
    public User getFieldsFromResultSet(ResultSet res) throws SQLException{
        User user = null;
        while(res.next()){
            int id = res.getInt("userId");
            String name = res.getString("userName");
            String email = res.getString("email");
            String country = res.getString("country");
            int age = res.getInt("userAge");
            user = new User(id, name, email, country, age);
        }
        return user;
    }

    @Override
    public User get(int id) {
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(SELECT_BY_ID);)
        {
            prepStatement.setInt(1, id);  
            ResultSet resultSet = prepStatement.executeQuery();
            user = getFieldsFromResultSet(resultSet);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }   
        return user;
    }
    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL);)
        {  
            ResultSet resultSet = prepStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("userId");
                String name = resultSet.getString("userName");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                int age = resultSet.getInt("userAge");
                userList.add(new User(id, name, email, country, age));
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }   
        return userList;
    }
    @Override
    public void add(User newUser) {
        try (Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(ADD_USER);)
        {   
            prepStatement.setInt(1, newUser.getId());
            prepStatement.setString(2, newUser.getUserName());
            prepStatement.setString(3, newUser.getEmail());
            prepStatement.setString(4, newUser.getCountry());
            prepStatement.setInt(5, newUser.getAge());
            prepStatement.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }   
    }
    @Override
    public boolean delete(int id) {
        try (Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(DELETE_BY_ID);)
        {
            prepStatement.setInt(1, id);  
            if(prepStatement.executeUpdate() == 0) return false;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }   
        return true;
    }
    @Override
    public boolean update(User user) {
        try (Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(UPDATE_USER);)
        {
            prepStatement.setInt(1, user.getId());
            prepStatement.setString(2, user.getUserName());
            prepStatement.setString(3, user.getEmail());
            prepStatement.setString(4, user.getCountry());
            prepStatement.setInt(5, user.getAge());
            if(prepStatement.executeUpdate() == 0) return false;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }   
        return true;
    }
}
