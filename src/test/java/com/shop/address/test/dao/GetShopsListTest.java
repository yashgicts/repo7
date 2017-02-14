package com.shop.address.test.dao;

import org.junit.Test;

import com.shop.address.dao.GetShop;
import com.shop.address.dao.GetShopImpl;

import static org.junit.Assert.*;

public class GetShopsListTest {
	@Test
	public void invalidValueTest(){
		GetShop getShopsList=new GetShopImpl();
		String longitude="";
		String Latitude="34.234234234";
		String result=getShopsList.getShopsList(longitude,Latitude);
		assertNull(result);
	}
	
	@Test
	public void invalidFormatTest(){
		GetShop getShopsList=new GetShopImpl();
		String longitude="asdasd";
		String Latitude="34.234234234";
		String result=getShopsList.getShopsList(longitude,Latitude);
		assertNull(result);
	}
	@Test
	public void invalidRangeTest(){
		GetShop getShopsList=new GetShopImpl();
		String longitude="190.32423432";
		String Latitude="34.234234234";
		String result=getShopsList.getShopsList(longitude,Latitude);
		assertNull(result);
	}
	
	@Test
	public void shopsNotFoundTest(){
		GetShop getShopsList=new GetShopImpl();
		String longitude="9.968851";
		String Latitude="86.660156";
		String result=getShopsList.getShopsList(longitude,Latitude);
		assertEquals("No Shops Found near specified location", result);
	}
}
