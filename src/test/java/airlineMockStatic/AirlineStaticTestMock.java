package airlineMockStatic;

import airlineStatic.AirlineStatic;
import airlineStatic.GetDayServiceGlobal;
import airlineStatic.MonthServiceGlobal;
import airlineStatic.PasajesServiceGlobal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AirlineStaticTestMock {
    MockedStatic<GetDayServiceGlobal> day = Mockito.mockStatic(GetDayServiceGlobal.class);
    MockedStatic<MonthServiceGlobal> month = Mockito.mockStatic(MonthServiceGlobal.class);
    MockedStatic<PasajesServiceGlobal> pasaje = Mockito.mockStatic(PasajesServiceGlobal.class);

    @Test
    public void verifyReservationIsAvailable(){
        day.when(() -> GetDayServiceGlobal.getDay(3, 10, 2024)).thenReturn("jueves");
        month.when(() -> MonthServiceGlobal.getNombreMes(10)).thenReturn("Octubre");
        pasaje.when(() -> PasajesServiceGlobal.existenPasajes("La Paz", 2, "3/10/2024")).thenReturn(true);
        AirlineStatic airlineStatic = new AirlineStatic();
        Assertions.assertEquals("El dia jueves 3 de Octubre de 2024 existen 2 pasajes para La Paz",
                airlineStatic.reservarVuelo("La Paz", 2, 3,10, 2024));
    }

    @Test
    public void verifyItIsNotAvailable(){
        day.when(() -> GetDayServiceGlobal.getDay(3, 10, 2024)).thenReturn("jueves");
        month.when(() -> MonthServiceGlobal.getNombreMes(10)).thenReturn("Octubre");
        pasaje.when(() -> PasajesServiceGlobal.existenPasajes("La Paz", 3, "3/10/2024")).thenReturn(false);
        AirlineStatic airlineStatic = new AirlineStatic();
        Assertions.assertEquals("No existen suficientes pasajes para La Paz",
                airlineStatic.reservarVuelo("La Paz", 3, 3,10, 2024));
    }
}
