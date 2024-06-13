package ar.edu.unq.po2.sem;

import java.time.LocalDate;

public abstract class Compra {
    protected static int nroControl = 0;
    protected LocalDate fechaYHora;
    protected PuntoDeVenta puntoDeVenta;

    public Compra(LocalDate fechaYHora, PuntoDeVenta punto) {
        generarNroControl();
        this.fechaYHora = fechaYHora;
        this.puntoDeVenta = punto;
    }
	
    private synchronized int generarNroControl() {
        return ++nroControl;
    }
}