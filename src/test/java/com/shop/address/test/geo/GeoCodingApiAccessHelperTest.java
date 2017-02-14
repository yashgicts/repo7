package com.shop.address.test.geo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.shop.address.geo.GeoCodingAPIHelper;
import com.shop.address.vo.ShopsVO;

public class GeoCodingApiAccessHelperTest {
	@Test
	public void nullValuesTest(){
		GeoCodingAPIHelper geoCoding=new GeoCodingAPIHelper();
		
		ShopsVO shop=new ShopsVO();
		shop.setShopName(null);
		shop.setShopNumber(null);
		shop.setPostalCode(null);
		
		ShopsVO responceObject=geoCoding.getAddressWithLongitudeLatitude(shop);
		
		assertNotNull(responceObject);
		assertEquals("ZERO_RESULTS", responceObject.getStatus());
		
	}
	
	@Test
	public void ValuesTest(){
		GeoCodingAPIHelper geoCoding=new GeoCodingAPIHelper();
		
		ShopsVO shop=new ShopsVO();
		shop.setShopName("Citadel");
		shop.setShopNumber("d3");
		shop.setPostalCode("411001");
		
		ShopsVO responceObject=geoCoding.getAddressWithLongitudeLatitude(shop);
		
		assertNotNull(responceObject);
		
	}
}
