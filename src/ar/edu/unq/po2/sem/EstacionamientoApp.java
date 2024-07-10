package ar.edu.unq.po2.sem;

import java.time.LocalTime;

public class EstacionamientoApp extends Estacionamiento {
	protected Celular celular;
	
	public EstacionamientoApp(String patente, LocalTime inicio, Celular celular) {
		this.patente = patente;
		this.horaInicio = inicio;
		this.esVigente = true;
		this.celular = celular;
	}
	
	public LocalTime horaMaximaFin(SEM sem, LocalTime horaInicio) {
		int horasRestantes = cantidadDeHs(horaInicio);
		int maximoHs = saldoDisponible(sem.getPrecioPorHora(), celular.getSaldo());
		int horasPosibles = Math.min(horasRestantes, maximoHs);
			return horaInicio.plusHours(horasPosibles);
    }
	
	public int cantidadDeHs(LocalTime inicio) {
		return 20 - inicio.getHour();
	}
	
	public int saldoDisponible(int tarifa, int saldo) {
		return saldo / tarifa;
	}
	
	public Celular getCelular() {
		return this.celular;
	}
}
