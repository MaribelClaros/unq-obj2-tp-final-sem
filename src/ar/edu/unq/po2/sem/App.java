package ar.edu.unq.po2.sem;

public class App {
	private int celular;
	private String patente;
	private boolean estadoGPS = false;
	private Modo modo;
	private EstadoMovimiento estado;
	
	public App (int celular, String patente, boolean gps, Modo modo, EstadoMovimiento estado) {
		this.celular = celular;
		this.patente = patente;
		this.estadoGPS = gps;
		this.modo = modo;
		this.estado = estado;
	}
	
	public void iniciarEstacionamiento(SEM sem) {
		sem.generarEstacionamientoApp(this);
        setEstado(Walking);
        setModo(Automático);
	}
	
	public void finalizarEstacionamiento(SEM sem) {
		sem.finalizarEstacionamientoViaApp(this.getCelular());
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
