package ar.edu.unq.po2.sem;

import ar.edu.unq.po2.sem.EstacionamientoApp;

public class App {
	private boolean estadoGPS = false;
	private Modo modo;
	private EstadoMovimiento estado;
	
	public App (boolean gps, Modo modo, EstadoMovimiento estado) {
		this.estadoGPS = gps;
		this.modo = modo;
		this.estado = estado;
	}
	
	public void iniciarEstacionamiento(EstacionamientoApp e) {
		if (sem.consultarSaldo(e.celular) > e.tarifaPorHora &&
		    e.horaInicio >= 7 && e.horaInicio < 20) {
			sem.generarEstacionamiento(
			 new EstacionamientoApp(e.patente, e.horaInicio, e.horaFin, true, 
		    sem.consultarSaldo(e.celular), e.tarifaPorHora));
			setEstado(Walking);
            setModo(Automático);
            System.out.println("Inicio de estacionamiento a las " + 
            e.horaInicio + ", fin máximo a las " + horaMaximaFin(e.tarifaPorHora, 
            e.horaInicio, sem.consultarSaldo(e.celular)));      
        } else {
            System.out.println("Saldo insuficiente. Estacionamiento no permitido.");
        }
	}
	
	public int horaMaximaFin(int tarifa, int horaInicio, int saldo) {
		int horasRestantes = cantidadDeHs(horaInicio);
		int maximoHs = saldoDisponible(tarifa, saldo);
		int horasPosibles = Math.min(horasPosibles, maximoHs);
			return horaInicio + horasPosibles;
    }
	
	public int cantidadDeHs(int inicio) {
		return 20 - inicio;
	}
	
	public int saldoDisponible(int tarifa, int saldo) {
		return saldo / tarifa;
	}
	
	public void finalizarEstacionamiento(EstacionamientoApp e) {
		sem.finalizarEstacionamientoViaApp(e.celular);
	}
	
	public void setEstado(EstadoMovimiento e) {
		this.estado = e; 
	}
	
    public void setEstadoGPS(boolean estado) {
    	this.estadoGPS = estado;
	}
	
	public void setModo(Modo m) {
		this.modo = m;
    }

}
