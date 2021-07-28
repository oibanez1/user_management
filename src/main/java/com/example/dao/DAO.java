package com.example.dao;

import java.util.List;
import com.example.model.User;

interface DAO<T>{
    public T get(int id);
    public List<T> getAll();
    public void add(User user);
    public boolean delete(int id);
    public boolean update(User user);
}

