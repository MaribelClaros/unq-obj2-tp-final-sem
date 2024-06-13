package ar.edu.unq.po2.sem;

public abstract class Modo {
    protected App app;

    public Modo(App app) {
        this.app = app;
    }

    protected void notificar(String mensaje) {
        System.out.println(mensaje);
    }

    abstract public void iniciarEstacionamiento();

    abstract public void finalizarEstacionamiento();
}
