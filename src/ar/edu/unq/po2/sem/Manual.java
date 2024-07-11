package ar.edu.unq.po2.sem;

public class Manual extends Modo {
    @Override
    public void iniciarEstacionamiento(App app) {
        this.notificar("Posible inicio de Estacionamiento");
        app.getSem().generarEstacionamientoApp(app);
    }

    @Override
    public void finalizarEstacionamiento(App app) {
        this.notificar("Posible fin de Estacionamiento");
        app.getSem().finalizarEstacionamientoViaApp(app.getNroCelular());
    }
}
