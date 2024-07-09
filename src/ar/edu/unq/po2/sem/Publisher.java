package ar.edu.unq.po2.sem;

public interface Publisher {
	
	public void suscribirse(Entidad entidad);
	public void desuscribirse(Entidad entidad);
	public void notificarInicioEstacionamiento(Estacionamiento estacionamiento);
	public void notificarFinEstacionamiento(Estacionamiento estacionamiento);
}
