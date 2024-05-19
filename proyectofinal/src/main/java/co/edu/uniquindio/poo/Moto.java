package co.edu.uniquindio.poo;

public class Moto extends Vehiculo{

    public double velocidadMaxima;

    /*
     * Constructor de la clase Moto
     */
    public Moto(String placa,String modelo,double velocidadMaxima, Propietario propietario){
        super( placa,  modelo, propietario);
        assert velocidadMaxima > 0 :"la velocidad maxima no puede ser negativa";
        this.velocidadMaxima = velocidadMaxima;

    }

    /*
     * Metodo get
     */
    public double getVelocidadMaxima(){
        return velocidadMaxima;
    }

    /*
     * Metodo set
     */
    public void setVelocidadMaxima(double velocidadMaxima){
        assert velocidadMaxima > 0 : "la velocidad maxima no puede ser negativa";
        this.velocidadMaxima = velocidadMaxima;
    }

    /*
     * Metodo que calcula el valor a pagar por el vehiculo
     */
    public double tarifaVehiculo(){
        return 2000;
    }


    



    
}
