package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstacionamientoPuntoVentaTest {
    private EstacionamientoPuntoVenta estacionamiento;

    @BeforeEach
    public void setUp() {
        estacionamiento = new EstacionamientoPuntoVenta("DEF456", LocalTime.of(15, 0), LocalTime.of(19, 0));
    }

    @Test
    public void testHoraInicio() {
        assertEquals(LocalTime.of(15, 0), estacionamiento.getHoraInicio());
    }

    @Test
    public void testHoraFin() {
        assertEquals(LocalTime.of(19, 0), estacionamiento.getHoraFin());
    }

    @Test
    public void testPatente() {
        assertEquals("DEF456", estacionamiento.getPatente());
    }

    @Test
    public void testEstaVigente() {
        assertTrue(estacionamiento.estaVigente());
    }

    @Test
    public void testSetEstaVigente() {
    	estacionamiento.setEstaVigente(false);
    	estacionamiento.setEstaVigente(true);
        assertTrue(estacionamiento.estaVigente());
    }

    @Test
    public void testSetHoraFin() {
        estacionamiento.setHoraFin(LocalTime.of(18, 0));
        assertEquals(LocalTime.of(18, 0), estacionamiento.getHoraFin());
    }
}