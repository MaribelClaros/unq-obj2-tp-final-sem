package ar.edu.unq.po2.sem;

public class Inspector {
	String nombreYApellido;
	
	/*generarInfraccion(String patente): void
      estacionamientoVigente(string): bool*/
	public Inspector(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}
	
	
	public boolean estacionamientoVigente(String patente) {
		return true;
	}
	

}
