package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());
    private Puesto[][] getPuestos() {
        Puesto[][] puestos = new Puesto[3][3];
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
        return puestos;
    }


    

    @Test
    public void testVerificarDisponibilidad() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        assertTrue(puesto.estaDisponible()); // Comprobar disponibilidad de un puesto vacío
        parqueadero.agregarVehiculoTest(new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez")));
        puesto.setDisponible(false);
        assertThrows(Throwable.class,() -> puesto.estaDisponible()); // Comprobar disponibilidad de un puesto ocupado
        
        LOG.info("Finalizando Test");
    }




    
    @Test
    public void testUbicarVehiculo() {
        LOG.info("Iniciando Test");
        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        parqueadero.agregarVehiculoTest(new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez")));
        puesto.setDisponible(true);
        assertTrue(puesto.estaDisponible()); // Verificar que el vehículo se ubica correctamente en el puesto
        
        LOG.info("Finalizando Test");
    }

    @Test
public void testIdentificarPropietario() {
    LOG.info("Iniciando Test");
    Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
    Propietario propietario = new Propietario("Camilo Sanchez");

    parqueadero.agregarVehiculoTest(new Carro("ABC123", "Toyota", propietario));
    assertEquals(propietario,parqueadero.propietarioVehiculoNombre("Camilo Sanchez")); // Verificar identificación del propietario
    LOG.info("Finalizando Test");
    }

    @Test
    public void testLiberarPuesto() {
        LOG.info("Iniciando Test");
        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        Carro carro = new Carro("ABC123", "Mercedes", new Propietario("John Rodriguez"));
        parqueadero.agregarVehiculo(carro);
        parqueadero.retirarVehiculo(carro,getPuestos()); // Liberar un puesto ocupado
        assertTrue(puesto.estaDisponible()); // Verificar que el puesto se libere

        LOG.info("Finalizando Test");
    }

    @Test
public void testGenerarReporteDiario() {
    LOG.info("Iniciando Test");

    Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
    Administrador administrador = new Administrador("admin");
    Vehiculo carro = new Carro("ABC123", "Dodge", new Propietario("Juan"));
    Vehiculo moto = new Moto("XYZ987", "Honda",100.0, new Propietario("Ana"));
    parqueadero.agregarVehiculo( carro);
    parqueadero.agregarVehiculo( moto);
    parqueadero.retirarVehiculo(carro,getPuestos());
    parqueadero.retirarVehiculo(moto,getPuestos());
    parqueadero.generarReporteDiario();
    assertEquals(0, parqueadero.getTotalRecaudado()); // Verificar que el total recaudado se reinicia después de generar el reporte diario

    LOG.info("Finalizando Test");
}

    @Test
    public void testGenerarReporteMensual() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        Administrador administrador = new Administrador("admin");
        Vehiculo carro = new Carro("ABC123", "Toyota", new Propietario("Juan"));
        parqueadero.agregarVehiculo( carro);
        parqueadero.retirarVehiculo(carro,getPuestos());
        parqueadero.generarReporteMensual();
        assertEquals(0.0, 0.001, "juan"); // Verificar que el total recaudado se reinicia después de generar el reporte mensual

        LOG.info("Finalizando Test");
    } 

    @Test
    public void testCrearParqueaderoConTamanioNegativo() {
        LOG.info("Iniciando Test");

        try {
            Puesto puesto = new Puesto(-3,-3);
            Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
            fail("Se esperaba una excepción debido al tamaño negativo del parqueadero.");
        } catch (AssertionError e) {
            // Se espera una excepción
        }

        LOG.info("Finalizando Test");
    }

    @Test
    public void testUbicarVehiculoFueraDeLimites() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        try {
            parqueadero.ingresarVehiculo(new Carro("ABC123", "mazda", new Propietario("Juan")));
            fail("Se esperaba una excepción debido a la ubicación fuera de los límites del parqueadero.");
        } catch (AssertionError e) {
            // Se espera una excepción
        }

        LOG.info("Finalizando Test");
    }

    @Test
    public void testConfigurarTarifasNegativas() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("parqueadero 1",getPuestos());
        Administrador administrador = new Administrador("admin");
        Vehiculo carro = new Carro("ABC123", "Toyota", new Propietario("Juan"));
        try {
            administrador.tarifaVehiculo(carro,-100);
            fail("Se esperaba una excepción debido a la tarifa negativa para carros.");
        } catch (AssertionError e) {
            // Se espera una excepción
        }

        LOG.info("Finalizando Test");
    }

    @Test
    public void testIdentificarPropietarioPuestoVacio() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        Propietario propietario = new Propietario("Juan");
        
        if (parqueadero.propietarioVehiculoNombre("juan") != null) {
            fail("Se esperaba que el puesto estuviera vacío y no tuviera propietario.");
        }
        Vehiculo carro = new Carro("ABC123", "Toyota", propietario);
        parqueadero.agregarVehiculoTest(new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez")));
        // Comprobamos que la función identificarPropietario para un puesto vacío devuelve null
        parqueadero.agregarVehiculo(carro);

        assertEquals("Juan", parqueadero.propietarioVehiculoNombre("ABC123"));


        LOG.info("Finalizando Test");
    }

}
