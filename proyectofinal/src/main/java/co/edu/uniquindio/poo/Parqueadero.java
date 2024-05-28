package co.edu.uniquindio.poo;
import java.util.Scanner;
import java.util.Collection;
import java.util.LinkedList;
import java.time.LocalTime;
import java.util.ArrayList;

public class Parqueadero {

    private String nombre;
    private double recaudadoDia;
    private double recaudadoMes;
    public Puesto[][] puestos;
    public Collection<Registro> registros;
    public Collection<Vehiculo> vehiculos;
    public Collection<Propietario> propietarios;
    public Collection<Administrador> administradores;
    public Administrador administrador;
    private ArrayList<Moto> listaMotos = new ArrayList<>();

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

    public double getRecaudadoDia() {
        return recaudadoDia;
    }

    public void setRecaudadoDia(double recaudadoDia) {
        assert recaudadoDia > 0 : "La recaudacion del dia no puede ser negativa";
        this.recaudadoDia = recaudadoDia;
    }

    public double getRecaudadoMes() {
        return recaudadoMes;
    }

    public void setRecaudadoMes(double recaudadoMes) {
        assert recaudadoMes > 0 : "La recaudacion del mes no puede ser negativa";
        this.recaudadoMes = recaudadoMes;
    }

    public Puesto[][] getPuestos() {
        return puestos;
    }

    public double getTotalRecaudado(){
        return recaudadoDia;
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

    public Administrador getAdministrador() {
        return administrador;
    }    

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
        System.out.println(vehiculo + "Objeto Vehiculo");
        System.out.println("Vehiculo agregado correctamente\n");
        ingresarVehiculo(vehiculo);
        scaner.close();
        

        
    }

    /*
     * Metodo para agregar un vehiculo al parqueadero para el test
     */
    public void agregarVehiculoTest(Vehiculo vehiculo) {
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        vehiculos.add(vehiculo);
        System.out.println(vehiculo + "Objeto Vehiculo");
        System.out.println("Vehiculo agregado correctamente\n");
        ingresarVehiculo(vehiculo);
    }

    /*
     * Metodo para guardar un carro en la lista de vehiculos
     */
    public void guardarCarro(Carro carro){
        System.out.println(carro);
        vehiculos.add(carro);
    }


    /*
     * Metodo para guardar una moto en la lista de vehiculos
     */
    public void guardarMoto(Moto moto){
            System.out.println(moto);
            vehiculos.add(moto);
    }


    /*
     * Metodo para ingresar un vehiculo del parqueadero, agrega registro y verificar si el puesto esta ocupado o disponible
     */
    public void ingresarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if(puestos[i][j].estaDisponible()){//Verifica si el puesto esta disponible
                    puestos[i][j].setPlaca(vehiculo.getPlaca());//Agrega el vehiculo al puesto
                    puestos[i][j].setDisponible(false);//Cambia el estado del puesto a ocupado
                    Registro registro = new Registro(LocalTime.now(),null,vehiculo);
                    System.out.println(vehiculo.getRegistro() + "Registro vehiculo");
                    registros.add(vehiculo.getRegistro());
                    
                    System.out.println("Vehiculo ingresado correctamente en el puesto\n"+
                                        "["+i+","+j+"]\n");
                    return;
                } ;
            }
        }
        
    }

    /*
     * Metodo para buscar un vehiculo en el parqueadero por la placa
     */
    public void buscarVehiculoParqueadero(Vehiculo vehiculo){
        assert vehiculo != null : "El vehiculo no puede ser nulo";
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].getPlaca().equals(vehiculo.getPlaca())){
                    System.out.println("Vehiculo encontrado en el puesto\n"+
                                        "["+i+","+j+"]\n");
                    return;
                }
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
            if (registro.getVehiculo().getPlaca().equals(vehiculo.getPlaca())){
                esVehiculoValido = true;
                break;
            }
        }
        if (esVehiculoValido) {
            for (Registro registro : registros){
                total += registro.TiempoUso()*(administrador.tarifaVehiculo(vehiculo,vehiculo.getTarifaVehiculo()));
            }
        }
        return total;
    }

    /*
     * Metodo para retirar un vehiculo del parqueadero
     */
    public void retirarVehiculo(Vehiculo vehiculo1, Puesto[][] puestos){
        assert vehiculo1 != null : "El vehiculo no puede ser nulo";
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if(puestos[i][j].getPlaca().equals(vehiculo1.getPlaca())){
                    puestos[i][j].setPlaca("");
                    puestos[i][j].setDisponible(true);
                    Registro registro = new Registro(null,LocalTime.now(),vehiculo1);
                    registros.add(registro);
                    double total = costoTotalVehiculo(vehiculo1, administrador);
                    actualizarRecaudaciones(total);
                    System.out.println("Vehiculo ha sido retirado correctamente del puesto\n"+
                                        "["+i+","+j+"]\n");
                    return;
                }  
            }
        }
        
    } 

    

    public void retirarVehiculoLista(Vehiculo vehiculo1) {
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPlaca().equals(vehiculo1.getPlaca())){
                vehiculos.remove(vehiculo);
                return;
            }
        }
    }

    /*
     * Metodo para identificar el propietario de un vehiculo por la placa
     */
    public Propietario propietarioVehiculo(String placa){
        assert placa != null : "La placa no puede ser nula";
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPlaca().equals(placa)){
                return vehiculo.getPropietario();
            }
        }
        return null;
    }

    /*
     * Metodo para identificar el propietario del vehiculo por el nombre
     */
    public Propietario propietarioVehiculoNombre(String nombre){
        assert nombre != null : "El nombre no puede ser nulo";
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPropietario().getNombre().equals(nombre)){
                return vehiculo.getPropietario();
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
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)){
                return vehiculo;
            }else{
                return null;
            }
        }
        return null;
    }



    /**
     * Actualiza las recaudaciones diarias y mensuales con una nueva tarifa.
     *
     * @param tarifa Tarifa a añadir a las recaudaciones.
     */
    private void actualizarRecaudaciones(double tarifa) {
        recaudadoDia += tarifa; // Incrementa el total recaudado diario
        recaudadoMes += tarifa; // Incrementa el total recaudado mensual
    }

    /**
     * Genera y muestra un reporte diario de recaudación, desglosado por tipo de vehículo.
     */
    public void generarReporteDiario() {
        System.out.println("Reporte Diario:");
        System.out.println("Total recaudado: " + recaudadoDia);
        System.out.println("Desglosado por tipo de vehículo:");
    
        double totalCarros = 0;
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;
    
        for (Registro registro : registros) {
            if (registro.getHoraSalida() != null) {
                if (registro.getVehiculo() instanceof Carro) {
                    totalCarros += costoTotalVehiculo(registro.getVehiculo(), administrador);
                } else if (registro.getVehiculo() instanceof Moto) {
                    Moto moto = (Moto) registro.getVehiculo();
                    if (moto.getTipo() == TipoMoto.CLASICA) {
                        totalMotosClasicas += costoTotalVehiculo(registro.getVehiculo(), administrador);
                    } else if (moto.getTipo() == TipoMoto.HIBRIDA) {
                        totalMotosHibridas += costoTotalVehiculo(registro.getVehiculo(), administrador);
                    }
                }
            }
        }
    
        System.out.println("Carros: " + totalCarros);
        System.out.println("Motos Clásicas: " + totalMotosClasicas);
        System.out.println("Motos Híbridas: " + totalMotosHibridas);
        recaudadoDia = 0; // Reset diario
    }

    /**
     * Genera y muestra un reporte mensual de recaudación.
     */
    public void generarReporteMensual() {
        System.out.println("Reporte Mensual:");
        System.out.println("Total recaudado: " + recaudadoMes);
        recaudadoMes = 0; // Reset mensual

    
    }

    

    
}








    
