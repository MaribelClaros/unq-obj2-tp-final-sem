package ar.edu.unq.po2.sem;

import java.util.Date;

    public abstract class Compra {
    private int nroControl;
	private Date fechaYHora;
	private PuntoDeVenta puntoDeVenta;

	public Compra(int nroControl, Date fechaYHora, PuntoDeVenta punto) {
		this.nroControl = nroControl;
		this.fechaYHora = fechaYHora;
		this.puntoDeVenta = punto;
	}
	
	
}