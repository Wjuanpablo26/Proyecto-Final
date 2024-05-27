package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    private Puesto puestos;
    private Parqueadero parqueadero;

    public static void main(String[] args) {
        // Creamos el escáner que nos va a ayudar
        Scanner scaner = new Scanner(System.in);

        // Le damos nuestras dimensiones al parqueadero
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

        // Creamos nuestro parqueadero
        Parqueadero parqueadero = new Parqueadero(nombre, puestos);
        int opc = 0;
        do {
            System.out.println("Que quieres hacer? :\n1. Agregar un vehiculo\n" +
                    "2. Retirar un vehiculo\n" +
                    "3. Identificar al propietario de un vehiculo\n" +
                    "4. Generar reporte\n" +
                    "5. Cambiar la tarifa de un vehiculo\n" +
                    "6. Salir\n");
            Registro registro = new Registro(null, null, null);
            opc = scaner.nextInt();
            scaner.nextLine(); // Consumir la línea sobrante

            switch (opc) {
                case 1:
                    System.out.println("Ingrese el tipo de vehiculo:\n1. Moto\n2. Carro");
                    Vehiculo vehiculo = null;
                    int tipoVehiculo = scaner.nextInt();
                    scaner.nextLine(); // Consumir la línea sobrante

                    switch (tipoVehiculo) {
                        case 1:
                            System.out.println("Ingrese la placa de la moto:");
                            String placa = scaner.nextLine();
                            System.out.println("Ingrese el modelo de la moto:");
                            String modelo = scaner.nextLine();
                            System.out.println("Ingrese la velocidad maxima de la moto:");
                            double velocidadMaxima = scaner.nextDouble();
                            scaner.nextLine(); // Consumir la línea sobrante
                            System.out.println("Ingrese el nombre del propietario de la moto:");
                            String nombre2 = scaner.nextLine();
                            Propietario propietario = new Propietario(nombre2);

                            System.out.println("Ingrese el tipo de moto:");
                            System.out.println("1. Clasica");
                            System.out.println("2. Hibrida");
                            int tipo = scaner.nextInt();
                            scaner.nextLine(); // Consumir la línea sobrante

                            Moto moto = new Moto(placa, modelo, velocidadMaxima, propietario, registro);
                            if (tipo == 1) {
                                moto.setTipo(TipoMoto.CLASICA);
                            } else if (tipo == 2) {
                                moto.setTipo(TipoMoto.HIBRIDA);
                            }

                            registro.setVehiculo(moto);
                            registro.setHoraIngreso(LocalTime.now());
                            parqueadero.agregarVehiculo(moto);
                            System.out.println("El vehiculo se ha agregado correctamente\n");
                            break;

                        case 2:
                            System.out.println("Ingrese la placa del carro:");
                            String placa1 = scaner.nextLine();
                            System.out.println("Ingrese el modelo del carro:");
                            String modelo1 = scaner.nextLine();
                            System.out.println("Ingrese el nombre del propietario del carro:");
                            String nombre1 = scaner.nextLine();
                            Propietario propietario1 = new Propietario(nombre1);
                            System.out.println("Placa ingresada: " + placa1);

                            Vehiculo carro = new Carro(placa1, modelo1, propietario1, registro);
                            registro.setHoraIngreso(LocalTime.now());
                            registro.setVehiculo(carro);
                            parqueadero.agregarVehiculo(carro);
                            System.out.println("El vehiculo se ha agregado correctamente\n");

                            break;
                    }
                    break;

                case 2:
                    System.out.println("Ingrese la placa del vehiculo que desea retirar:");
                    registro.setHoraSalida(LocalTime.now());
                    String placaRetirar = scaner.nextLine();

                    Vehiculo vehiculoRetirar = parqueadero.buscarVehiculo(placaRetirar);
                    System.out.println(vehiculoRetirar);
                    if (vehiculoRetirar != null) {
                        Administrador admin = new Administrador(nombre);
                        parqueadero.retirarVehiculo(vehiculoRetirar, admin);
                        System.out.println("Vehiculo retirado correctamente\n");
                    } else {
                        System.out.println("El vehiculo no se encuentra en el parqueadero\n");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la placa del vehiculo que desea buscar:");
                    String placaBuscar = scaner.nextLine();
                    scaner.nextLine();
                    Vehiculo vehiculoBuscar = parqueadero.buscarVehiculo(placaBuscar);
                    if (vehiculoBuscar != null) {
                        System.out.println("El propietario del vehiculo es: "
                                + vehiculoBuscar.getPropietario().getNombre() + "\n");
                    } else {
                        System.out.println("El vehiculo no se encuentra en el parqueadero\n");
                    }
                    break;
                case 4:
                    System.out.println(
                            "Ingrese la opcion de reporte que desea generar:\n  1.Reporte diario:\n 2.Reporte Mensual:");
                    int tipoReporte = scaner.nextInt();
                    switch (tipoReporte) {
                        case 1:
                            parqueadero.generarReporteDiario();
                            break;
                        case 2:
                            parqueadero.generarReporteMensual();
                            break;
                    }

                    break;
                case 5:
                    System.out.println("Ingrese el tipo de vehiculo al que desea cambiar la tarifa:\n1.Moto\n2.Carro");
                    Moto moto = null;
                    int tipoVehiculo1 = scaner.nextInt();
                    switch (tipoVehiculo1) {
                        case 1:
                            System.out.println(
                                    "Ingrese el tipo de moto al que desea cambiar la tarifa:\\n 1.Moto clasica\\n 2.Moto hibrida");
                            int tipo = scaner.nextInt();
                            if (tipo == 1) {
                                System.out.println("Ingrese la nueva tarifa de la moto clasica:");
                                double tarifa = scaner.nextDouble();
                                Administrador admin = new Administrador(nombre);
                                admin.tarifaVehiculo(moto, tarifa);
                                System.out.println("La tarifa de la moto clasica ha sido cambiada correctamente\n");
                            } else if (tipo == 2) {
                                System.out.println("Ingrese la nueva tarifa de la moto hibrida:");
                                double tarifa = scaner.nextDouble();
                                Administrador admin = new Administrador(nombre);
                                admin.tarifaVehiculo(moto, tarifa);
                                System.out.println("La tarifa de la moto hibrida ha sido cambiada correctamente\n");
                            }
                            break;
                        case 2:
                            Carro carro = null;
                            System.out.println("Ingrese la nueva tarifa del carro:");
                            double tarifa = scaner.nextDouble();
                            Administrador admin = new Administrador(nombre);
                            admin.tarifaVehiculo(carro, tarifa);
                            System.out.println("La tarifa del carro ha sido cambiada correctamente\n");
                            break;
                    }

                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro servicio");
                    opc = 0;

                    break;

                default:
                    System.out.println("Ingreso una opcion incorrecta");
                    ;
                    break;
            }

        } while (opc != 0);
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
