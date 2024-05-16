package co.edu.uniquindio.poo;

public abstract class Vehiculo {

    private String placa;
    private String modelo;
    private String propietario;


    /*
     * Constructor de la clase Vehiculo
     */
    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    
    }

    /*
     * Metodos gets y sets
     */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        assert placa != null : "La placa del vehiculo no puede ser nula";
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        assert modelo != null : "El modelo del vehiculo no puede ser nulo";
        this.modelo = modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        assert propietario != null : "El propietario del vehiculo no puede ser nulo";
        this.propietario = propietario;
    }



    /*
     * Metodo que calcula el valor a pagar por el vehiculo
     */
    public abstract double calcularCostoEstacionamiento(int horas);

    

    
}
