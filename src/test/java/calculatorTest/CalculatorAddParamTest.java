package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorAddParamTest {

    @ParameterizedTest
    @CsvSource(
      {
         "2,2,4",
         "7,7,14",
         "1,2,3",
         "2,1,3",
         "0,0,0",
         "-1,2,1",
         "2,-1,1",
         "-2,1,-1",
      }
    )
    public void verifyAddPositiveNumber(int number1, int number2, int expectedResult ){
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(number1,number2);
        Assertions.assertEquals(expectedResult,actualResult,
                "ERROR las suma es incorrecta, revise el codigo!");
    }



}
