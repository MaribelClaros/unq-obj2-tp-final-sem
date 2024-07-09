package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompraPuntualTest {
	private CompraPuntual compraPuntual;
	private PuntoDeVenta punto;
	
	@BeforeEach
	void setUp() {
		punto = mock(PuntoDeVenta.class);
	}
	
	@Test
	void testGettersCompra() {
		compraPuntual = new CompraPuntual(LocalDate.now(), punto, 3, "AAA 111");
		
		assertEquals(compraPuntual.getCantHoras(), 3);
		assertEquals(compraPuntual.getPatente(), "AAA 111");
	}
}
