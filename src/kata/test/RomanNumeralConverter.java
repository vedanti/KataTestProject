package kata.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RomanNumeralConverter {

	static Map<String, Integer> romanMap = new HashMap<String, Integer>();

	static {
		romanMap.put("I", 1);
		romanMap.put("V", 5);
		romanMap.put("X", 10);
		romanMap.put("L", 50);
		romanMap.put("C", 100);
		romanMap.put("D", 500);
		romanMap.put("M", 1000);

	}

	public int convertToInt(String roman) {

		checkIfValidRomanNumeral(roman);
		return deduceRomanValueBasedOnSubtractivePrinciple(roman);

	}

	private int deduceRomanValueBasedOnSubtractivePrinciple(String roman) {
		int romIntValue = 0;
		int finIntValue = 0;
		int prevIntValue = 0;
		for (int len = roman.length() - 1; len >= 0; len--) {
			romIntValue = romanMap.get(String.valueOf(roman.charAt(len)));
			if (prevIntValue > romIntValue) {
				romIntValue = -romIntValue;
			}
			finIntValue = finIntValue + romIntValue;
			prevIntValue = romIntValue;
		}
		return finIntValue;
	}

	private void checkIfValidRomanNumeral(String roman) {
		Set romanNumerals = romanMap.keySet();

		if (roman != null) {
			for (int len = 0; len < roman.length(); len++) {
				if (!romanNumerals.contains(String.valueOf(roman.charAt(len)))) {
					throw new InvalidRomanNumeralException();
				}
			}
		}else  
			throw new InvalidRomanNumeralException();

	}
}
