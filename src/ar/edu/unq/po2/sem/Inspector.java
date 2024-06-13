package ar.edu.unq.po2.sem;

public class Inspector {
	private String nombreYApellido;
	
	/*generarInfraccion(String patente): void
      estacionamientoVigente(string): bool*/
	public Inspector(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
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
