package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecargaCelularTest {
	private RecargaCelular recarga;
	private PuntoDeVenta punto;
	
	@BeforeEach
	void setUp() {
		punto = mock(PuntoDeVenta.class);
	}
	
	@Test
	void testGettersCompra() {
		recarga = new RecargaCelular(LocalDate.now(), punto, 2000, 1122334455);
		
		assertEquals(recarga.getMonto(), 2000);
		assertEquals(recarga.getCelular(), 1122334455);
	}
}
