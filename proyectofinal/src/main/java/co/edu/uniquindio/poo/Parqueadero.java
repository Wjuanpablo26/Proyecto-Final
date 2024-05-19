package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;



public class Parqueadero {

    private String nombre;
    public Collection<Puesto> puestos;
    public Collection<Registro> registros;
    public Collection<Vehiculo> vehiculos;
    public Collection<Propietario> propietarios;


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
    public double costoTotalVehiculo(Vehiculo vehiculo){
        assert vehiculo != null :"El vehiculo no puede ser nulo";
        double total=0;
        for (Registro registro : registros){
            if (registro.getPlaca().equals(vehiculo.getPlaca())){
                total += registro.TiempoUso()* vehiculo.tarifaTotal();
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
    


}








    
