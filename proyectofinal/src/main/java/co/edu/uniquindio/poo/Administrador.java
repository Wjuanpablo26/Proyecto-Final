package co.edu.uniquindio.poo;

import java.util.List;
import java.util.ArrayList;

public class Administrador extends Persona{

    public Vehiculo vehiculo;
    public Vehiculo tarifaVehiculo;


    /*
     * Constructor de la clase Administrador
     */
    public Administrador(String nombre){
        super(nombre);
    }

    

    /*
     * Metodos gets y sets
     */
    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public Vehiculo getTarifaVehiculo(){
        return getTarifaVehiculo();
    }

    /*
     * Metodo para verificar que si sea un administrador
     */
    public boolean esAdministrador(){
        return true;
    }

    /*
     * Metodo para definir la tarifa de cada vehiculo
     */
    public double tarifaVehiculo(Vehiculo vehiculo,double tarifaVehiculo){
        if(vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            if (moto.getTipo() == TipoMoto.CLASICA) {
                moto.setTarifaVehiculo(tarifaVehiculo);
                return tarifaVehiculo;
            } else if (moto.getTipo() == TipoMoto.HIBRIDA) {
                moto.setTarifaVehiculo(tarifaVehiculo);
                return tarifaVehiculo;
            }
        } else if(vehiculo instanceof Carro){
            Carro carro = (Carro) vehiculo;
            carro.setTarifaVehiculo(tarifaVehiculo);
            return tarifaVehiculo;
        }
        return 0;
    }

    /*
     * Metodo para crear lista con el valor de la tarifa de cada vehiculo
     */
    public List<Double> listaTarifas(List<Vehiculo> vehiculos) {
    List<Double> tarifas = new ArrayList<>();
    for (Vehiculo vehiculo : vehiculos) {
        tarifas.add(vehiculo.getTarifaVehiculo());
    }
    return tarifas;
    }


    /*
     * Metodo para cambiar la tarifa de un vehiculo
     */
    public void cambiarTarifaVehiculo(Vehiculo vehiculo, double tarifaVehiculo){
        if(vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            if (moto.getTipo() == TipoMoto.CLASICA) {
                moto.setTarifaVehiculo(tarifaVehiculo);
            } else if (moto.getTipo() == TipoMoto.HIBRIDA) {
                moto.setTarifaVehiculo(tarifaVehiculo);
            }
        } 
        else if(vehiculo instanceof Carro){
            Carro carro = (Carro) vehiculo;
            carro.setTarifaVehiculo(tarifaVehiculo);
        }
    }


    
    
}
