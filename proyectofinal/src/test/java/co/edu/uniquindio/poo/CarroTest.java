package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class CarroTest {

    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void testCrearCarro() {
        LOG.info("Iniciando Test");

        // Creamos un propietario
        Propietario propietario = new Propietario("Juan");
        // Creamos un carro
        Carro carro = new Carro("ABC123", "Toyota", propietario);
        
        // Verificamos que el carro no sea nulo
        assertNotNull(carro);
        
        // Verificamos que los atributos del carro hayan sido inicializados correctamente
        assertEquals("ABC123", carro.getPlaca());
        assertEquals("Toyota", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalizando Test");
    }


    
}
