package main.controllers;

public interface IDataBaseManagement<T> {
    
    public String insert(T obj);
    public void readAll();
    public String delete(String id);
    public String selectById(String id);
    
}
