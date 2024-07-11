package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
	private App app;
	private Celular celular;
    private Modo modo;
	private SEM sem;
	
	@BeforeEach
	public void setUp() {
		celular = mock(Celular.class);
        modo = mock(Modo.class);
        sem = mock(SEM.class);
        app = new App(celular, "ABC123", sem);
	}

    @Test
    public void testIniciarEstacionamiento() {
        app.setModo(modo);
        app.iniciarEstacionamiento();

        verify(modo, times(1)).iniciarEstacionamiento(app);
    }

    @Test
    public void testFinalizarEstacionamiento() {
        app.setModo(modo);
        app.finalizarEstacionamiento();

        verify(modo, times(1)).finalizarEstacionamiento(app);
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
    public void testEstadoMovimiento() {
        assertEquals(Walking.class, app.getEstadoMovimiento().getClass());
        Driving driving = mock(Driving.class);
        app.setEstadoMovimiento(driving);

        assertNotEquals(Walking.class, app.getEstadoMovimiento().getClass());
        assertEquals(driving, app.getEstadoMovimiento());
    }

    @Test
    public void testModo() {
        assertEquals(Manual.class, app.getModo().getClass());
    	Modo automatico = mock(Automatico.class);
        app.setModo(automatico);

        assertNotEquals(Manual.class, app.getModo().getClass());
        assertEquals(automatico, app.getModo());
    }

    @Test
    public void testEstadoGPS() {
        assertEquals(Encendido.class, app.getEstadoGPS().getClass());
        EstadoGPS estadoGPS = mock(Apagado.class);
        app.setEstadoGPS(estadoGPS);
        assertNotEquals(Encendido.class, app.getEstadoGPS().getClass());
        assertEquals(estadoGPS, app.getEstadoGPS());
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