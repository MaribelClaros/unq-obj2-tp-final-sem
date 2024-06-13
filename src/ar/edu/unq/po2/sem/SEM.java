package ar.edu.unq.po2.sem;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class SEM implements Publisher{
	private static final int precioPorHora = 40;
	private static final LocalTime inicioFranjaHoraria = LocalTime.of(7, 0);
	private static final LocalTime finFranjaHoraria = LocalTime.of(20, 0);
	private List<ZonaDeEstacionamiento> zonaDeEstacionamientos;
	private List<Estacionamiento> estacionamientos;
	private List<Infraccion> infracciones;
	private HashMap<Integer, Integer> celulares;
	private List<Entidad> suscriptores;
	private List<Compra> compras;
	
	public SEM(List<ZonaDeEstacionamiento> zonaDeEstacionamientos) {
		this.zonaDeEstacionamientos = zonaDeEstacionamientos;
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.infracciones = new ArrayList<Infraccion>();
		this.celulares = new HashMap<>();
		this.suscriptores =  new ArrayList<Entidad>();
		this.compras = new ArrayList<Compra>();
	}
	
	//getters
	public int getPrecioPorHora() {
		return precioPorHora;
	}
	
	public List<ZonaDeEstacionamiento> getZonasDeEstacionamiento() {
		return this.zonaDeEstacionamientos;
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}
	
	public List<Infraccion> getInfracciones() {
		return this.infracciones;
	}
	
	public List<Compra> getCompras() {
		return this.compras;
	}
	
	public HashMap<Integer, Integer> getCelulares() {
		return this.celulares;
	}
	
	public void finalizarTodosLosEstacionamientos() {
		List<Estacionamiento> estacionamientosVigentes = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.estaVigente()).toList();
		estacionamientosVigentes.stream().forEach(estacionamiento -> estacionamiento.setVigente(false));
	}
	
	public String generarEstacionamientoApp(App app) {
		if(this.getSaldoDe(app.getNumeroCelular()) >= this.getPrecioPorHora()) {
			EstacionamientoApp estacionamiento = new EstacionamientoApp(app.getPatente(), LocalTime.now(), true, app.getNumeroCelular());
			estacionamiento.horaMaximaFin(this.getPrecioPorHora(), this.consultarSaldo(app.getNumeroCelular());
			this.estacionamientos.add(estacionamiento);
			this.notificarInicioEstacionamiento(estacionamiento);
			
			return this.mostrarInformacionEstacionamiento(estacionamiento);
		}
		else {
			return this.mostrarErrorEstacionamiento();
		}	
	}
	
	public void agregarEstacionamientoPuntoVenta(EstacionamientoPuntoVenta estacionamiento) {
		this.estacionamientos.add(estacionamiento);
	}
	
	
	private String mostrarErrorEstacionamiento() {
		return "Saldo insuficiente. Estacionamiento no permitido.";
	}

	private String mostrarInformacionEstacionamiento(EstacionamientoApp estacionamiento) {
		return "¡Estacionamiento exitoso! Hora inicio: " + estacionamiento.getHoraInicio() + ". Hora máxima fin: " + estacionamiento.getHoraFin();
	}


	public String finalizarEstacionamientoViaApp(int nroCelular) {
		Estacionamiento estacionamientoAFinalizar = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.getCelular() == nroCelular).findAny().orElseThrow();
		estacionamientoAFinalizar.setHoraFin(LocalTime.now());
		estacionamientoAFinalizar.setVigente(false);
		this.descontarSaldoDeEstacionamiento(estacionamientoAFinalizar, nroCelular);
		this.notificarFinEstacionamiento(estacionamientoAFinalizar);
		return this.mostrarInformacionFinEstacionamiento(estacionamientoAFinalizar);
	}
	
	private void descontarSaldoDeEstacionamiento(Estacionamiento estacionamiento, int nroCelular) {
		int duracion = this.calcularDuracionEstacionamiento(estacionamiento.getHoraInicio(), estacionamiento.getHoraFin());
		this.celulares.put(nroCelular, this.celulares.get(nroCelular) - this.calcularCostoEstacionamiento(duracion));
	}


	private String mostrarInformacionFinEstacionamiento(Estacionamiento estacionamiento) {
		int duracion = this.calcularDuracionEstacionamiento(estacionamiento.getHoraInicio(), estacionamiento.getHoraFin());
		
		return "Estacionamiento finalizado. Hora inicio: " + estacionamiento.getHoraInicio() + 
				". Hora fin: " + estacionamiento.getHoraFin() + 
				". Duración: "+ duracion  + 
				". Costo: " + this.calcularCostoEstacionamiento(duracion);
	}

	private int calcularCostoEstacionamiento(int duracion) {
		return duracion * this.getPrecioPorHora();
	}
	
	private int calcularDuracionEstacionamiento(LocalTime inicio, LocalTime fin) {
		return (int) inicio.until(fin, ChronoUnit.HOURS);
	}
	
	public int consultarSaldo(int nroCelular) {
		return (celulares.containsKey(nroCelular)) ? celulares.get(nroCelular) : 0;
	}

	public boolean consultarEstacionamientoVigente(String patente) {
		Optional<Estacionamiento> estacionamientoAConsultar = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.getPatente() == patente).findFirst();
		if (estacionamientoAConsultar.isPresent()) {
			return estacionamientoAConsultar.getVigencia();
		} else {
			return false;
		}
	}
	
	public void altaInfraccion(Inspector inspector, String patente) {
		Date dateNow = new Date();
		ZonaDeEstacionamiento zonaAConsultar = this.zonaDeEstacionamientos.stream().filter(zonaDeEstacionamiento -> zonaDeEstacionamiento.getInspector() == inspector.getNombreYApellido()).findAny().orElseThrow();
		Infraccion infraccion = new Infraccion(patente, dateNow, zonaAConsultar, inspector);
		this.infracciones.add(infraccion);
	}
	
	public void nuevaCompraPuntual(CompraPuntual compra) {
		this.compras.add(compra);
	}
	
	public void nuevaRecargaCelular(RecargaCelular recarga) {
		this.celulares.put(recarga.getCelular(), this.consultarSaldo(recarga.getCelular()) + recarga.getMonto());
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
	public void notificarInicioEstacionamiento(Estacionamiento estacionamiento) {
		this.suscriptores.forEach(entidad -> entidad.inicioEstacionamiento(estacionamiento));
		
	}

	@Override
	public void notificarFinEstacionamiento(Estacionamiento estacionamiento) {
		this.suscriptores.forEach(entidad -> entidad.finEstacionamiento(estacionamiento));
		
	}
	
}
