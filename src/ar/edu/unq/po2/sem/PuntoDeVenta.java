package ar.edu.unq.po2.sem;

import java.time.LocalDate;
import java.time.LocalTime;

public class PuntoDeVenta {
	private ZonaDeEstacionamiento zona;
	
	public PuntoDeVenta(ZonaDeEstacionamiento z) {
		this.zona = z;
	}
	
	public void recargarCelular(SEM sem, int celular, int monto) {
		RecargaCelular recarga = new RecargaCelular (LocalDate.now(), this, monto, celular);
		sem.nuevaRecargaCelular(recarga);
	}
	
	public void comprarEstacionamiento(SEM sem, int cantHoras, String patente) {
		CompraPuntual compra = new CompraPuntual(LocalDate.now(), this, cantHoras, patente);		
		sem.nuevaCompraPuntual(compra);
		EstacionamientoPuntoVenta estacionamiento = new EstacionamientoPuntoVenta(patente, LocalTime.now(), this.horaDeFinDeCompra(cantHoras), true);
		sem.agregarEstacionamientoPuntoVenta(estacionamiento);
	}
	
	public LocalTime horaDeFinDeCompra(int cantHoras) {
		return LocalTime.now().plusHours(cantHoras);
	}
}