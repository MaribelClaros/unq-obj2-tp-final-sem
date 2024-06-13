package ar.edu.unq.po2.sem;

import ar.edu.unq.po2.sem.Estacionamiento;

public class EstacionamientoPuntoVenta extends Estacionamiento {
	
	public EstacionamientoPuntoVenta(String patente, int inicio, int fin, boolean vigente, int tarifa) {
		this.patente = patente;
		this.horaInicio = inicio;
		this.horaFin = fin;
		this.esVigente = vigente;
		this.tarifaPorHora = tarifa;
	}
	
	public boolean estaVigente() {
		
	}
	
	public boolean esValido() {
	
	}

}
