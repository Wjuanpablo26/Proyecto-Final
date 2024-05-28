package co.edu.uniquindio.poo;

public class Puesto {

    private int posicionI, posicionJ;
    private boolean disponible;
    private String placa;
    private Vehiculo vehiculos;

    /*
     * Constructor de la clase Puesto
     */
    public Puesto(int posicionI,int posicionJ){
        assert posicionI >= 0 : "La posicion I no puede ser negativa";
        assert posicionJ >= 0 : "La posicion J no puede ser negativa";
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.disponible = true;
        this.placa ="";
    }

    /*
     * Metodos gets y sets
     */
    public int getPosicionI(){
        return posicionI;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
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



    /*
     * Metodo para verificar si el puesto esta disponible
     */

    public boolean estaDisponible() {
        if (!this.disponible) {
            throw new IllegalStateException("El puesto no está disponible");
        }
        return this.disponible;
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
