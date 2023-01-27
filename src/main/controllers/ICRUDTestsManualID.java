package main.controllers;

public interface ICRUDTestsManualID<T> extends ICRUDTests<T>{

    public void givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(IDataBaseManagement<T> database);

    default public void givenObjectAndDatabase_whenInsert_thenReturnElementAlreadyExists(T obj, IDataBaseManagement<T> database) {
        System.out.println("--> Executanto givenObjectAndDatabase_whenInsert_thenReturnElementAlreadyExists");
        
        database.insert(obj);
        
        String expected = "Esse elemento já está cadastrado no sistema";
        String actual = database.insert(obj);
        assertEquals(expected, actual);
    }
    
}