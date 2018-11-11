package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTestWithBeforeEach {

    private RomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }


    // line 24
    @Test
    public void covertEmptyString() {
        try {
            roman.convert("");
            Assertions.fail("Should have thrown an exception when the parameter is null");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Empty strings are not alowed", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not NullPointerException as expected");
        }
    }

    // line 24
    @Test
    public void covertNullString() {
        try {
            roman.convert(null);
            Assertions.fail("Should have thrown an exception when the parameter is null");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Empty strings are not alowed", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not NullPointerException as expected");
        }
    }

    // line 28
    @Test
    public void covertZero() {
        int result = roman.convert("nulla");
        Assertions.assertEquals(0, result);
    }

    // line 34
    @Test
    public void covertIllegalString() {
        try {
            roman.convert("KCLL");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }
    // line 34
    @Test
    public void covertIllegalStringInTheMiddle() {
        try {
            roman.convert("CKLL");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    // The symbols V, L and D are never repeated.
    @Test
    public void covertIllegalStringVV() {
        try {
            roman.convert("VV");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    //A symbol is not repeated more than three times.
    @Test
    public void covertIllegalStringIIII() {
        try {
            roman.convert("IIII");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    //The symbols V, L and D are never written to the left of a symbol of greater value
    @Test
    public void covertIllegalStringVX() {
        try {
            roman.convert("VX");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    //The symbol I can be subtracted from V and X only.
    @Test
    public void covertIllegalStringVL() {
        try {
            roman.convert("VL");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    //The symbol X can be subtracted from L, M and C only.
    @Test
    public void covertIllegalStringXD() {
        try {
            roman.convert("XD");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    //A symbol cannot be subtracted more than once from a particular symbol of greater value.
    @Test
    public void covertIllegalStringIIX() {
        try {
            roman.convert("IIX");
            Assertions.fail("Should have thrown an exception when the parameter is not a roman numeral");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("String is not a valid roman numeral", e.getLocalizedMessage());
        } catch (Exception e2) {
            Assertions.fail("Caught exception but it is not IllegalArgumentException as expected");
        }
    }

    @Test
    public void singleNumber() {
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    // Addition
    @Test
    public void numberWithManyDigits() {
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    // Substraction
    @Test
    public void numberWithSubtractiveNotation() {
        int result = roman.convert("IX");
        Assertions.assertEquals(9, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }
}
