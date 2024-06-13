package ar.edu.unq.po2.sem;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class modosTests {
    @Test
    public void testModoManual() {
        App app = mock(App.class);
        Manual manual = new Manual(app);

        manual.iniciarEstacionamiento();;
        manual.finalizarEstacionamiento();

        verify(app, times(0)).iniciarEstacionamiento();
        verify(app, times(0)).finalizarEstacionamiento();
    }

    @Test
    public void testModoAutomatic() {
        App app = mock(App.class);
        Automatico automatic = new Automatico(app);

        automatic.iniciarEstacionamiento();
        automatic.finalizarEstacionamiento();

        verify(app, times(1)).iniciarEstacionamiento();
        verify(app, times(1)).finalizarEstacionamiento();
    }
}
