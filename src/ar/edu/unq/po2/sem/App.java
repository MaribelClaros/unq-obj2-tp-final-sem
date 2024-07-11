package ar.edu.unq.po2.sem;

public class App implements MovementSensor {
	private Celular celular;
	private final String patente;
	private EstadoGPS estadoGPS;
	private Modo modo;
	private EstadoMovimiento estadoMovimiento;
	private SEM sem;
	
	public App (Celular celular, String patente, SEM sem) {
		this.celular = celular;
		this.patente = patente;
		this.estadoGPS = new Encendido();
		this.modo = new Manual();
		this.estadoMovimiento = new Walking(this);
		this.sem = sem;
	}

	public void iniciarEstacionamiento() {
		this.modo.iniciarEstacionamiento(this);
	}

	public void finalizarEstacionamiento() {
		this.modo.finalizarEstacionamiento(this);
	}

	public int consultarSaldo() {
		return this.celular.getSaldo();
	}
	
	public void aumentarSaldo(int saldoAAumentar) {
		this.celular.aumentarSaldo(saldoAAumentar);
	}
	
	public void setEstadoMovimiento(EstadoMovimiento e) {
		this.estadoMovimiento = e;
	}
	
	public EstadoMovimiento getEstadoMovimiento() {
		return this.estadoMovimiento;
	}
	
    public void setEstadoGPS(EstadoGPS estado) {
    	this.estadoGPS = estado;
	}
    
    public EstadoGPS getEstadoGPS() {
    	return this.estadoGPS;
	}
	
	public void setModo(Modo m) {
		this.modo = m;
    }

	public Modo getModo() {
		return modo;
	}
	
	public Celular getCelular() {
		return this.celular;
	}

	public int getNroCelular() {
		return celular.getNumero();
	}
	
	public void setNroCelular(int numero) {
		this.celular.setNumero(numero);
	}
	
	public String getPatente() {
		return patente;
	}

	@Override
	public void driving() {
		this.estadoMovimiento.driving();
	}

	@Override
	public void walking() {
		this.estadoMovimiento.walking();
	}

	public SEM getSem() {
		return this.sem;
	}
}
