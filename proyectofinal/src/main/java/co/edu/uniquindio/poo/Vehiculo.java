package co.edu.uniquindio.poo;


public abstract  class Vehiculo {

    private String placa;
    private String modelo;
    public double tarifaVehiculo;
    public Propietario propietario;
    public Administrador administrador;
    public Registro registro;


    
    

    /*
     * Constructor de la clase Vehiculo
     */
    public Vehiculo(String placa, String modelo,Propietario  propietario) {
        assert placa != null :"La placa del vehiculo no puede ser nula";
        assert modelo != null :"El modelo del vehiculo no puede ser nulo";
        assert tarifaVehiculo > 0 :"La tarifa del vehiculo no puede ser negativa";  
        assert propietario != null :"El propietario del vehiculo no puede ser nulo";

        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        
    
    }
    

    /*
     * Constructor vacio de la clase Vehiculo sin atributos declarados
     * 
     */ 

    public Vehiculo() {
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

    public double getTarifaVehiculo() {
        return tarifaVehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public Registro getRegistro(){
        return registro;
    }




    
}
