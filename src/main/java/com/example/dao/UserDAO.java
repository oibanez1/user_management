package com.example.dao;

import java.util.List;
import com.example.model.User;

public class UserDAO implements DAO<User> {
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
