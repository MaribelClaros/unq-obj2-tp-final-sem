package ar.edu.unq.po2.sem;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class estadosMovimientoTests {
    @Test
    public void testDriving() {
        App app = mock(App.class);
        Driving driving = new Driving(app);

        driving.driving();
        driving.walking();

        verify(app, times(1)).iniciarEstacionamiento();
    }

    @Test
    public void testWalking() {
        App app = mock(App.class);
        Walking walking = new Walking(app);

        walking.walking();
        walking.driving();

        verify(app, times(1)).finalizarEstacionamiento();
    }
}
