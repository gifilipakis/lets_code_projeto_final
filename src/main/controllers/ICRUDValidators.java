package main.controllers;

import java.util.List;

public interface ICRUDValidators<T> {
    
    public void validateInsert(T obj, List<T> lista);
    public int validateDelete(String id, List<T> lista);
    public int validateSelectById(String id, List<T> lista);

}
