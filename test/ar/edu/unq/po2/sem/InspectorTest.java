package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InspectorTest {
	private Inspector inspector;
	private SEM sem;
	
	@BeforeEach
	void setUp() {
		sem = mock(SEM.class);
		inspector = new Inspector("Juan Perez");
	}
	
	@Test
	void testGenerarInfraccion() {
		inspector.generarInfraccion(sem, "ABC 123");
		
		verify(sem, times(1)).consultarEstacionamientoVigente("ABC 123");
		
	}
	
	@Test
	void testGetIdAndNombreInspector() {
		assertTrue(inspector.getNombreYApellido().equals("Juan Perez"));
	}
}
