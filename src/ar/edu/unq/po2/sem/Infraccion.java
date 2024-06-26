package ar.edu.unq.po2.sem;

import java.util.Date;

public class Infraccion {
	private String patente;
	private Date fechaYHora;
	private ZonaDeEstacionamiento zonaDeEstacionamiento;
	private Inspector inspector;
	
	public Infraccion(String patente, Date fechaYHora, ZonaDeEstacionamiento zonaDeEstacionamiento, Inspector inspector) {
		this.patente = patente;
		this.fechaYHora = fechaYHora;
		this.zonaDeEstacionamiento = zonaDeEstacionamiento;
		this.inspector = inspector;
	}

	public String getPatente() {
		return patente;
	}

	public Date getFechaYHora() {
		return fechaYHora;
	}

	public ZonaDeEstacionamiento getZonaDeEstacionamiento() {
		return zonaDeEstacionamiento;
	}

	public Inspector getInspector() {
		return inspector;
	}


}
