package ar.edu.unq.po2.sem;

public class Manual extends Modo {
    public Manual(App app) {
        super(app);
    }

    @Override
    public void iniciarEstacionamiento() {
        this.notificar("Posible inicio de Estacionamiento");
    }

    @Override
    public void finalizarEstacionamiento() {
        this.notificar("Posible fin de Estacionamiento");
    }
}
