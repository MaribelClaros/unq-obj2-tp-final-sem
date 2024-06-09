package ar.edu.unq.po2.sem;

import java.util.List;
import java.util.Optional;


public class SEM {
	private List<ZonaDeEstacionamiento> zonaDeEstacionamientos;
	private List<Estacionamiento> estacionamientos;
	private List<Infraccion> infracciones;
	private List<Celular> nroCelulares;
	
	public SEM(List<zonaDeEstacionamiento> zonaDeEstacionamientos, List<Estacionamiento> estacionamientos, List<Infraccion> infracciones, List<Celular> nroCelulares) {
		this.zonaDeEstacionamientos = zonaDeEstacionamientos;
		this.estacionamientos = estacionamientos;
		this.infracciones = infracciones;
		this.nroCelulares = nroCelulares;
	}
	
	/*finalizarTodosLosEstacionamientos()
    + generarEstacionamiento(Estacionamiento estacionamiento)
    + finalizarEstacionamientoViaApp(int nroCelular)
    + consultarSaldo(int nrocelular): int
    + consultarEstacionamientoVigente(int patente): bool
    + altaInfraccion(int): void*/
	
	public void finalizarTodosLosEstacionamientos() {
		List<Estacionamiento> estacionamientosVigentes = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.estaVigente()).toList();
		estacionamientosVigentes.stream().forEach(estacionamiento -> estacionamiento.setEstaVigente(false));
	}
	
	public void generarEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamientos.add(estacionamiento);
	}
	
	public void finalizarEstacionamientoViaApp(int nroCelular) {
		
	}
	
	public int consultarSaldo(int celular) {
		Optional<Celular> nroAConsultar = this.nroCelulares.stream().filter(nroCelular -> nroCelular == celular).findFirst();
		if (nroAConsultar.isPresent()) {
			return nroAConsultar.getSaldo();
		} else {
			return 0; //TODO
		}
	}
	
	public boolean consultarEstacionamientoVigente(String patente) {
		Optional<Estacionamiento> estacionamientoAConsultar = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.getPatente() == patente).findFirst();
		if (estacionamientoAConsultar.isPresent()) {
			return estacionamientoAConsultar.getVigencia();
		} else {
			return false; //TODO
		}
	}
	
	public void altaInfraccion(String patente) {
		
	}
}
