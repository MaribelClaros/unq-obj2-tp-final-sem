package ar.edu.unq.po2.sem;

import java.util.List;

public interface Publisher {
	
	public void suscribirse(Entidad entidad);
	public void desuscribirse(Entidad entidad);
	public void notificarInicioEstacionamiento(Estacionamiento estacionamiento);
	public void notificarFinEstacionamiento(Estacionamiento estacionamiento);
}
