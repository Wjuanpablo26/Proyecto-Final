package co.edu.uniquindio.poo;

public class Carro extends Vehiculo{


    /*
     * Constructor de la clase Carro
     */
    public Carro(String placa, String modelo,Propietario propietario) {
        super(placa,modelo,propietario);
    }

    /*
     * Metodos gets y sets
     */
    public double getTarifaVehiculo() {
        return getTarifaVehiculo();
    }

    public void setTarifaVehiculo(double tarifaVehiculo) {
        assert tarifaVehiculo > 0 : "La tarifa del vehiculo no puede ser negativa";
        this.tarifaVehiculo = tarifaVehiculo;
    }



    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", propietario=" + getPropietario() +
                '}';
    }

    

    


    
    
}
