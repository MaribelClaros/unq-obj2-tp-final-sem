package ar.edu.unq.po2.sem;

public class Driving implements EstadoMovimiento {
    private App app;

    public Driving(App app) {
        this.app = app;
    }

    @Override
    public void driving() {
    }

    @Override
    public void walking() {
        EstadoMovimiento nuevoEstado = new Walking(this.app);
        this.app.setEstadoMovimiento(nuevoEstado);
    }

    @Override
    public boolean isDriving() {
        return true;
    }
}
