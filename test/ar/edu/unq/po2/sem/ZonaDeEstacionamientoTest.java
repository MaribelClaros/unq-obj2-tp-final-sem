package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZonaDeEstacionamientoTest {
	private Inspector inspector;
	private PuntoDeVenta puntoDeVenta;
	private ZonaDeEstacionamiento zonaDeEstacionamiento;
	
	@BeforeEach
	void setUp() {
		inspector = mock(Inspector.class);
		puntoDeVenta = mock(PuntoDeVenta.class);
		zonaDeEstacionamiento = new ZonaDeEstacionamiento(1, inspector, new ArrayList<PuntoDeVenta>());
	}
	
	@Test
	void testAgregarPuntoDeVenta() {
		assertEquals(zonaDeEstacionamiento.getPuntosDeVenta().size(), 0);
		
		zonaDeEstacionamiento.agregarPuntoDeVenta(puntoDeVenta);
		
		assertEquals(zonaDeEstacionamiento.getPuntosDeVenta().size(), 1);
	}
	
	@Test
	void testGetIdZonaEInspector() {
		assertEquals(zonaDeEstacionamiento.getIdZona(), 1);
		zonaDeEstacionamiento.getInspector();
		
		verify(inspector, times(1)).getNombreYApellido();
	
	}
}
