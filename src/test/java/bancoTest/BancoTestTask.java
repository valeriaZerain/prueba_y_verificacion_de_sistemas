package bancoTest;

import banco.AfpService;
import banco.AsfiService;
import banco.BancoUPB;
import banco.SegipService;
import calcService.CalcService;
import calcService.CalculatorAWS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BancoTestTask {

    AfpService afpService = Mockito.mock(AfpService.class);
    SegipService segipService = Mockito.mock(SegipService.class);
    AsfiService asfiService = Mockito.mock(AsfiService.class);
    BancoUPB bancoUPB;

    public BancoTestTask() {
        bancoUPB = new BancoUPB();
        bancoUPB.setAsfiService(asfiService);
        bancoUPB.setAfpService(afpService);
        bancoUPB.setSegipService(segipService);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "8428165, 3000, true, true, 1000, 'se le puede realizar el prestamo: 3000'",
                    "4585216, 3000, false, false, 1000, 'debe revisar su carnet de identidad'",
                    "8620186, 3000, true, false, 1000, 'usted no esta habilitado para prestamos'",
            }
    )

    public void testGetAmountMoney(int ci, int amount, boolean isRealPerson, boolean isAbleToGetCredit, int aporte, String expectedMessage) {
        Mockito.when(segipService.isRealPerson(ci)).thenReturn(isRealPerson);
        Mockito.when(asfiService.isAbleToGetCredit(ci)).thenReturn(isAbleToGetCredit);
        Mockito.when(afpService.getAmount(ci)).thenReturn(aporte);

        String result = bancoUPB.getAmountMoney(ci, amount);
        assertEquals(expectedMessage, result, "ERROR el prestamo es incorrecto");
    }
}

