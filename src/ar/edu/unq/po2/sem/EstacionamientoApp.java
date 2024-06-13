package ar.edu.unq.po2.sem;

import ar.edu.unq.po2.sem.Estacionamiento;

public class EstacionamientoApp extends Estacionamiento {
	protected int celular;
	
	public EstacionamientoApp(String patente, int inicio, int fin, boolean vigente, int tarifa, int celular) {
		this.patente = patente;
		this.horaInicio = inicio;
		this.horaFin = fin;
		this.esVigente = vigente;
		this.tarifaPorHora = tarifa;
		this.celular = celular;
	}
	
	public boolean estaVigente() {
		
	}
	
	public boolean esValido() {
		
	}

}
