package ar.edu.unq.po2.sem;

public abstract class Modo {
    protected void notificar(String mensaje) {
        System.out.println(mensaje);
    }

    abstract public void iniciarEstacionamiento(App app);

    abstract public void finalizarEstacionamiento(App app);
}
