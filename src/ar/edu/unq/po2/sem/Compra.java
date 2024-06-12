package ar.edu.unq.po2.sem;

import java.util.Date;

public abstract class Compra {
	private int nroControl;
	private Date fechaYHora;

	public Compra(int nroControl, Date fechaYHora) {
		this.nroControl = nroControl;
		this.fechaYHora = fechaYHora;
	}
	
	
}
