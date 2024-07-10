package ar.edu.unq.po2.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CelularTest {
	private Celular celular;

    @BeforeEach
    public void setUp() {
        celular = new Celular(1155556666);
    }

    @Test
    public void testNumero() {
        assertEquals(1155556666, celular.getNumero());
    }

    @Test
    public void testSetNumero() {
        celular.setNumero(1112345678);
        assertEquals(1112345678, celular.getNumero());
    }

    @Test
    public void testGetSaldoInicial() {
        assertEquals(0, celular.getSaldo());
    }

    @Test
    public void testAumentarSaldo() {
        celular.aumentarSaldo(50);
        assertEquals(50, celular.getSaldo());
        celular.aumentarSaldo(100);
        assertEquals(150, celular.getSaldo());
    }

    @Test
    public void testDescontarSaldo() {
        celular.aumentarSaldo(100);
        celular.descontarSaldo(30);
        assertEquals(70, celular.getSaldo());
        celular.descontarSaldo(70);
        assertEquals(0, celular.getSaldo());
    }

    @Test
    public void testDescontarSaldoNegativo() {
        celular.aumentarSaldo(50);
        celular.descontarSaldo(60);
        assertEquals(-10, celular.getSaldo());
    }
}
