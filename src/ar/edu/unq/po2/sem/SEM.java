package ar.edu.unq.po2.sem;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class SEM implements Publisher{
	private static final int precioPorHora = 40;
	private static final LocalTime inicioFranjaHoraria = LocalTime.of(7, 0);
	private static final LocalTime finFranjaHoraria = LocalTime.of(20, 0);
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
	
	public int getPrecioPorHora() {
		return precioPorHora;
	}
	
	public void finalizarTodosLosEstacionamientos() {
		List<Estacionamiento> estacionamientosVigentes = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.estaVigente()).toList();
		estacionamientosVigentes.stream().forEach(estacionamiento -> estacionamiento.setEstaVigente(false));
	}
	
	public String generarEstacionamientoApp(App app) {
		if(app.getSaldo() >= this.getPrecioPorHora()) {
			EstacionamientoApp estacionamiento = new EstacionamientoApp(app.getPatente(), LocalTime.now(), this.calcularFinEstacionamientoApp(), true, app.getCelular());
			this.estacionamientos.add(estacionamiento);
			return this.getInformacionEstacionamiento(estacionamiento);
		}
		else {
			return this.getErrorEstacionamiento();
		}
		
	}
	
	private String getErrorEstacionamiento() {
		return "Saldo insuficiente. Estacionamiento no permitido.";
	}

	private String getInformacionEstacionamiento(EstacionamientoApp estacionamiento) {
		return "¡Estacionamiento exitoso! Hora inicio: " + estacionamiento.getHoraInicio() + ". Hora máxima fin: " + estacionamiento.getHoraFin();
	}

	private int calcularFinEstacionamientoApp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String finalizarEstacionamientoViaApp(int nroCelular) {
		Estacionamiento estacionamientoAFinalizar = this.estacionamientos.stream().filter(estacionamiento -> estacionamiento.getCelular() == nroCelular).findAny().orElseThrow();
		estacionamientoAFinalizar.setFinHoraFin(LocalTime.now());
		estacionamientoAFinalizar.setVigente(false);
		//this.estacionamientos.remove(estacionamientoAFinalizar);
		this.notificarFinEstacionamiento();
		return this.getInformacionFinEstacionamiento(estacionamientoAFinalizar);
	}
	
	private String getInformacionFinEstacionamiento(Estacionamiento estacionamiento) {
		int duracion = this.calcularDuracionEstacionamiento(estacionamiento.getHoraInicio(), estacionamiento.getHoraFin());
		
		return "Estacionamiento finalizado. Hora inicio: " + estacionamiento.getHoraInicio() + 
				". Hora fin: " + estacionamiento.getHoraFin() + 
				". Duración: "+ duracion  + 
				". Costo: " + this.calcularCostoEstacionamiento(duracion, this.getPrecioPorHora());
	}

	private int calcularCostoEstacionamiento(int duracion, int precioPorHora) {
		return duracion * precioPorHora;
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
		ZonaDeEstacionamiento zonaAConsultar = this.zonaDeEstacionamientos.stream().filter(zonaDeEstacionamiento -> zonaDeEstacionamiento.getInspector() == inspector.getNombreYApellido()).findAny().orElseThrow();
		Infraccion infraccion = new Infraccion(patente, dateNow, zonaAConsultar, inspector);
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
