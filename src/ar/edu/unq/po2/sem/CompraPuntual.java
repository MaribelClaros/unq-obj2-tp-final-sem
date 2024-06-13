package ar.edu.unq.po2.sem;

import java.util.Date;

public class CompraPuntual extends Compra{
	private int cantHoras;
	private String patente;
	
	public CompraPuntual(int nroControl, Date fechaYHora, PuntoDeVenta punto, int cantHoras, String patente) {
		super(nroControl, fechaYHora, punto);
		this.cantHoras = cantHoras;
		this.patente = patente;
	}
	
	public int getCantHoras() {
		return this.cantHoras;
	}
	
	public String getPatente() {
		return this.patente;
	}
	

}
