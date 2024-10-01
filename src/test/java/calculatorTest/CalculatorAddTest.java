package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorAddTest {

    @Test
    public void verifyAddPositiveNumber(){
        Calculator calculator = new Calculator();
        int expectedResult = 4;
        int actualResult = calculator.add(2,2);
        Assertions.assertEquals(expectedResult,actualResult,
                "ERROR las suma es incorrecta, revise el codigo!");
    }

    @Test
    public void verifyAddPositiveNumber2(){
        Calculator calculator = new Calculator();
        int expectedResult = 6;
        int actualResult = calculator.add(3,3);
        Assertions.assertEquals(expectedResult,actualResult,
                "ERROR las suma es incorrecta, revise el codigo!");
    }

}
