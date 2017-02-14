package com.shop.address.test.dao;

import org.junit.Test;

import com.shop.address.dao.SaveShopDataDao;
import com.shop.address.dao.SaveShopDataDaoImpl;
import com.shop.address.vo.ShopsVO;

import static org.junit.Assert.*;


public class ShopDaoTest {
	@Test
	public void testSaveDaoNullTest(){
		SaveShopDataDao savedataDao=new SaveShopDataDaoImpl();
		
		ShopsVO shopTest1=new ShopsVO();
		shopTest1.setLatitude(null);
		shopTest1.setLongitude("34.000000");
		shopTest1.setPostalCode("123456");
		shopTest1.setShopName("ABCDEF");
		shopTest1.setShopNumber("123");
		
		boolean result=savedataDao.saveShopInfo(shopTest1);
		assertEquals(false,result);
	}
	
	@Test
	public void testSaveDaoEmptyTest(){
		SaveShopDataDao savedataDao=new SaveShopDataDaoImpl();
		
		ShopsVO shopTest1=new ShopsVO();
		shopTest1.setLatitude("45.565777");
		shopTest1.setLongitude("34.000000");
		shopTest1.setPostalCode("123456");
		shopTest1.setShopName("");
		shopTest1.setShopNumber("123");
		
		boolean result=savedataDao.saveShopInfo(shopTest1);
		assertEquals(false,result);
	}
	
	@Test
	public void testSaveDaoInValidLonglatTest(){
		SaveShopDataDao savedataDao=new SaveShopDataDaoImpl();
		
		ShopsVO shopTest1=new ShopsVO();
		shopTest1.setLatitude("45.5657.77");
		shopTest1.setLongitude("34.000000");
		shopTest1.setPostalCode("123456");
		shopTest1.setShopName("ABB");
		shopTest1.setShopNumber("123");
		
		boolean result=savedataDao.saveShopInfo(shopTest1);
		assertEquals(false,result);
	}
	
	@Test
	public void testSaveDaoTest(){
		SaveShopDataDao savedataDao=new SaveShopDataDaoImpl();
		
		ShopsVO shopTest1=new ShopsVO();
		shopTest1.setLatitude("45.565777");
		shopTest1.setLongitude("34.000000");
		shopTest1.setPostalCode("123456");
		shopTest1.setShopName("ABB");
		shopTest1.setShopNumber("123");
		
		boolean result=savedataDao.saveShopInfo(shopTest1);
		assertEquals(true,result);
	}


}
