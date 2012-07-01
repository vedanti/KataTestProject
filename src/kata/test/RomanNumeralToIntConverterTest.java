package kata.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralToIntConverterTest {
	
	RomanNumeralConverter roman ; 
	
	
	public void showValues(String romanStr) { 
		System.out.println(romanStr + " is " + roman.convertToInt(romanStr));
	}
	
	@Test
	public void testValues() { 
		showValues("III");
		showValues("M");
		showValues("IX");
		showValues("IV");
		showValues("XXXIII");
		showValues("XCVI");
		showValues("MCDXLIV");
		showValues("MCCCCXXXXIIII");
	}
	
	@Before
	public void setup() { 
		roman = new RomanNumeralConverter();
	}
	
	@Test
	public void testVreturns5() { 
		Assert.assertTrue(roman.convertToInt("V") == 5);
	}
	@Test
	public void testXreturns10() { 
		Assert.assertTrue(roman.convertToInt("X") == 10);
	}
	@Test
	public void testLreturns50() { 
		Assert.assertTrue(roman.convertToInt("L") == 50);
	}
	@Test (expected = InvalidRomanNumeralException.class)
	public void testYthrowsinvalidRomanNumeralException() { 
		roman.convertToInt("Y");
	}
	@Test (expected = InvalidRomanNumeralException.class)
	public void testNullthrowsinvalidRomanNumeralException() { 
		roman.convertToInt(null);
	}
	@Test
	public void testIVreturns4() { 
	  Assert.assertTrue(roman.convertToInt("IV")==4);
	}
	@Test
	public void testIIIreturns3() { 
		Assert.assertTrue(roman.convertToInt("III")==3);
	}
	@Test
	public void testMMLCIVreturns2054() { 
		Assert.assertTrue(roman.convertToInt("MMLCIV")==2054);
	}
	
	@Test (expected = InvalidRomanNumeralException.class)
	public void testIYIthrowsInvalidRomanNumeralException() { 
		roman.convertToInt("IYI");
	}
	

   
}
