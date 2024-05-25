package co.edu.uniquindio.poo;


import java.time.LocalTime;

public class Registro {

    public LocalTime horaIngreso;
    public LocalTime horaSalida;
    public boolean pago;
    public Vehiculo vehiculo;

    
    /*
    *constructor de la clase Registro
    */
public Registro(LocalTime horaIngreso,LocalTime horaSalida,Vehiculo vehiculo){
    assert horaIngreso != null : "La hora de ingreso no puede ser nula";
    assert horaSalida != null : "La hora de salida no puede ser nula";
    this.pago=false;
    this.horaIngreso = horaIngreso;
    this.horaSalida = horaSalida;
    this.vehiculo=vehiculo;
    }

    /*
    *metodo gets y sets
    */
    public LocalTime getHoraIngreso(){
    return horaIngreso;
    }

    public LocalTime getHorSalida(){
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

}
