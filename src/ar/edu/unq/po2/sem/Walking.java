package ar.edu.unq.po2.sem;

public class Walking implements EstadoMovimiento {
    private App app;

    public Walking(App app) {
        this.app = app;
    }

    @Override
    public void driving() {
        EstadoMovimiento nuevoEstado = new Driving(this.app);
        this.app.setEstadoMovimiento(nuevoEstado);
    }

    @Override
    public void walking() {
    }

    @Override
    public boolean isDriving() {
        return false;
    }
}
