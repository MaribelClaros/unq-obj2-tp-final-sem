package ar.edu.unq.po2.sem;

import java.time.LocalDate;


public class RecargaCelular extends Compra {
	private int monto;
	private int celular;

	public RecargaCelular(LocalDate fechaYHora, PuntoDeVenta punto, int monto, int celular) {
		super(fechaYHora, punto);
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
