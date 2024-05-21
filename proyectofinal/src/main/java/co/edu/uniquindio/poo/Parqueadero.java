package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;



public class Parqueadero {

    private String nombre;
    public Collection<Puesto> puestos;
    public Collection<Registro> registros;
    public Collection<Vehiculo> vehiculos;
    public Collection<Propietario> propietarios;
    public Collection<Administrador> administradores;


    /*
     * Constructor de la clase Parqueadero
     */
    public Parqueadero(String nombre) {
        assert nombre != null : "El nombre del parqueadero no puede ser nulo";
        this.nombre = nombre;
        this.puestos = new LinkedList<>();
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

    public Collection<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(Collection<Puesto> puestos) {
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

    /*
     * Main
     */

    public static void main(String[] args) {
        int posicionI = 5;
        int posicionJ = 5;


        /*
         * Creacion de la matriz de puestos
         */
        Puesto[][] matriz = new Puesto[posicionI][posicionJ];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = new Puesto(i, j);
            }
        }
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
    }

    /*
     * Metodo para calcular el costo total de un vehiculo
     */
    public double costoTotalVehiculo(Vehiculo vehiculo, Administrador administrador){
        assert vehiculo != null :"El vehiculo no puede ser nulo";
        double total=0;
        boolean esVehiculoValido = false;
        for (Registro registro : registros){
            if (registro.getPlaca().equals(vehiculo.getPlaca())){
                esVehiculoValido = true;
                break;
            }
        }
        if (esVehiculoValido) {
            for (Registro registro : registros){
                total += registro.TiempoUso()*administrador.tarifaVehiculo(vehiculo,vehiculo.getTarifaVehiculo());
            }
        }
        return total;
    }
    

    /*
     * Metodo para identificar el propietario de un vehiculo
     */
    public Vehiculo propietarioVehiculo(Propietario propietario){
        assert propietario !=null : "El propietario no puede ser nulo";
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPropietario().equals(propietario)){
                return vehiculo;
            }
        }
        return null;
    }

    /*
     * Metodo para buscar un vehiculo por placa
     */
    public Vehiculo buscarVehiculo(String placa){
        assert placa != null : "La placa no puede ser nula";
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPlaca().equals(placa)){
                return vehiculo;
            }
        }
        return null;
    }

    

}








    
