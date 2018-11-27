package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CaesarShiftCipherTest {


    @ParameterizedTest(name = "({0}, {1}) = {2}")
    @CsvSource(value = {
            // The total is higher than the amount of small and big bars.
            "'abc', 0, 'abc'", "'abc', 26, 'abc'", "'abc', -1, 'zab'", "'abc', -3, 'xyz'", "'abc', 3, 'def'", "'xyz', 5, 'cde'",
            "'22', '1', 'invalid'", "'Qwse', '2', 'invalid'", "'', 2, 'invalid'"
    })
    public void testAlgorithm(String message, int shift, String expected) {
        CaesarShiftCipher c = new CaesarShiftCipher();
        String actual = c.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, actual);
    }

}
