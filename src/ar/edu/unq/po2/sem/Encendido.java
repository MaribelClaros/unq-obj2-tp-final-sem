package ar.edu.unq.po2.sem;

public class Encendido implements EstadoGPS {
    @Override
    public void cambiar(App app) {
        EstadoGPS nuevoEstado = new Apagado();
        app.setEstadoGPS(nuevoEstado);
    }

    @Override
    public boolean estaEncendido() {
        return true;
    }
}
