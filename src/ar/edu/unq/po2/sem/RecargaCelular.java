package ar.edu.unq.po2.sem;

import java.util.Date;

public class RecargaCelular extends Compra {
	private int monto;
	private int celular;

	public RecargaCelular(int nroControl, Date fechaYHora, int monto, int celular) {
		super(nroControl, fechaYHora);
		this.monto = monto;
		this.celular = celular;
	}

	public int getMonto() {
		return monto;
	}

	public int getCelular() {
		return celular;
	}

}