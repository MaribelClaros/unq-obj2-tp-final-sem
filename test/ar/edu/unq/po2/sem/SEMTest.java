package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SEMTest {
	private SEM sem;
	private ZonaDeEstacionamiento zonaDeEstacionamiento;
	private CompraPuntual compra;
	private EstacionamientoPuntoVenta estacionamientoPuntoVenta;
	private Entidad suscriptor;
	
	@BeforeEach
	void setUp() {
		
		zonaDeEstacionamiento = mock(ZonaDeEstacionamiento.class);
		List<ZonaDeEstacionamiento> zonas = new ArrayList<ZonaDeEstacionamiento>();
		compra = mock(CompraPuntual.class);
		suscriptor = mock(Entidad.class);
		estacionamientoPuntoVenta = mock(EstacionamientoPuntoVenta.class);
		sem = new SEM(zonas);
	}
	
	@Test
	void testNuevaCompraPuntual() {
		sem.nuevaCompraPuntual(compra);
		assertEquals(sem.getCompras().size(), 1);
	}
	
	@Test
	void testNuevoEstacionamientoPuntoVenta() {
		sem.agregarEstacionamientoPuntoVenta(estacionamientoPuntoVenta);
		assertEquals(sem.getEstacionamientos().size(), 1);
		verify(suscriptor, times(1));
	}

}
