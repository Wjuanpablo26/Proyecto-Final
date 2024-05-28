package co.edu.uniquindio.poo;
import java.util.Scanner;


public class App {

   // private Puesto puestos;
   // private Parqueadero parqueadero;    

    /*
     * Metodo principal de la aplicacion
     */
    
    public static void main(String[] args) throws InterruptedException {
        //Creamos la calse escaner que nos va a ayudar
        Scanner scanerInt = new Scanner(System.in);
        Scanner scanerString = new Scanner(System.in);
        Scanner scanerDouble = new Scanner(System.in);
        //Le damos nuestras dimensiones al parqueadero
    
        System.out.println("Ingrese el nombre del parqueadero:");
        String nombre = scanerString.nextLine();
        System.out.println("Ingrese una dimension del parqueadero:");
        int posicionI = scanerInt.nextInt();
        System.out.println("Ingrese la otra dimension del parqueadero:");
        int posicionJ = scanerInt.nextInt();
        //PEDIR DATOS PARA LOS COSTOS DE LOS VEHICULOS
        //System.out.println("Ingrese el costo de la moto clasica:");
        //double costoMotoClasica = scanerDouble.nextDouble();
        //System.out.println("Ingrese el costo de la moto hibrida:");
        //double costoMotoHibrida = scanerDouble.nextDouble();
        //System.out.println("Ingrese el costo del carro:");
        //double costoCarro = scanerDouble.nextDouble();


        /*
         * Creacion de la matriz de puestos
         */
        Puesto[][] puestos = new Puesto[posicionI][posicionJ];
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }


        //Creamos nuestro parqueadero
        Parqueadero parqueadero = new Parqueadero(nombre, puestos);
        int opc=0;

        //Menu de opciones
        do{
            System.out.println(" Que quieres hacer? :\n1. Agregar un vehiculo\n" +
                                "2. Retirar un vehiculo\n" +
                                "3. Identificar al propietario de un vehiculo\n"+
                                "4. Generar reporte\n"+
                                "5. cambiar la tarifa de un vehiculo\n"+
                                "6. Salir\n");                                 
            opc= scanerInt.nextInt();
            switch (opc) {

                //Agregar un vehiculo
                case 1:
                    System.out.println("Ingrese el tipo de vehiculo:\n1.Moto\n2.Carro");
                    Vehiculo vehiculo = null;
                    int tipoVehiculo = scanerInt.nextInt();
                    //scaner.nextLine();
                    switch (tipoVehiculo) {
                        case 1:
                        System.out.println("Ingrese la placa de la moto:");
                        String placa = scanerString.nextLine();
                        System.out.println("Ingrese el modelo de la moto:");
                        String modelo = scanerString.nextLine();
                        System.out.println("Ingrese el nombre del propietario de la moto:");
                        String nombre2 = scanerString.nextLine();
                        Propietario propietario = new Propietario(nombre2);
                        System.out.println("Ingrese la velocidad maxima de la moto:");
                        double velocidadMaxima = scanerDouble.nextDouble();
                        
                        //scaner.nextLine();
                        System.out.println("Ingrese el tipo de moto:");
                        System.out.println("1. Clasica");
                        System.out.println("2. Hibrida");
                        Moto moto = new Moto(placa, modelo, velocidadMaxima, propietario);
                        int tipo = scanerInt.nextInt();
                        if (tipo == 1){
                        moto.setTipo(TipoMoto.CLASICA);
                        System.out.println("El vehiculo se ha agregado correctamente\n");
                        } else if (tipo == 2){
                        moto.setTipo(TipoMoto.HIBRIDA);
                        System.out.println("El vehiculo se ha agregado correctamente\n"); 
                        } 
                        parqueadero.guardarMoto(moto);
                        break;
                        case 2:
                        System.out.println("Ingrese la placa del carro:");
                        String placa1 = scanerString.nextLine();
                        //scaner.nextLine();
                        System.out.println("Ingrese el modelo del carro:");
                        String modelo1 = scanerString.nextLine();
                        System.out.println("Ingrese el nombre del propietario del carro:");
                        String nombre1 = scanerString.nextLine();
                        Propietario propietario1 = new Propietario(nombre1);

                        Carro carro = new Carro(placa1, modelo1, propietario1);
                        parqueadero.guardarCarro(carro);
                        System.out.println("El vehiculo se ha agregado correctamente\n");
                        break;
                            }
                    break;
                    //Retirar un vehiculo
                case 2:
                    System.out.println("Ingrese la placa del vehiculo que desea retirar:");
                    String placa = scanerString.nextLine();
                    Vehiculo vehiculoRetirar = parqueadero.buscarVehiculo(placa);
                    if (vehiculoRetirar != null){
                        parqueadero.retirarVehiculo(vehiculoRetirar, parqueadero.puestos);
                        parqueadero.retirarVehiculoLista(vehiculoRetirar);
                        System.out.println("Vehiculo retirado correctamente\n");
                    }else{
                        System.out.println("El vehiculo no se encuentra en el parqueadero\n");
                    }
                break;

                //Identificar al propietario de un vehiculo
                case 3:
                    System.out.println("Ingrese la placa del vehiculo que desea buscar:");
                    String placaBuscar = scanerString.nextLine();
                    //scaner.nextLine();
                    Vehiculo vehiculoBuscar = parqueadero.buscarVehiculo(placaBuscar);
                    if (vehiculoBuscar != null){
                        System.out.println("El propietario del vehiculo es: "+vehiculoBuscar.getPropietario().getNombre()+"\n");
                    }else{
                        System.out.println("El vehiculo no se encuentra en el parqueadero\n");
                    }
                break;

                //Generar reporte
                case 4:
                System.out.println("Ingrese la opcion de reporte que desea generar:\n" 
                +  "1.Reporte diario:\n"+
                "2.Reporte Mensual:");
                int tipoReporte = scanerInt.nextInt();
                switch (tipoReporte) {
                    case 1:
                    parqueadero.generarReporteDiario();
                    break;
                    case 2:
                    parqueadero.generarReporteMensual();
                    break;
                }
                    
                break;

                //Cambiar la tarifa de un vehiculo
                case 5:
                    System.out.println("Ingrese el tipo de vehiculo al que desea cambiar la tarifa:\n"+"1.Moto\n"+"2.Carro");
                    Moto moto=null;
                    int tipoVehiculo1 = scanerInt.nextInt();
                    switch (tipoVehiculo1) {
                        case 1:
                        System.out.println("Ingrese el tipo de moto al que desea cambiar la tarifa:\n"+ "1.Moto clasica\\n"+ "2.Moto hibrida");
                        int tipo = scanerInt.nextInt();
                        if (tipo == 1){
                            System.out.println("Ingrese la nueva tarifa de la moto clasica:");
                            double tarifa = scanerDouble.nextDouble();
                            Administrador admin = new Administrador(nombre);
                            admin.tarifaVehiculo(moto, tarifa);
                            System.out.println("La tarifa de la moto clasica ha sido cambiada correctamente\n");
                        } else if (tipo == 2){
                            System.out.println("Ingrese la nueva tarifa de la moto hibrida:");
                            double tarifa = scanerDouble.nextDouble();
                            Administrador admin = new Administrador(nombre);
                            admin.tarifaVehiculo(moto, tarifa);
                            System.out.println("La tarifa de la moto hibrida ha sido cambiada correctamente\n");
                        }
                        break;
                        case 2:
                        Carro carro=null;
                        System.out.println("Ingrese la nueva tarifa del carro:");
                        double tarifa = scanerDouble.nextDouble();
                        Administrador admin = new Administrador(nombre);
                        admin.tarifaVehiculo(carro, tarifa);
                        System.out.println("La tarifa del carro ha sido cambiada correctamente\n");
                        break;
                    }
                        
                    
                break;

                //Salir
                case 6:
                System.out.println("Gracias por usar nuestro servicio");
                opc=0;
                

                break;
            
                default:
                System.out.println("Ingreso una opcion incorrecta");
                break;
            }
            
        }while(opc!=0); 
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

}
    
        

        


    




