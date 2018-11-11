package tudelft.leapyear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeapYearTest {
    LeapYear ly;

    @BeforeEach
    public void beforeEach() {
        ly = new LeapYear();
    }

    @Test
    public void leapYearsThatAreNonCenturialYears() {
        boolean result = ly.isLeapYear(2016);
        Assertions.assertTrue(result);
    }

    @Test
    public void leapCenturialYears() {
        Assertions.assertTrue(ly.isLeapYear(2000));
    }

    @Test
    public void nonLeapCenturialYears() {
        Assertions.assertFalse(ly.isLeapYear(1500));
    }

    @Test
    public void nonLeapYears() {
        Assertions.assertFalse(ly.isLeapYear(2017));
    }
}
