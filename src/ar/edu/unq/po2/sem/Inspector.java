package ar.edu.unq.po2.sem;

public class Inspector {
	private static int idInspector;
	private String nombreYApellido;
	
	public Inspector(String nombreYApellido) {
		generarIdInspector();
		this.nombreYApellido = nombreYApellido;
	}
	
	private static void generarIdInspector() {
		idInspector++;
    }
	
	public static int getIdInspector() {
		return idInspector;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}
	
	
	public boolean estacionamientoVigente(SEM sem, String patente) {
		return sem.consultarEstacionamientoVigente(patente);
	}
	
	public void generarInfraccion(SEM sem, String patente) {
		if(!this.estacionamientoVigente(sem, patente)) {
			sem.altaInfraccion(this, patente);
		}
	}

}
