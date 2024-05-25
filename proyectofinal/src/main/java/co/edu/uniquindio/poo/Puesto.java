package co.edu.uniquindio.poo;

public class Puesto {

    private int posicionI, posicionJ;
    private boolean disponible;
    private Vehiculo vehiculo;

    /*
     * Constructor de la clase Puesto
     */
    public Puesto(int posicionI,int posicionJ){
        assert posicionI >= 0 : "La posicion I no puede ser negativa";
        assert posicionJ >= 0 : "La posicion J no puede ser negativa";
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.disponible = true;
    }

    /*
     * Metodos gets y sets
     */
    public int getPosicionI(){
        return posicionI;
    }

    public void setPosicionI(int posicionI){
        assert posicionI >= 0 : "La posicion I no puede ser negativa";
        this.posicionI = posicionI;
    }

    public int getPosicionJ(){
        return posicionJ;
    }

    public void setPosicionJ(int posicionJ){
        assert posicionJ >= 0 : "La posicion J no puede ser negativa";
        this.posicionJ = posicionJ;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    /*
     * Metodo para verificar si el puesto esta disponible
     */

    public boolean estaDisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    /*
     * Metodo para verificar si el puesto esta ocupado
     */
    public boolean estaOcupado(){
        return !disponible;

    }


    
}
