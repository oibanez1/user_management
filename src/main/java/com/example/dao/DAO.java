package com.example.dao;

interface DAO<T>{
    public T get();
    public T getAll();
    public T add();
    public T delete();
    public T update();
}

