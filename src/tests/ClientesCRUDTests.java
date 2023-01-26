package tests;

import main.controllers.APessoa;
import main.controllers.ICRUDTests;
import main.controllers.IDataBaseManagement;
import main.databases.ClientesDataBase;
import main.models.Cliente;

public class ClientesCRUDTests implements ICRUDTests<APessoa> {
    
    private static ICRUDTests<APessoa> clientes = new ClientesCRUDTests();
    private static APessoa cliente = new Cliente("00000000000", "João", "0000-0000", "01/01");
    private static String id = cliente.getIdentificador();
    private static IDataBaseManagement<APessoa> database = new ClientesDataBase();
    public static void main(String[] args) {

        // Standard tests
        clientes.givenObjectAndDatabase_whenInsert_thenReturnInsertionConfirmation(cliente, database);
        clientes.givenIdAndDatabase_whenDelete_thenReturnDeletionConfirmation(id, database);
        clientes.givenIdAndDatabase_whenDelete_thenReturnElementNotFound(id, database);
        clientes.givenIdAndDatabase_whenSelectById_thenElementNotFound("11111111111", database);
        clientes.givenObjectAndDatabase_whenInsert_thenReturnElementAlreadyExists(cliente, database);
        
        // Specific tests
        clientes.givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(database);
        clientes.givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(database);

    }
    
    @Override
    public void givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(IDataBaseManagement<APessoa> database) {
        System.out.println("--> Executanto givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid");

        APessoa cliente = new Cliente("", "João", "0000-0000", "01/01");
        database.insert(cliente);

        String expected = "CPF inválido";
        String actual = database.insert(cliente);
        assertEquals(expected, actual);
    }

    @Override
    public void givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(IDataBaseManagement<APessoa> database) {
        System.out.println("--> Executanto givenIdAndDatabase_whenSelectedById_theSucceed");
        
        APessoa cliente = new Cliente("00000000000", "João", "0000-0000", "01/01");
        database.insert(cliente);
        
        String expected = "* Identificador: 00000000000 | Nome: João";
        String actual = database.selectById("00000000000");
        assertEquals(expected, actual);
    }


}
