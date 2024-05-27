package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void testGetTarifaVehiculo() {
        LOG.info("Iniciando Test");

        // Creamos un propietario
        Propietario propietario = new Propietario("Juan");
        Administrador administrador = new Administrador("admin");
        // Creamos un carro
        Carro carro = new Carro("ABC123", "Toyota", propietario);
        // Configuramos una tarifa por hora válida
        administrador.cambiarTarifaVehiculo(carro,15.0);
        // Verificamos que la tarifa por hora obtenida sea la misma que configuramos
        assertEquals(15.0, administrador.getTarifaVehiculo());

        LOG.info("Finalizando Test");
    
    }
    
}
