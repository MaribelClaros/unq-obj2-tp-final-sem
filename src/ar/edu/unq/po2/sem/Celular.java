package ar.edu.unq.po2.sem;

public class Celular {
	private int numero;
	private int saldo;
	
	public Celular(int numero) {
		this.numero = numero;
		this.saldo = 0;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getSaldo() {
		return saldo;
	}

	public void aumentarSaldo(int cantidadAAumentar) {
		this.saldo += cantidadAAumentar;
	}
	
	public void descontarSaldo(int cantidadADescontar) {
		this.saldo -= cantidadADescontar;
	}

}
