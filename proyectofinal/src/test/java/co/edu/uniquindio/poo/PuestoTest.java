package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PuestoTest {

    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    @Test
    public void testCrearPuesto() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3, 5);
        assertEquals(3, puesto.getPosicionI());
        assertEquals(5, puesto.getPosicionJ());
        assertFalse(puesto.estaOcupado());
        LOG.info("Finalizando Test");
    }

    @Test
    public void testCrearPuestoConCoordenadaNegativaI() {
        LOG.info("Iniciando Test");

        assertThrows(Throwable.class, () -> new Puesto(-1, 5));
    

        LOG.info("Finalizando Test");
    }

    @Test
    public void testCrearPuestoConCoordenadaNegativaJ() {
        LOG.info("Iniciando Test");

        assertThrows(Throwable.class, () -> new Puesto(3, -1));
        
        LOG.info("Finalizando Test");
    }
    
}
