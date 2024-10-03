package airlineTest;

import org.junit.jupiter.api.Test;
import task1.Airline;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirlineTest {
    @Test
    public void testReservaVuelo_SuficientesPasajes() {
        Airline aerolinea = new Airline();
        String resultado = aerolinea.reservarVuelo("La Paz", 2, 3, 10, 2024);
        assertEquals("El dia jueves 3 de Octubre de 2024 existen 2 pasajes para La Paz", resultado);
    }

    @Test
    public void testReservaVuelo_NoSuficientesPasajes() {
        Airline aerolinea = new Airline();
        String resultado = aerolinea.reservarVuelo("La Paz", 5, 3, 10, 2024);
        assertEquals("No existen suficientes pasajes para La Paz", resultado);
    }
}
