package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

public class PropietarioTest {

    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void crearPropietarioValido() {
        LOG.info("Iniciando Test");

        Propietario propietario = new Propietario("Juan");
        assertEquals("Juan", propietario.getNombre());

        LOG.info("Finalizando Test");
    }

    @Test
    public void crearPropietarioConNombreNulo() {
        LOG.info("Iniciando Test");

        assertThrows(Throwable.class, () -> new Propietario(null));

        LOG.info("Finalizando Test");
    }

    
}
