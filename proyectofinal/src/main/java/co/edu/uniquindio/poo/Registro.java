package co.edu.uniquindio.poo;


import java.time.LocalTime;

public class Registro {

    public LocalTime horaIngreso;
    public LocalTime horaSalida;
    public boolean pago;
    public Vehiculo vehiculo;
    public Moto tipoMoto;
    public Parqueadero parqueadero;


    
    /*
    *constructor de la clase Registro
    */
    public Registro(LocalTime horaIngreso,LocalTime horaSalida,Vehiculo vehiculo){
    this.pago=false;
    this.horaIngreso = horaIngreso;
    this.horaSalida = horaSalida;
    this.vehiculo = vehiculo;
    }

    /*
    *metodo gets y sets
    */
    public LocalTime getHoraIngreso(){
    return horaIngreso;
    }

    public LocalTime getHoraSalida(){
    return horaSalida;
    }


    public Vehiculo getPlaca(){
        return getPlaca();
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public long TiempoUso(){
        return horaSalida.getHour() - horaIngreso.getHour();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /*
     * Metodo para calcular el costo total del vehiculo
     */
    public Parqueadero getCostoTotalVehiculo(){
        return getCostoTotalVehiculo();
    }

    

}
