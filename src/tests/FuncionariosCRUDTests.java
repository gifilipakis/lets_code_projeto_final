package tests;

import main.controllers.APessoa;
import main.controllers.ICRUDTests;
import main.controllers.IDataBaseManagement;
import main.databases.FuncionariosDataBase;
import main.enums.FuncaoFuncionariosENUM;
import main.models.Funcionario;

public class FuncionariosCRUDTests implements ICRUDTests<APessoa> {
    
    private static ICRUDTests<APessoa> funcionariosTest = new FuncionariosCRUDTests();
    private static APessoa funcionario = new Funcionario("123456", "Ana", "0000-0000", "01/01", FuncaoFuncionariosENUM.VENDEDOR);
    private static String id = funcionario.getIdentificador();
    private static IDataBaseManagement<APessoa> database = new FuncionariosDataBase();
    public static void main(String[] args) {

        // Standard tests
        funcionariosTest.givenObjectAndDatabase_whenInsert_thenReturnInsertionConfirmation(funcionario, database);
        funcionariosTest.givenIdAndDatabase_whenDelete_thenReturnDeletionConfirmation(id, database);
        funcionariosTest.givenIdAndDatabase_whenDelete_thenReturnElementNotFound(id, database);
        funcionariosTest.givenIdAndDatabase_whenSelectById_thenElementNotFound("654321", database);
        funcionariosTest.givenObjectAndDatabase_whenInsert_thenReturnElementAlreadyExists(funcionario, database);
        
        // Specific tests
        funcionariosTest.givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(database);
        funcionariosTest.givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(database);

    }
    
    @Override
    public void givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(IDataBaseManagement<APessoa> database) {
        System.out.println("--> Executanto givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid");

        APessoa funcionario = new Funcionario("", "Ana", "0000-0000", "01/01", FuncaoFuncionariosENUM.VENDEDOR);
        database.insert(funcionario);

        String expected = "Chave de funcionário inválida";
        String actual = database.insert(funcionario);
        assertEquals(expected, actual);
    }

    @Override
    public void givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(IDataBaseManagement<APessoa> database) {
        System.out.println("--> Executanto givenIdAndDatabase_whenSelectedById_theSucceed");
        
        APessoa funcionario = new Funcionario("123456", "Ana", "0000-0000", "01/01", FuncaoFuncionariosENUM.VENDEDOR);
        database.insert(funcionario);
        
        String expected = "* Identificador: 123456 | Nome: Ana";
        String actual = database.selectById("123456");
        assertEquals(expected, actual);
    }


}
