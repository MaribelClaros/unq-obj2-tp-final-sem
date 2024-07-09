package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InfraccionTest {
	private ZonaDeEstacionamiento zonaDeEstacionamiento;
	private Inspector inspector;
	private Infraccion infraccion;
	
	@BeforeEach
	void setUp() {
		zonaDeEstacionamiento = mock(ZonaDeEstacionamiento.class);
		inspector = mock(Inspector.class);
		
	}
	
	@Test
	void testGetters() {
		infraccion = new Infraccion("AAA 222", Date.from(Instant.now()) , zonaDeEstacionamiento, inspector);
		
		assertEquals(infraccion.getFechaYHora(), Date.from(Instant.now()));
		assertEquals(infraccion.getPatente(), "AAA 222");
		assertEquals(infraccion.getInspector(), inspector);
		assertEquals(infraccion.getZonaDeEstacionamiento(), zonaDeEstacionamiento);
	}
}
