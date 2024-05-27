package co.edu.uniquindio.poo;

import java.util.Scanner;
import java.util.Collection;
import java.util.LinkedList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Parqueadero {

    private String nombre;
    private double recaudadoDia;
    private double recaudadoMes;
    public Puesto[][] puestos;
    public Collection<Registro> registros;
    public Collection<Vehiculo> vehiculos;
    public Collection<Propietario> propietarios;
    public Collection<Administrador> administradores;
    public Administrador administrador;

    /*
     * Constructor de la clase Parqueadero
     */
    public Parqueadero(String nombre, Puesto[][] puestos) {
        assert nombre != null : "El nombre del parqueadero no puede ser nulo";
        this.nombre = nombre;
        this.puestos = puestos;
        this.registros = new LinkedList<>();
        this.vehiculos = new LinkedList<>();

    }

    /*
     * Metodos gets y sets
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        assert nombre != null : "El nombre del parqueadero no puede ser nulo";
        this.nombre = nombre;
    }

    public double getRecaudadoDia() {
        return recaudadoDia;
    }

    public void setRecaudadoDia(double recaudadoDia) {
        assert recaudadoDia > 0 : "La recaudacion del dia no puede ser negativa";
        this.recaudadoDia = recaudadoDia;
    }

    public double getRecaudadoMes() {
        return recaudadoMes;
    }

    public void setRecaudadoMes(double recaudadoMes) {
        assert recaudadoMes > 0 : "La recaudacion del mes no puede ser negativa";
        this.recaudadoMes = recaudadoMes;
    }

    public Puesto[][] getPuestos() {
        return puestos;
    }

    public void setPuestos(Puesto[][] puestos) {
        this.puestos = puestos;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Collection<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Collection<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public Collection<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(Collection<Administrador> administradores) {
        this.administradores = administradores;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    /*
     * Metodo para mostrar la matriz
     */
    public void mostrarMatriz(Puesto[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].estaDisponible()) {
                    System.out.print("Disponible ");
                } else {
                    System.out.print("Ocupado ");
                }
            }
            System.out.println();
        }
    }

    /*
     * Metodo para buscar un puesto disponible
     */
    public Puesto buscarPuestoDisponible(Puesto[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].estaDisponible()) {
                    return matriz[i][j];
                }
            }
        }
        return null;

    }

    /*
     * Metodo para agregar un vehiculo al parqueadero
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo agregado correctamente\n");
        ingresarVehiculo(vehiculo);

    }

    /*
     * Metodo para ingresar un vehiculo del parqueadero, agrega registro y verificar
     * si el puesto esta ocupado o disponible
     */
    public void ingresarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].estaDisponible()) {
                    puestos[i][j].setVehiculo(vehiculo);
                    puestos[i][j].setDisponible(false);

                    registros.add(vehiculo.getRegistro());
                    System.out.println("Vehiculo ingresado correctamente en el puesto\n" +
                            "[" + i + "," + j + "]\n");
                    return;
                }
                ;
            }
        }
    }

    /*
     * Metodo para calcular el costo total de un vehiculo
     */
    public double costoTotalVehiculo(Vehiculo vehiculo, Administrador administrador) {
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        double total = 0;
        boolean esVehiculoValido = false;
        for (Registro registro : registros) {
            if (registro.getVehiculo().getPlaca().equals(vehiculo.getPlaca())) {
                esVehiculoValido = true;
                break;
            }
        }
        if (esVehiculoValido) {
            for (Registro registro : registros) {
                total += registro.TiempoUso() * (administrador.tarifaVehiculo(vehiculo, vehiculo.getTarifaVehiculo()));
            }
        }
        return total;
    }

    /*
     * Metodo para retirar un vehiculo del parqueadero
     */
    public void retirarVehiculo(Vehiculo vehiculo, Administrador administrador) {
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].getVehiculo().getPlaca().equals(vehiculo.getPlaca())) {
                    puestos[i][j].setVehiculo(null);
                    puestos[i][j].setDisponible(true);

                    registros.add(vehiculo.getRegistro());
                    double total = costoTotalVehiculo(vehiculo, administrador);
                    actualizarRecaudaciones(total);
                    System.out.println("Vehiculo ha sido retirado correctamente del puesto\n" +
                            "[" + i + "," + j + "]\n");
                    return;
                }
            }
        }
    }

    /*
     * Metodo para identificar el propietario de un vehiculo
     */
    public Vehiculo propietarioVehiculo(Propietario propietario) {
        assert propietario != null : "El propietario no puede ser nulo";
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPropietario().equals(propietario)) {
                return vehiculo;
            }
        }
        return null;
    }

    /*
     * Metodo para buscar un vehiculo por placa
     */
    public Vehiculo buscarVehiculo(String placa) {
        assert placa != null : "La placa no puede ser nula";
        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    /**
     * Actualiza las recaudaciones diarias y mensuales con una nueva tarifa.
     *
     * @param tarifa Tarifa a añadir a las recaudaciones.
     */
    private void actualizarRecaudaciones(double tarifa) {
        recaudadoDia += tarifa; // Incrementa el total recaudado diario
        recaudadoMes += tarifa; // Incrementa el total recaudado mensual
    }

    /**
     * Genera y muestra un reporte diario de recaudación, desglosado por tipo de
     * vehículo.
     */
    public void generarReporteDiario() {
        System.out.println("Reporte Diario:");
        System.out.println("Total recaudado: " + recaudadoDia);
        System.out.println("Desglosado por tipo de vehículo:");

        double totalCarros = 0;
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;

        for (Registro registro : registros) {
            if (registro.getHoraSalida() != null) {
                if (registro.getVehiculo() instanceof Carro) {
                    totalCarros += costoTotalVehiculo(registro.getVehiculo(), administrador);
                } else if (registro.getVehiculo() instanceof Moto) {
                    Moto moto = (Moto) registro.getVehiculo();
                    if (moto.getTipo() == TipoMoto.CLASICA) {
                        totalMotosClasicas += costoTotalVehiculo(registro.getVehiculo(), administrador);
                    } else if (moto.getTipo() == TipoMoto.HIBRIDA) {
                        totalMotosHibridas += costoTotalVehiculo(registro.getVehiculo(), administrador);
                    }
                }
            }
        }

        System.out.println("Carros: " + totalCarros);
        System.out.println("Motos Clásicas: " + totalMotosClasicas);
        System.out.println("Motos Híbridas: " + totalMotosHibridas);
        recaudadoDia = 0; // Reset diario
    }

    /**
     * Genera y muestra un reporte mensual de recaudación.
     */
    public void generarReporteMensual() {
        System.out.println("Reporte Mensual:");
        System.out.println("Total recaudado: " + recaudadoMes);
        recaudadoMes = 0; // Reset mensual

    }

}