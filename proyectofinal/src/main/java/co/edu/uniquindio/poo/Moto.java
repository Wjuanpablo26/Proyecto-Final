package co.edu.uniquindio.poo;

public class Moto extends Vehiculo{

    public double velocidadMaxima;
    private TipoMoto tipo;

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

    public TipoMoto getTipo() {
        return tipo;
    }

    public void setTipo(TipoMoto tipo) {
        this.tipo = tipo;
    }

    public double getTarifaVehiculo(){
        return getTarifaVehiculo();
    }

    public void setTarifaVehiculo(double tarifaVehiculo){
        assert tarifaVehiculo > 0 : "La tarifa del vehiculo no puede ser negativa";
        this.tarifaVehiculo = tarifaVehiculo;
    }



    /*
     * Metodo set
     */
    public void setVelocidadMaxima(double velocidadMaxima){
        assert velocidadMaxima > 0 : "la velocidad maxima no puede ser negativa";
        this.velocidadMaxima = velocidadMaxima;
    }

    /*
     * Metodo para obtener la informacion de la moto
     */
    public String toString(){
        return "Moto: Placa: "+getPlaca()+'/'+
        " Modelo: "+getModelo()+'/'+
        " Velocidad Maxima: "+getVelocidadMaxima()+'/'+
        " Tipo: "+getTipo()+'/'+
        "Propietario: "+getPropietario();
    }


    
}
