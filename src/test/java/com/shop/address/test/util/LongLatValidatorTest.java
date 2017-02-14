package com.shop.address.test.util;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shop.address.util.LongitudeLatitudeValidator;
public class LongLatValidatorTest {
	@Test
	public void longitudeFormatingTest(){
		boolean result=LongitudeLatitudeValidator.validateLongitude("34.45.444444");
		assertEquals(false, result);
	}
	
	@Test
	public void longitudeRangeTest(){
		boolean result=LongitudeLatitudeValidator.validateLongitude("199");
		assertEquals(false, result);
	}
	
	@Test
	public void latitudeFormatingTest(){
		boolean result=LongitudeLatitudeValidator.validateLatitude("34.abcd");
		assertEquals(false, result);
	}
	
	@Test
	public void latitudeRangeTest(){
		boolean result=LongitudeLatitudeValidator.validateLatitude("98");
		assertEquals(false, result);
	}

}
