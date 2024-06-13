package ar.edu.unq.po2.sem;

import java.util.Date;

import ar.edu.unq.po2.sem.Compra;
import ar.edu.unq.po2.sem.PuntoDeVenta;

public class RecargaCelular extends Compra {
	private int monto;
	private int celular;

	public RecargaCelular(int nroControl, Date fechaYHora, PuntoDeVenta punto, int monto, int celular) {
		super(nroControl, fechaYHora, punto);
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
