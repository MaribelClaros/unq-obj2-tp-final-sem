package ar.edu.unq.po2.sem;

public class Apagado implements EstadoGPS {
    @Override
    public void cambiar(App app) {
        EstadoGPS nuevoEstado = new Encendido();
        app.setEstadoGPS(nuevoEstado);
    }

    @Override
    public boolean estaEncendido() {
        return false;
    }
}
