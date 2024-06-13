package ar.edu.unq.po2.sem;

public abstract class Estacionamiento {
	protected String patente;
	protected int horaInicio;
	protected int horaFin;
	protected boolean esVigente = false;
	protected int tarifaPorHora;
	
	abstract boolean estaVigente();
	abstract boolean esValido();
}
