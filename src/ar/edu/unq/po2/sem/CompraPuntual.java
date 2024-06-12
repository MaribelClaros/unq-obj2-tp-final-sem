package ar.edu.unq.po2.sem;

import java.util.Date;

public class CompraPuntual extends Compra{
	private int cantHoras;
	

	public CompraPuntual(int nroControl, Date fechaYHora, int cantHoras) {
		super(nroControl, fechaYHora);
		this.cantHoras = cantHoras;
	}
	

}
