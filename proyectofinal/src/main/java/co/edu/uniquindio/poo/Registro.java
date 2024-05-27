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
     * constructor de la clase Registro
     */
    public Registro(LocalTime horaIngreso, LocalTime horaSalida, Vehiculo vehiculo) {
        assert horaIngreso != null : "La hora de ingreso no puede ser nula";
        assert horaSalida != null : "La hora de salida no puede ser nula";
        this.pago = false;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.vehiculo = vehiculo;
    }

    /*
     * metodo gets y sets
     */
    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public String getPlaca() {
        return vehiculo.getPlaca();
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public long TiempoUso() {
        return horaSalida.getHour() - horaIngreso.getHour();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Parqueadero getCostoTotalVehiculo() {
        return getCostoTotalVehiculo();
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Registro [horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida + ", pago=" + pago + ", vehiculo="
                + vehiculo.toString() + ", tipoMoto=" + tipoMoto + ", parqueadero=" + parqueadero + "]";
    }

}
