package ar.edu.unq.po2.sem;

import java.util.Date;

import ar.edu.unq.po2.sem.Compra;
import ar.edu.unq.po2.sem.PuntoDeVenta;

public class CompraPuntual extends Compra{
	private int cantHoras;
	private String patente;
	
	public CompraPuntual(int nroControl, Date fechaYHora, PuntoDeVenta punto, int cantHoras, String patente) {
		super(nroControl, fechaYHora, punto);
		this.cantHoras = cantHoras;
		this.patente = patente;
	}
	
	public int getCantHoras() {
		return cantHoras;
	}
	

}
