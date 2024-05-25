package co.edu.uniquindio.poo;
import java.util.Scanner;
import java.util.Collection;
import java.util.LinkedList;
import java.time.LocalTime;



public class Parqueadero {

    private String nombre;
    public Puesto[][] puestos;
    public Collection<Registro> registros;
    public Collection<Vehiculo> vehiculos;
    public Collection<Propietario> propietarios;
    public Collection<Administrador> administradores;


    /*
     * Constructor de la clase Parqueadero
     */
    public Parqueadero(String nombre, Puesto[][] puestos) {
        assert nombre != null : "El nombre del parqueadero no puede ser nulo";
        this.nombre = nombre;
        this.puestos = puestos;
        this.registros = new LinkedList<>();
        this.vehiculos = new LinkedList<>();
        }

    /*
     * Metodos gets y sets
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        assert nombre != null : "El nombre del parqueadero no puede ser nulo";
        this.nombre = nombre;
    }

    public Puesto[][] getPuestos() {
        return puestos;
    }

    public void setPuestos(Puesto[][] puestos) {
        this.puestos = puestos;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Collection<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Collection<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public Collection<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(Collection<Administrador> administradores) {
        this.administradores = administradores;
    }

    /*
     * Main
     */

    

    /*
     * Metodo para mostrar la matriz
     */
    public void mostrarMatriz(Puesto[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].estaDisponible()) {
                    System.out.print("Disponible ");
                } else {
                    System.out.print("Ocupado ");
                }
            }
            System.out.println();
        }
    }

    /*
     * Metodo para buscar un puesto disponible
     */
    public Puesto buscarPuestoDisponible(Puesto[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].estaDisponible()) {
                    return matriz[i][j];
                }
            }
        }
        return null;

    }

    /*
     * Metodo para agregar un vehiculo al parqueadero
     */
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        Scanner scaner = new Scanner(System.in);

        if (vehiculo instanceof Moto){
            System.out.println("Ingrese la placa de la moto:");
            String placa = scaner.nextLine();
            System.out.println("Ingrese el modelo de la moto:");
            String modelo = scaner.nextLine();
            System.out.println("Ingrese la velocidad maxima de la moto:");
            double velocidadMaxima = scaner.nextDouble();
            System.out.println("Ingrese el nombre del propietario de la moto:");
            Propietario propietario = new Propietario(nombre);
            System.out.println("Ingrese el tipo de moto:");
            System.out.println("1. Clasica");
            System.out.println("2. Hibrida");
            Moto moto = new Moto(placa, modelo, velocidadMaxima, propietario);
            int tipo = scaner.nextInt();
            if (tipo == 1){
                moto.setTipo(TipoMoto.CLASICA);
            } else if (tipo == 2){
                moto.setTipo(TipoMoto.HIBRIDA);
            }
        
        }else if (vehiculo instanceof Carro);
        
        System.out.println("Ingrese la placa del carro:");
        String placa = scaner.nextLine();
        System.out.println("Ingrese el modelo del carro:");
        String modelo = scaner.nextLine();
        System.out.println("Ingrese el nombre del propietario del carro:");
        String nombre = scaner.nextLine();
        Propietario propietario = new Propietario(nombre);
        Carro carro = new Carro(placa, modelo, propietario);
        vehiculo = carro;
    

        assert vehiculo != null : "El vehiculo no puede ser nulo";
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo agregado correctamente\n");
        ingresarVehiculo(vehiculo);
        

        
    }

    /*
     * Metodo para ingresar un vehiculo del parqueadero
     */
    public void ingresarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if(puestos[i][j].estaDisponible()){
                    puestos[i][j].setVehiculo(vehiculo);
                    puestos[i][j].setDisponible(false);
                    Registro registro = new Registro(LocalTime.now(),null,vehiculo);
                    registros.add(registro);
                    System.out.println("Vehiculo ingresado correctamente en el puesto\n"+
                                        "["+i+","+j+"]\n");
                    return;
                } ;
            }
        }
        
    }


    /*
     * Metodo para calcular el costo total de un vehiculo
     */
    public double costoTotalVehiculo(Vehiculo vehiculo, Administrador administrador){
        assert vehiculo != null :"El vehiculo no puede ser nulo";
        double total=0;
        boolean esVehiculoValido = false;
        for (Registro registro : registros){
            if (registro.getPlaca().equals(vehiculo.getPlaca())){
                esVehiculoValido = true;
                break;
            }
        }
        if (esVehiculoValido) {
            for (Registro registro : registros){
                total += registro.TiempoUso()*administrador.tarifaVehiculo(vehiculo,vehiculo.getTarifaVehiculo());
            }
        }
        return total;
    }

    /*
     * Metodo para retirar un vehiculo del parqueadero
     */
    public void retirarVehiculo(Vehiculo vehiculo){
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].getVehiculo().equals(vehiculo)){
                    puestos[i][j].setVehiculo(null);
                    puestos[i][j].setDisponible(true);
                    Registro registro = new Registro(null,LocalTime.now(),vehiculo);
                    registros.add(registro);
                    System.out.println("Vehiculo retirado correctamente del puesto\n"+
                                        "["+i+","+j+"]\n");
                    return;
                }
            }
        }
    }
    

    /*
     * Metodo para identificar el propietario de un vehiculo
     */
    public Vehiculo propietarioVehiculo(Propietario propietario){
        assert propietario !=null : "El propietario no puede ser nulo";
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPropietario().equals(propietario)){
                return vehiculo;
            }
        }
        return null;
    }

    /*
     * Metodo para buscar un vehiculo por placa
     */
    public Vehiculo buscarVehiculo(String placa){
        assert placa != null : "La placa no puede ser nula";
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPlaca().equals(placa)){
                return vehiculo;
            }
        }
        return null;
    }

    /*
     * 
     */

    

}








    
