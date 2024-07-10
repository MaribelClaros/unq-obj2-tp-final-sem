package ar.edu.unq.po2.sem;

import java.time.LocalTime;

public class EstacionamientoPuntoVenta extends Estacionamiento {
	
	public EstacionamientoPuntoVenta(String patente, LocalTime inicio, LocalTime fin) {
		this.patente = patente;
		this.horaInicio = inicio;
		this.horaFin = fin;
		this.esVigente = true;
	}
}
