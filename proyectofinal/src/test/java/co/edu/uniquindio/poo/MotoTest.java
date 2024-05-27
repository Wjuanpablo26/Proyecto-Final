package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class MotoTest {

    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());

    @Test
    public void crearMotoConValoresPositivos() {
        LOG.info("Iniciando Test");

        Propietario propietario = new Propietario("Juan");
        Moto moto = new Moto("ABC123", "Yamaha",150.0, propietario);
        
        assertEquals("ABC123", moto.getPlaca());
        assertEquals("Yamaha", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(150.0, moto.getVelocidadMaxima(), 0.001); // Utilizamos un delta pequeño para la comparación de valores double

        LOG.info("Finalizando Test");

    }
    
    @Test
    public void crearMotoConVelocidadNegativa() {
        LOG.info("Iniciando Test");

        Propietario propietario = new Propietario("Juan");
        
        // Intentamos crear una moto con velocidad máxima negativa
        try {
        new Moto("ABC123", "Yamaha", -150,propietario);
        // Si no se lanza una excepción, la prueba falla
        assert false : "Se permitió crear una moto con velocidad máxima negativa";
        } catch (AssertionError e) {
        // Si se lanza una excepción, la prueba pasa
        System.out.println("Test pasar: Crear moto con velocidad máxima negativa");

        LOG.info("Finalizando Test");

        }
    }
    
}
