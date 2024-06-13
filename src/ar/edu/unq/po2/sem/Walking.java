package ar.edu.unq.po2.sem;

public class Walking implements EstadoMovimiento {
    private App app;

    public Walking(App app) {
        this.app = app;
    }

    @Override
    public void driving() {
        EstadoMovimiento nuevoEstado = new Driving(this.app);
        this.app.setEstado(nuevoEstado);
        this.app.getModo().finalizarEstacionamiento();
    }

    @Override
    public void walking() {
    }
}
