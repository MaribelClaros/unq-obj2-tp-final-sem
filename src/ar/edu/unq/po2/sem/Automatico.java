package ar.edu.unq.po2.sem;

public class Automatico extends Modo {
    public Automatico(App app) {
        super(app);
    }

    @Override
    public void iniciarEstacionamiento() {
        this.notificar("Inicio de Estacionamiento Automatico");
        this.app.iniciarEstacionamiento();
    }

    @Override
    public void finalizarEstacionamiento() {
        this.notificar("Fin de Estacionamiento Automatico");
        this.app.finalizarEstacionamiento();
    }
}
