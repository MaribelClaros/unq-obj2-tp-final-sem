package ar.edu.unq.po2.sem;

import ar.edu.unq.po2.sem.EstacionamientoPuntoVenta;

public class PuntoDeVenta {
	private String zona;
	
	public PuntoDeVenta(String z) {
		this.zona = z;
	}
	
	public void recargarCelular(int número, int monto) {
		sem.nuevaRecargaCelular(número, monto);
	}
	
	public EstacionamientoPuntoVenta comprarEstacionamiento(int cantHoras, String patente) {
		CompraPuntual compra = new CompraPuntual(0, fechaYHora, this.zona, cantHoras, patente);
		sem.nuevaCompraPuntual(compra);
		sem.generarEstacionamiento(); // ??
	}
}
    