package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PuntoDeVentaTest {
	private PuntoDeVenta puntoDeVenta;
    private SEM sem;
    private App app;
    private ZonaDeEstacionamiento zona;

    @BeforeEach
    public void setUp() {
        sem = mock(SEM.class);
        app = mock(App.class);
        zona = mock(ZonaDeEstacionamiento.class);
        
        puntoDeVenta = new PuntoDeVenta(zona);
    }

    @Test
    public void testRecargarCelular() {

    	puntoDeVenta.recargarCelular(sem, app, 100);

        verify(app, times(1)).getNroCelular();
        verify(sem, times(1)).nuevaRecargaCelular(any(RecargaCelular.class), eq(app));
    }

    @Test
    public void testComprarEstacionamiento() {

        puntoDeVenta.comprarEstacionamiento(sem, 2, "ABC123");

        verify(sem, times(1)).nuevaCompraPuntual(any(CompraPuntual.class));
        verify(sem, times(1)).agregarEstacionamientoPuntoVenta(any(EstacionamientoPuntoVenta.class));
    }

    @Test
    public void testHoraDeFinDeCompra() {

        assertEquals(LocalTime.now().plusHours(2), puntoDeVenta.horaDeFinDeCompra(2));
    }
}
