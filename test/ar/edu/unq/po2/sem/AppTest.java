package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
	private App app;
	private Celular celular;
	private EstadoMovimiento estado;
	private SEM sem;
	
	@BeforeEach
	public void setUp() {
		celular = mock(Celular.class);
        estado = mock(EstadoMovimiento.class);
        sem = mock(SEM.class);
        app = new App(celular, "ABC123", estado, sem);
	}

    @Test
    public void testConsultarSaldo() {
        when(celular.getSaldo()).thenReturn(100);

        assertEquals(100, app.consultarSaldo());
    }

    @Test
    public void testAumentarSaldo() {
        app.aumentarSaldo(100);
        
        verify(celular, times(1)).aumentarSaldo(100);
        
    }

    @Test
    public void testIniciarEstacionamiento() {
        app.iniciarEstacionamiento();

        verify(sem, times(1)).generarEstacionamientoApp(app);
    }

    @Test
    public void testFinalizarEstacionamiento() {
        app.finalizarEstacionamiento();

        verify(sem, times(1)).finalizarEstacionamientoViaApp(app.getNroCelular());
    }

    @Test
    public void testSetEstadoGPS() {
        app.setEstadoGPS(true);

        assertTrue(app.getEstadoGPS());
    }

    @Test
    public void testSetEstado() {
        app.setEstado(estado);

        assertEquals(estado, app.getEstadoMovimiento());
    }

    @Test
    public void testSetModo() {
    	Modo automatico = mock(Automatico.class);
        when(automatico.toString()).thenReturn("Automatico");
        app.setModo(automatico);

        assertEquals("Automatico", app.getModo().toString());
    }

    @Test
    public void testGetModo() {
    	assertEquals(Manual.class, app.getModo().getClass());
    }

    @Test
    public void testGetCelular() {
        assertEquals(celular, app.getCelular());
    }

    @Test
    public void testGetNroCelular() {
        when(celular.getNumero()).thenReturn(1112345678);

        assertEquals(1112345678, app.getNroCelular());
    }

    @Test
    public void testSetNroCelular() {
        app.setNroCelular(8001234);

        verify(celular, times(1)).setNumero(8001234);
    }
}