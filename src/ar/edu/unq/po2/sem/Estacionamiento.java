package ar.edu.unq.po2.sem;

import java.time.LocalTime;

public abstract class Estacionamiento {
	protected String patente;
	protected LocalTime horaInicio;
	protected LocalTime horaFin;
	protected boolean esVigente = false;
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	public String getPatente() {
		return patente;
	}
	
	public boolean estaVigente() {
		return esVigente;
	}
	
	public void setEstaVigente(boolean esVigente) {
		this.esVigente = esVigente;
	}
}