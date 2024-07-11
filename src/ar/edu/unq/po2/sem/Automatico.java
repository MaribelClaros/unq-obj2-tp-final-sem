package ar.edu.unq.po2.sem;

public class Automatico extends Modo {
    @Override
    public void iniciarEstacionamiento(App app) {
        if (app.getEstadoGPS().estaEncendido() && !app.getEstadoMovimiento().isDriving()) {
            this.notificar("Inicio de Estacionamiento Automatico");
            app.getSem().generarEstacionamientoApp(app);
        }
    }

    @Override
    public void finalizarEstacionamiento(App app) {
        if (app.getEstadoGPS().estaEncendido() && app.getEstadoMovimiento().isDriving()) {
            this.notificar("Fin de Estacionamiento Automatico");
            app.getSem().finalizarEstacionamientoViaApp(app.getNroCelular());
        }
    }
}
