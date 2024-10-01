package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class CalculatorMultTest {

    // positive / acceptance
    @Test
    public void verifyMulti(){
        Calculator calculator = new Calculator();
        int expectedResult=9;
        int actualResult=calculator.mult(3,3);
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la multi es incorrecta");
    }

    @Disabled
    @Test
    public void verifyMultiNegative(){
        Calculator calculator = new Calculator();
        int expectedResult=9;
        int actualResult=calculator.mult(-3,-3);
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la multi es incorrecta");
    }
}
