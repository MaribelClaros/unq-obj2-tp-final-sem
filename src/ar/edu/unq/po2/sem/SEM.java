package ar.edu.unq.po2.sem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class SEM implements Publisher{
	private List<ZonaDeEstacionamiento> zonaDeEstacionamientos;
	private List<Estacionamiento> estacionamientos;
	private List<Infraccion> infracciones;
	private List<Celular> nroCelulares;
	private List<Entidad> suscriptores;
	private List<Compra> compras;
	
	public SEM(List<ZonaDeEstacionamiento> zonaDeEstacionamientos, List<Estacionamiento> estacionamientos) {
		this.zonaDeEstacionamientos = zonaDeEstacionamientos;
		this.estacionamientos = estacionamientos;
		this.infracciones = new ArrayList<Infraccion>();
		this.nroCelulares = new ArrayList<Celular>();
		this.suscriptores =  new ArrayList<Entidad>();
		this.compras = new ArrayList<Compra>();
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
		if (estacionamiento.esValido()) {
			this.estacionamientos.add(estacionamiento);
			this.notificarInicioEstacionamiento();
		}
		
	}
	
	public void finalizarEstacionamientoViaApp(int nroCelular) {
		this.notificarFinEstacionamiento();
		
	}
	
	public boolean consultarEstacionamientoVigente(String patente) {
		Optional<Estacionamiento> estacionamientoAConsultar = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.getPatente() == patente).findFirst();
		if (estacionamientoAConsultar.isPresent()) {
			return estacionamientoAConsultar.getVigencia();
		} else {
			return false; //TODO
		}
	}
	
	public void altaInfraccion(Inspector inspector, String patente) {
		Date dateNow = new Date();
		Optional<ZonaDeEstacionamiento> zonaAConsultar = this.zonaDeEstacionamientos.stream().filter(zonaDeEstacionamiento -> zonaDeEstacionamiento.getInspector() == inspector.getNombreYApellido()).findFirst();
		Infraccion infraccion = new Infraccion(patente, dateNow, null, inspector);
		this.infracciones.add(infraccion);
	}
	
	public void nuevaCompraPuntual(CompraPuntual compra) {
		this.compras.add(compra);
	}
	
	public void nuevaRecargaCelular(RecargaCelular recarga) {
		this.compras.add(recarga);
	}

	@Override
	public void suscribirse(Entidad entidad) {
		this.suscriptores.add(entidad);
		
	}

	@Override
	public void desuscribirse(Entidad entidad) {
		this.suscriptores.remove(entidad);
		
	}

	@Override
	public void notificarInicioEstacionamiento() {
		this.suscriptores.forEach(entidad -> entidad.inicioEstacionamiento());
		
	}

	@Override
	public void notificarFinEstacionamiento() {
		this.suscriptores.forEach(entidad -> entidad.finEstacionamiento());
		
	}
	
	public void consultarSaldo(int nroCelular) {
		
	}
}
