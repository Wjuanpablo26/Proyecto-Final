package co.edu.uniquindio.poo;

public class Administrador extends Persona{

    private double tarifaHora;
    private Vehiculo vehiculo;

    /*
     * Constructor de la clase Administrador
     */
    public Administrador(String nombre, double tarifaHora){
        super(nombre);
        assert tarifaHora > 0 : "La tarifa por hora no puede ser negativa";
        this.tarifaHora = tarifaHora;
    }

    /*
     * Metodos gets y sets
     */
    public double getTarifaHora(){
        return tarifaHora;
    }


    public void setTarifaHora(double tarifaHora){
        assert tarifaHora > 0 : "La tarifa por hora no puede ser negativa";
        this.tarifaHora = tarifaHora;
    }


    public Vehiculo getVehiculo(){
        return vehiculo;
    }


    public Vehiculo getTarifaVehiculo(){
        return getTarifaVehiculo();
    }


    public void setTarifaVehiculo(Vehiculo vehiculo){
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        this.vehiculo = vehiculo;
    }

    
    /*
     * Metodo para verificar que si sea un administrador
     */
    public boolean esAdministrador(){
        return true;
    }


    
}
