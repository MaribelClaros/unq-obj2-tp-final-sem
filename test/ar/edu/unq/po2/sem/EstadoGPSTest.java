package ar.edu.unq.po2.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EstadoGPSTest {
    private App app;

    @BeforeEach
    public void setUp() {
        app = new App(mock(Celular.class), "ABC123", mock(SEM.class));
    }

    @Test
    public void testApagado() {
        Apagado apagado = new Apagado();

        assertFalse(apagado.estaEncendido());
        apagado.cambiar(app);
        assertEquals(Encendido.class, app.getEstadoGPS().getClass());
    }

    @Test
    public void testENcendido() {
        Encendido encendido = new Encendido();

        assertTrue(encendido.estaEncendido());
        encendido.cambiar(app);
        assertEquals(Apagado.class, app.getEstadoGPS().getClass());
    }
}
