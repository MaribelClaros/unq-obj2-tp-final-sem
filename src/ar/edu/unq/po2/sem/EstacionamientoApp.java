package ar.edu.unq.po2.sem;

import java.time.LocalTime;

public class EstacionamientoApp extends Estacionamiento {
	protected int celular;
	
	public EstacionamientoApp(String patente, LocalTime inicio, LocalTime fin, boolean vigente, int celular) {
		this.patente = patente;
		this.horaInicio = inicio;
		this.horaFin = fin;
		this.esVigente = vigente;
		this.celular = celular;
	}
	
	public LocalTime horaMaximaFin(SEM sem, LocalTime horaInicio) {
		int horasRestantes = cantidadDeHs(horaInicio);
		int maximoHs = saldoDisponible(sem.getPrecioPorHora(), sem.getSaldoDe(this.getCelular()));
		int horasPosibles = Math.min(horasRestantes, maximoHs);
			return horaInicio.plusHours(horasPosibles);
    }
	
	public int cantidadDeHs(LocalTime inicio) {
		return 20 - inicio.getHour();
	}
	
	public int saldoDisponible(int tarifa, int saldo) {
		return saldo / tarifa;
	}
	
	public int getCelular() {
		return celular;
	}
}
