package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void testVerificarDisponibilidad() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        assertTrue(puesto.estaDisponible()); // Comprobar disponibilidad de un puesto vacío
        parqueadero.agregarVehiculo(new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez")));
        assertFalse(puesto.estaDisponible()); // Comprobar disponibilidad de un puesto ocupado

        LOG.info("Finalizando Test");
    }
    
    @Test
    public void testUbicarVehiculo() {
        LOG.info("Iniciando Test");
        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        Vehiculo vehiculo = new Carro("ARC123", "Mazda", new Propietario("Juan"));
        parqueadero.agregarVehiculo(vehiculo);
        assertFalse(puesto.estaDisponible()); // Verificar que el vehículo se ubica correctamente en el puesto

        LOG.info("Finalizando Test");
    }

    @Test
    public void testIdentificarPropietario() {
        LOG.info("Iniciando Test");
        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        Propietario propietario = new Propietario("Cristian Herrera");
        Carro carro = new Carro("BBC123", "Audi", propietario);
        parqueadero.agregarVehiculo(carro);
        assertEquals(propietario, parqueadero.propietarioVehiculo(propietario)); // Verificar identificación del propietario

        LOG.info("Finalizando Test");
    }

    @Test
    public void testLiberarPuesto() {
        LOG.info("Iniciando Test");
        Puesto puesto = new Puesto(3,3);
        Parqueadero parqueadero = new Parqueadero("Parqueadero 1",getPuestos());
        Administrador administrador = new Administrador("admin");
        Carro carro = new Carro("ABC123", "Mercedes", new Propietario("John Rodriguez"));
        parqueadero.agregarVehiculo(carro);
        parqueadero.retirarVehiculo(carro,administrador); // Liberar un puesto ocupado
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
        parqueadero.retirarVehiculo(carro,administrador);
        parqueadero.retirarVehiculo(moto,administrador);
        parqueadero.generarReporteDiario();
        assertEquals(0,parqueadero.generarReporteDiario()); // Verificar que el total recaudado se reinicia después de generar el reporte diario

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
        parqueadero.retirarVehiculo(carro,administrador);
        parqueadero.generarReporteMensual();
        assertEquals(0, parqueadero.generarReporteMensual(), 0.001); // Verificar que el total recaudado se reinicia después de generar el reporte mensual

        LOG.info("Finalizando Test");
    } 

    @Test
    public void testCrearParqueaderoConTamanioNegativo() {
        LOG.info("Iniciando Test");

        try {
            Puesto puesto = new Puesto(-3,-3);
            Parqueadero parqueadero = new Parqueadero("Parqueadero 1",puesto);
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
        Parqueadero parqueadero = new Parqueadero("parqueadero 1",3);
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
        Vehiculo carro = new Carro("ABC123", "Toyota", propietario);
        // Comprobamos que la función identificarPropietario para un puesto vacío devuelve null
        parqueadero.propietarioVehiculo(propietario);
        if (propietario != null) {
            fail("Se esperaba que el puesto estuviera vacío y no tuviera propietario.");
        }

        LOG.info("Finalizando Test");
    }
    
}
