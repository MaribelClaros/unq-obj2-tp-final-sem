package ar.edu.unq.po2.sem;

import java.time.LocalDate;

public class CompraPuntual extends Compra{
	private int cantHoras;
	private String patente;
	
	public CompraPuntual(LocalDate fechaYHora, PuntoDeVenta punto, int cantHoras, String patente) {
		super(fechaYHora, punto);
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
