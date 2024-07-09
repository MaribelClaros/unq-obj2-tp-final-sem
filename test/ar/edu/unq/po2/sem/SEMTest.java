package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalTime;
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
	private Inspector inspector;
	
	@BeforeEach
	void setUp() {
		
		List<ZonaDeEstacionamiento> zonas = new ArrayList<ZonaDeEstacionamiento>();
		inspector = new Inspector("Juan Perez");
		zonaDeEstacionamiento = new ZonaDeEstacionamiento(1, inspector, new ArrayList<PuntoDeVenta>());
		compra = mock(CompraPuntual.class);
		suscriptor = mock(Entidad.class);
		estacionamientoPuntoVenta = mock(EstacionamientoPuntoVenta.class);
		sem = new SEM(zonas);
		sem.agregarZonaDeEstacionamiento(zonaDeEstacionamiento);
		puntoDeVenta = new PuntoDeVenta(zonaDeEstacionamiento);
		celular = new Celular(12345678);
		app = new App(celular, "ABC 123", null, sem);
		recarga = new RecargaCelular(LocalDate.now(), puntoDeVenta, 1000, 12345678);
		
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
		sem.nuevaRecargaCelular(recarga, app);
		
		assertEquals(sem.getCelulares().size(), 1);
		assertEquals(sem.getCelulares().get(0).getNumero(), 12345678);
		assertEquals(sem.getCompras().size(), 1);
	}
	
	@Test
	void tesRecargaCelularExistente() {
		
		assertEquals(sem.getCelulares().size(), 0);
		sem.nuevaRecargaCelular(recarga, app);
		
		assertEquals(sem.getCelulares().get(0).getSaldo(), 1000);
		
		sem.nuevaRecargaCelular(recarga, app);
		assertEquals(sem.getCelulares().size(), 1);
		assertEquals(sem.getCelulares().get(0).getSaldo(), 2000);
	}
	
	@Test
	void testGenerarEstacionamientoAppSinSaldo() {
		String resp = sem.generarEstacionamientoApp(app);		
		
	    assertTrue(resp.contains("Saldo insuficiente."));
		assertEquals(sem.getEstacionamientos().size(), 0);
	}
	
	@Test
	void testGenerarEstacionamientoAppConSaldo() {
		sem.nuevaRecargaCelular(recarga, app);
		String resp = sem.generarEstacionamientoApp(app);
		sem.suscribirse(suscriptor);
		
		
		assertTrue(resp.contains("¡Estacionamiento exitoso!"));
		assertEquals(sem.getEstacionamientos().size(), 1);
		assertEquals(sem.getCompras().size(), 1);
		assertEquals(sem.getSuscriptores().size(), 1);
	}
	
	@Test
	void testFinalizarEstacionamientoApp() {
		sem.nuevaRecargaCelular(recarga, app);
		String resp = sem.generarEstacionamientoApp(app);
		sem.suscribirse(suscriptor);
		
		
		assertTrue(resp.contains("¡Estacionamiento exitoso!"));
		
		String respFin = sem.finalizarEstacionamientoViaApp(app.getNroCelular());
		
		assertTrue(respFin.contains("Estacionamiento finalizado."));
		assertFalse(sem.getEstacionamientos().get(0).esVigente);
		sem.desuscribirse(suscriptor);
		
	}
	
	@Test
	void testConsultarEstacionamientoVigente() {
		sem.nuevaRecargaCelular(recarga, app);
		String resp = sem.generarEstacionamientoApp(app);
		sem.suscribirse(suscriptor);
		
		
		assertTrue(resp.contains("¡Estacionamiento exitoso!"));
		assertTrue(sem.consultarEstacionamientoVigente("ABC 123"));
		
	}
	
	@Test
	void testFinalizarTodosLosEstacionamientos() {
		App nuevaApp = new App(celular, "ABC 333", null, sem);
		sem.nuevaRecargaCelular(recarga, app);
		sem.nuevaRecargaCelular(recarga, nuevaApp);
		sem.generarEstacionamientoApp(app);
		sem.generarEstacionamientoApp(nuevaApp);
		sem.finalizarTodosLosEstacionamientos();
		
		assertFalse(sem.consultarEstacionamientoVigente("ABC 123"));
		assertFalse(sem.consultarEstacionamientoVigente("ABC 333"));
	}
	
	@Test
	void testGenerarInfraccion() {
		sem.nuevaRecargaCelular(recarga, app);
		sem.generarEstacionamientoApp(app);
		
		sem.altaInfraccion(inspector, "ABC 123");
		
		assertEquals(sem.getInfracciones().size(), 1);
	}
	
	@Test
	void testMissingGetters() {
		assertEquals(sem.getInicioFranjaHoraria(), LocalTime.of(7, 0));
		assertEquals(sem.getFinFranjaHoraria(), LocalTime.of(20, 0));
		assertEquals(sem.getZonasDeEstacionamiento().size(), 1);
	}
 
}
