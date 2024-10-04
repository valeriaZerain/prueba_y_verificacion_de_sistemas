package invertirNumeroTest;

import invertirNumero.Util;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvNumeroTest {
    @ParameterizedTest
    @CsvSource({
            "'5489', '9845'",
            "'jklml', 'jklml'",
            "'482a6', '658a4'",
            "'', ''",
            "'5', '5'",
            "'-8452', '-2548'",
            "123456, '654321'"
    })
    void testInvertNumbers(String input, String expected) {
        Util util = new Util();

        String result = util.invertirNum(input);
        assertEquals(expected, result);
    }

}