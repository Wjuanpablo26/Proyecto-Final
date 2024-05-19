package co.edu.uniquindio.poo;

public class Carro extends Vehiculo{



    /*
     * Constructor de la clase Carro
     */
    public Carro(String placa, String modelo,Propietario propietario, Registro registro) {
        super(placa,modelo,propietario);

    }

    /*
     * Metodo que calcula el valor a pagar por el vehiculo
     */
    public double tarifaVehiculo(){
        return 5000;

    }

    

    


    
    
}
