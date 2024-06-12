package ar.edu.unq.po2.sem;

import java.util.List;

public class ZonaDeEstacionamiento {
	int idZona;
	Inspector inspector;
	List<PuntoDeVenta> puntosDeVenta;
	
	public ZonaDeEstacionamiento(int idZona, Inspector inspector, List<PuntoDeVenta> puntosDeVenta) {
		this.idZona = idZona;
		this.inspector = inspector;
		this.puntosDeVenta = puntosDeVenta;
	}

	public int getIdZona() {
		return idZona;
	}


	public String getInspector() {
		return inspector.getNombreYApellido();
	}

	public List<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}
	
	
}
