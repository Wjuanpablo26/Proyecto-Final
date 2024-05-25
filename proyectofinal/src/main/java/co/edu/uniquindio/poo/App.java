package co.edu.uniquindio.poo;
import java.util.Scanner;

public class App {

    private Puesto puestos;
    private Parqueadero parqueadero;    
    
    public static void main(String[] args) {
        //Creamos la calse escaner que nos va a ayudar
        Scanner scaner = new Scanner(System.in);
        //Le damos nuestras dimensiones al parqueadero
        System.out.println("Ingrese el nombre del parqueadero:");
        String nombre = scaner.nextLine();
        System.out.println("Ingrese una dimension del parqueadero:");
        int posicionI = scaner.nextInt();
        System.out.println("Ingrese la otra dimension del parqueadero:");
        int posicionJ = scaner.nextInt();


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
        do{
            System.out.println(" Que quieres hacer :\n1. Agregar un vehiculo\n" +
                                "2. Retirar un vehiculo\n" +
                                "3. Mostrar los puestos\n"+
                                "");                                 
            opc= scaner.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese el tipo de vehiculo:\n1.Moto\n2.Carro");
                    Vehiculo vehiculo = null;
                    int tipoVehiculo = scaner.nextInt();
                    switch (tipoVehiculo) {
                        case 1:
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
                        break;
                        case 2:
                        System.out.println("Ingrese la placa del carro:");
                        String placa1 = scaner.nextLine();
                        System.out.println("Ingrese el modelo del carro:");
                        String modelo1 = scaner.nextLine();
                        System.out.println("Ingrese el nombre del propietario del carro:");
                        String nombre1 = scaner.nextLine();
                        Propietario propietario1 = new Propietario(nombre1);
                        Carro carro = new Carro(placa1, modelo1, propietario1);
                        vehiculo = carro;
                            break;
                            
                            
                        default:
                            break;
                                
                            }
                    
                    
            

                    break;
                case 2:
                    
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                case 5:
                //SALIRRRR
                opc=99;
                break;
            
                default:
                System.out.println("Ingreso una opcion incorrecta");;
                    break;
            }
            
        }while(opc!=99);

        System.out.println("A continuacion elija una de las siguientes opciones");
        
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
    
        

        


    




