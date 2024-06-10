package ar.edu.unq.po2.sem;

import java.util.Date;

public class Infraccion {
	private String patente;
	private Date fechaYHora;
	private ZonaDeEstacionamiento zonaDeEstacionamiento;
	
	public Infraccion(String patente, Date fechaYHora, ZonaDeEstacionamiento zonaDeEstacionamiento) {
		this.patente = patente;
		this.fechaYHora = fechaYHora;
		this.zonaDeEstacionamiento = zonaDeEstacionamiento;
	}

}
