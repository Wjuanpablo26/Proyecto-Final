package co.edu.uniquindio.poo;

public class Persona {

    private String nombre;

    /*
     * Constructor de la clase Persona
     */
    public Persona(String nombre) {
        assert nombre != null : "El nombre de la persona no puede ser nulo";
        this.nombre = nombre;
    }

    /*
     * Metodo get
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Metodo set
     */
    public void setNombre(String nombre){
        assert nombre != null : "El nombre de la persona no puede ser nulo";
        this.nombre = nombre;
    }
    
}
