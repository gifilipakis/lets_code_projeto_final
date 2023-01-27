package main.controllers;

public interface ICRUDTests<T> {

    // Insert tests
    default public void givenObjectAndDatabase_whenInsert_thenReturnInsertionConfirmation(T obj, IDataBaseManagement<T> database) {
        System.out.println("--> Executanto givenObjectAndDatabase_whenInsert_thenReturnInsertionConfirmation");
        String expected = "Inserção realizada com sucesso";
        String actual = database.insert(obj);
        assertEquals(expected, actual);
    }

    // Delete tests
    default public void givenIdAndDatabase_whenDelete_thenReturnDeletionConfirmation(String id, IDataBaseManagement<T> database) {
        System.out.println("--> Executanto givenIdAndDatabase_whenDelete_thenReturnDeletionConfirmation");
        String expected = "Deleção realizada com sucesso";
        String actual = database.delete(id);
        assertEquals(expected, actual);
    }

    default public void givenIdAndDatabase_whenDelete_thenReturnElementNotFound(String id, IDataBaseManagement<T> database) {
        System.out.println("--> Executanto givenIdAndDatabase_whenDelete_thenReturnElementNotFound");
        String expected = "Não há um elemento com esse identificador registrado no sistema";
        String actual = database.delete(id);
        assertEquals(expected, actual);
    }

    // SelectById tests
    public void givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(IDataBaseManagement<T> database);

    default public void givenIdAndDatabase_whenSelectById_thenElementNotFound(String id, IDataBaseManagement<T> database){
        System.out.println("--> Executanto givenIdAndDatabase_whenSelectById_thenElementNotFound");
        String expected = "Não há um elemento com esse identificador registrado no sistema";
        String actual = database.selectById(id);
        assertEquals(expected, actual);
    }

    // Assert test
    default public void assertEquals(Object expected, Object actual) {
        if(expected.equals(actual)) {
            System.out.println("* Test Succeeded");
        } else {
            System.out.println("* Test Failed");
            System.out.println("EXPECTED: "+expected);
            System.out.println("ACTUAL: "+actual);
        }
    }
    
}