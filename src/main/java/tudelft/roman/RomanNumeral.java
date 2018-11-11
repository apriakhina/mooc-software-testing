package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /*
    * Empty Strings and null are not allowed
    * String should contain only valid roman numeral letters
    * The number zero does not have its own Roman numeral, but the word nulla
      (the Latin word meaning "none") was used by medieval scholars in lieu of 0
      rules
    * If a symbol is repeated, its value is added as many times as it occurs. For example, II=2, XX=20 etc.
    * The symbols V, L and D are never repeated.
    * A symbol is not repeated more than three times.
    * If a smaller symbol is written to the right of a symbol with a greater value,
      then its value gets added to the value of the greater symbol.
      For example, VI=5+1=6, XI=11 and so on.
    * If a smaller symbol is written on the left of a symbol with greater value,
      then its value is subtracted from the value of the greater symbol.
      IV= 5-1=4, IX=9 etc.
    * The symbols V, L and D are never written to the left of a symbol of greater value
      i.e. V, L and D are never subtracted. The symbol I can be subtracted from V and X only.
      The symbol X can be subtracted from L, M and C only.
    * A symbol cannot be subtracted more than once from a particular symbol of greater value.
      In other words, we cannot repeat a symbol on the left side of a symbol.
      Eg, 98 is written as XCVIII and not as IIC.
     */
    public int convert(String s) {
        // check String
        if(s == "" || s == null)
            throw  new NullPointerException("Empty strings are not alowed");

        if(s.equals("nulla"))
            return 0;

        if(!s.matches("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$"))
            throw new IllegalArgumentException("String is not a valid roman numeral");

        int convertedNumber = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentNumber = map.get(s.charAt(i));
            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;

            if(currentNumber >= next)
                convertedNumber += currentNumber;
            else
                convertedNumber -= currentNumber;
        }

        return convertedNumber;
    }
}
