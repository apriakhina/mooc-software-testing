package tudelft.christmas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChristmasDiscountRefactoredTest {

    @Test
    public void christmasPositive() {
        Clock clock = Mockito.mock(Clock.class);
        Calendar christmas = new GregorianCalendar(2015, Calendar.DECEMBER, 25);

        Mockito.when(clock.now()).thenReturn(christmas);

        double finalValue = new ChristmasDiscountRefactored(clock).applyDiscount(100.0);

        Assertions.assertEquals(85.0, finalValue, 0.0001);
    }

    @Test
    public void notChristmasPositive() {
        Clock clock = Mockito.mock(Clock.class);
        Calendar christmas = new GregorianCalendar(2015, Calendar.JANUARY, 25);

        Mockito.when(clock.now()).thenReturn(christmas);

        double finalValue = new ChristmasDiscountRefactored(clock).applyDiscount(100.0);

        Assertions.assertEquals(100.0, finalValue, 0.0001);
    }

    @Test
    public void christmasBoundary() {
        try {
            Clock clock = Mockito.mock(Clock.class);
            Calendar christmas = new GregorianCalendar(2015, Calendar.DECEMBER, 25);
            Mockito.when(clock.now()).thenReturn(christmas);
            new ChristmasDiscountRefactored(clock).applyDiscount(0);
            Assertions.fail("Should have throw exception when the rawAmount is not more than zero");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Price should be more than 0", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    @Test
    public void notChristmasBoundary() {
        try {
            Clock clock = Mockito.mock(Clock.class);
            Calendar christmas = new GregorianCalendar(2015, Calendar.JANUARY, 25);

            Mockito.when(clock.now()).thenReturn(christmas);
            new ChristmasDiscountRefactored(clock).applyDiscount(0);
            Assertions.fail("Should have throw exception when the rawAmount is not more than zero");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Price should be more than 0", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }
}
