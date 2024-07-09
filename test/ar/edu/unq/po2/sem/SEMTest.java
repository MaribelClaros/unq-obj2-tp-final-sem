package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SEMTest {
	private SEM sem;
	private ZonaDeEstacionamiento zonaDeEstacionamiento;
	private CompraPuntual compra;
	private EstacionamientoPuntoVenta estacionamientoPuntoVenta;
	private RecargaCelular recarga;
	private Entidad suscriptor;
	private PuntoDeVenta puntoDeVenta;
	private App app;
	private Celular celular;
	private EstacionamientoApp estacionamientoApp;
	private Inspector inspector;
	
	@BeforeEach
	void setUp() {
		
		zonaDeEstacionamiento = mock(ZonaDeEstacionamiento.class);
		List<ZonaDeEstacionamiento> zonas = new ArrayList<ZonaDeEstacionamiento>();
		compra = mock(CompraPuntual.class);
		suscriptor = mock(Entidad.class);
		estacionamientoPuntoVenta = mock(EstacionamientoPuntoVenta.class);
		sem = new SEM(zonas);
		puntoDeVenta = new PuntoDeVenta(zonaDeEstacionamiento);
		celular = new Celular(12345678);
		app = new App(celular, "ABC 123", null, sem);
		recarga = new RecargaCelular(LocalDate.now(), puntoDeVenta, 1000, 12345678);
		inspector = mock(Inspector.class);
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
		verify(suscriptor, times(0)).inicioEstacionamiento(estacionamientoPuntoVenta);
	}
	
	@Test
	void testNuevaRecargaCelular() {
		assertEquals(sem.getCelulares().size(), 0);
		sem.nuevaRecargaCelular(recarga);
		
		assertEquals(sem.getCelulares().size(), 1);
		assertEquals(sem.getCelulares().get(0).getNumero(), 12345678);
	}
	
	@Test
	void tesRecargaCelularExistente() {
		
		assertEquals(sem.getCelulares().size(), 0);
		sem.nuevaRecargaCelular(recarga);
		
		assertEquals(sem.getCelulares().get(0).getSaldo(), 1000);
		
		sem.nuevaRecargaCelular(recarga);
		assertEquals(sem.getCelulares().size(), 1);
		assertEquals(sem.getCelulares().get(0).getSaldo(), 2000);
	}
	
	@Test
	void testGenerarEstacionamientoAppSinSaldo() {
		String resp = sem.generarEstacionamientoApp(app);		
		
	    assertTrue(resp.contains("Saldo insuficiente."));
		assertEquals(sem.getEstacionamientos().size(), 0);
	}
 
}
