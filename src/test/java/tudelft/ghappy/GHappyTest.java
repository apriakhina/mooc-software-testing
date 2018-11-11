package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class GHappyTest {


    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            // The total is higher than the amount of small and big bars.
            "'ggh', true", "'hgh', false", "'hgg', true", "'g', false", "'gg', true", "'xxggyygxx', false",
    })
    public void testAlgorithm(String str, boolean result) {
        GHappy g = new GHappy();
        Assertions.assertEquals(result, g.gHappy(str));
    }
}
