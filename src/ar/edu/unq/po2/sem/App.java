package ar.edu.unq.po2.sem;

public class App {
	private int celular;
	private String patente;
	private boolean estadoGPS = false;
	private Modo modo;
	private EstadoMovimiento estado;
	private SEM sem;
	
	public App (int celular, String patente, boolean gps, Modo modo, EstadoMovimiento estado, SEM sem) {
		this.celular = celular;
		this.patente = patente;
		this.estadoGPS = gps;
		this.modo = modo;
		this.estado = estado;
		this.sem = sem;
	}
	
	public void iniciarEstacionamiento() {
		this.sem.generarEstacionamientoApp(this);
	}
	
	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamientoViaApp(this.getCelular());
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

	public int getCelular() {
		return celular;
	}
	
	public String getPatente() {
		return patente;
	}
}
