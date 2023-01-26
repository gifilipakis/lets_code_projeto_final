package tests;

import main.controllers.ICRUDTests;
import main.controllers.IDataBaseManagement;
import main.databases.VeiculosDataBase;
import main.enums.CategoriasENUM;
import main.enums.StatusDoVeiculoENUM;
import main.enums.TipoDeVeiculoENUM;
import main.models.Veiculos;

public class VeiculosCRUDTests implements ICRUDTests<Veiculos> {
    
    private static ICRUDTests<Veiculos> veiculosTests = new VeiculosCRUDTests();
    private static Veiculos veiculo = new Veiculos(TipoDeVeiculoENUM.CARRO, "AABB", "Fiat", CategoriasENUM.ECONOMIC);
    private static String id = veiculo.getIdentificador();
    private static IDataBaseManagement<Veiculos> database = new VeiculosDataBase();
    public static void main(String[] args) {

        // Standard tests
        veiculosTests.givenObjectAndDatabase_whenInsert_thenReturnInsertionConfirmation(veiculo, database);
        veiculosTests.givenIdAndDatabase_whenDelete_thenReturnDeletionConfirmation(id, database);
        veiculosTests.givenIdAndDatabase_whenDelete_thenReturnElementNotFound(id, database);
        veiculosTests.givenIdAndDatabase_whenSelectById_thenElementNotFound("CCDD", database);
        veiculosTests.givenObjectAndDatabase_whenInsert_thenReturnElementAlreadyExists(veiculo, database);
        
        // Specific tests
        veiculosTests.givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(database);
        veiculosTests.givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(database);
        givenObjectAndDatabase_whenInsert_thenReturnVehicleNotAvaiable(database);
        

    }
    
    @Override
    public void givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(IDataBaseManagement<Veiculos> database) {
        System.out.println("--> Executanto givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid");

        Veiculos veiculo = new Veiculos(TipoDeVeiculoENUM.CARRO, "", "Fiat", CategoriasENUM.ECONOMIC);
        database.insert(veiculo);

        String expected = "Placa inválida";
        String actual = database.insert(veiculo);
        assertEquals(expected, actual);
    }

    @Override
    public void givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(IDataBaseManagement<Veiculos> database) {
        System.out.println("--> Executanto givenIdAndDatabase_whenSelectedById_theSucceed");
        
        Veiculos veiculo = new Veiculos(TipoDeVeiculoENUM.CARRO, "AABB", "Fiat", CategoriasENUM.ECONOMIC);
        database.insert(veiculo);
        
        String expected = "* Identificador: AABB | Tipo: CARRO";
        String actual = database.selectById("AABB");
        assertEquals(expected, actual);
    }

    public static void givenObjectAndDatabase_whenInsert_thenReturnVehicleNotAvaiable(IDataBaseManagement<Veiculos> database) {

        Veiculos veiculo = new Veiculos(TipoDeVeiculoENUM.CARRO, "", "Fiat", CategoriasENUM.ECONOMIC);
        veiculo.setStatus(StatusDoVeiculoENUM.ALUGADO);
        database.insert(veiculo);

        String expected = "Veículo não disponível";
        String actual = database.insert(veiculo);
        veiculosTests.assertEquals(expected, actual);
    }


}
