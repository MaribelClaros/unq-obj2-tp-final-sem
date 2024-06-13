package ar.edu.unq.po2.sem;

import java.time.LocalDate;

public abstract class Compra {
    protected static int contadorNroControl = 0;
    protected int nroControl;
    protected LocalDate fechaYHora;
    protected PuntoDeVenta puntoDeVenta;

    public Compra(LocalDate fechaYHora, PuntoDeVenta punto) {
        this.nroControl = generarNroControl();
        this.fechaYHora = fechaYHora;
        this.puntoDeVenta = punto;
    }
	
    private synchronized int generarNroControl() {
        return ++contadorNroControl;
    }
}