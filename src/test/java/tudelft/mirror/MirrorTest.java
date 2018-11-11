package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.chocolate.ChocolateBags;

public class MirrorTest {


    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            // The total is higher than the amount of small and big bars.
            "'abXhjXba', 'abX'", "'aba', 'aba'", "'aa', 'aa'", "'a', 'a'", "'', ''"
    })
    public void testAlgorithm(String str, String result) {
        Mirror m = new Mirror();
        String actual = m.mirrorEnds(str);
        Assertions.assertEquals(result, actual);
    }
}
