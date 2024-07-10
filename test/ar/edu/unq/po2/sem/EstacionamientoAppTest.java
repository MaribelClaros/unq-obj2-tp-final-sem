package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstacionamientoAppTest {
	private EstacionamientoApp estacionamiento;
    private Celular celular;
    private SEM sem;
    
    @BeforeEach
    public void setUp() {
    	celular = mock(Celular.class);
    	sem = mock(SEM.class);
    	estacionamiento = new EstacionamientoApp("ABC123", LocalTime.of(9, 0), celular);
    }
    
    @Test
    public void testHoraInicio() {
        assertEquals(LocalTime.of(9, 0), estacionamiento.getHoraInicio());
    }
    
    @Test
    public void testHoraFin() {
    	assertEquals(null, estacionamiento.getHoraFin());
    }
    
    @Test
    public void testPatente() {
        assertEquals("ABC123", estacionamiento.getPatente());
    }
    
    @Test
    public void testEstaVigente() {
        assertTrue(estacionamiento.estaVigente());
    }
    
    @Test
    public void testSetEstaVigente() {
        estacionamiento.setEstaVigente(false);
        assertFalse(estacionamiento.estaVigente());
    }
    
    @Test
    public void testSetHoraFin() {
        estacionamiento.setHoraFin(LocalTime.of(18, 0));
        assertEquals(LocalTime.of(18, 0), estacionamiento.getHoraFin());
    }
    
    @Test
    public void testHoraMaximaFin() {
        when(sem.getPrecioPorHora()).thenReturn(10);
        when(celular.getSaldo()).thenReturn(30);

        LocalTime horaInicio = LocalTime.of(9, 0);
        
        assertEquals(horaInicio.plusHours(3), 
        		estacionamiento.horaMaximaFin(sem, horaInicio));
        verify(sem, times(1)).getPrecioPorHora();
        verify(celular, times(1)).getSaldo();
    }
    
    @Test
    public void testCantidadDeHs() {
        assertEquals(11, estacionamiento.cantidadDeHs(LocalTime.of(9, 0)));
        assertEquals(1, estacionamiento.cantidadDeHs(LocalTime.of(19, 0)));
    }
    
    @Test
    public void testSaldoDisponible() {
        assertEquals(2, estacionamiento.saldoDisponible(10, 20));
        assertEquals(3, estacionamiento.saldoDisponible(15, 45));
    }
    
}
