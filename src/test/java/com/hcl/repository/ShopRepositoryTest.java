package com.hcl.repository;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hcl.exception.ResponseException;
import com.hcl.exception.InsufficientInputException;
import com.hcl.launcher.ApplicationLauncher;
import com.hcl.model.ShopInfo;
import com.hcl.model.ShopDetails;
import com.hcl.vo.ShopVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationLauncher.class)
@WebAppConfiguration
public class ShopRepositoryTest {

	//@Autowired
	private ShopRepository shopRepository;	
	
	@Before
	  public void setup() {
	    shopRepository = new ShopRepository();
	  }
	
	@Test
	public void testAddShopAddress() throws ResponseException, InsufficientInputException{
		ShopVO shop1 = getShopDetails("Reliance Digital","Plot 2, Sr. No. 131, Solitaire, ITI Rd, Aundh, Pune, Maharashtra","411007");
		ShopVO shop2 = getShopDetails("Chaitanya Electronics Sony Service Centre","Shop No-18/19/20, Gawade Kunal Garden, Link Road, Opp. Gawade Petrol Pump, Chinchawad, Pimpri Chinchawad, Maharashtra","411033");
		ShopVO shop3 = getShopDetails("Apple Shop","Shop No 1, 3/14, Sadhu Vaswani Road, Sadhu Vaswani Road, Pune, Maharashtra","411001");
		shopRepository.addShopDetails(shop1);
		shopRepository.addShopDetails(shop2);
		shopRepository.addShopDetails(shop3);
		Assert.assertEquals(shopRepository.getShopList().size(), 3);
	}
	
	@Test
	public void testGetNearestShopListWithNearestShops() throws InsufficientInputException, ResponseException{
		ShopVO shop1 = getShopDetails("Reliance Digital","Plot 2, Sr. No. 131, Solitaire, ITI Rd, Aundh, Pune, Maharashtra","411007");
		ShopVO shop2 = getShopDetails("Chaitanya Electronics Sony Service Centre","Shop No-18/19/20, Gawade Kunal Garden, Link Road, Opp. Gawade Petrol Pump, Chinchawad, Pimpri Chinchawad, Maharashtra","411033");
		ShopVO shop3 = getShopDetails("Apple Shop","Shop No 1, 3/14, Sadhu Vaswani Road, Sadhu Vaswani Road, Pune, Maharashtra","411001");
		shopRepository.addShopDetails(shop1);
		shopRepository.addShopDetails(shop2);
		shopRepository.addShopDetails(shop3);
		List<ShopDetails> shopList = shopRepository.getNearestShopList(18.5541642, 73.8076112);
		Assert.assertEquals(shopList.size(), 1);
	}
	
	@Test
	public void testGetNearestShopListWithOutNearestShops() throws IOException, ResponseException, InsufficientInputException{
		ShopVO shop1 = getShopDetails("Reliance Digital","Plot 2, Sr. No. 131, Solitaire, ITI Rd, Aundh, Pune, Maharashtra","411007");
		ShopVO shop2 = getShopDetails("Chaitanya Electronics Sony Service Centre","Shop No-18/19/20, Gawade Kunal Garden, Link Road, Opp. Gawade Petrol Pump, Chinchawad, Pimpri Chinchawad, Maharashtra","411033");
		ShopVO shop3 = getShopDetails("Apple Shop","Shop No 1, 3/14, Sadhu Vaswani Road, Sadhu Vaswani Road, Pune, Maharashtra","411001");
		shopRepository.addShopDetails(shop1);
		shopRepository.addShopDetails(shop2);
		shopRepository.addShopDetails(shop3);
		List<ShopDetails> shopList = shopRepository.getNearestShopList(19.0766818, 72.7331199);
		Assert.assertEquals(shopList.size(), 0);
	}
	
	@Test(expected=InsufficientInputException.class)
	public void testAddShopAddressWithException(){
		ShopVO shop1 = getShopDetails("Reliance Digital", null, "411007");
		shopRepository.addShopDetails(shop1);
	}
	
	private ShopVO getShopDetails(String shopName,String shopAddress,String postalCode){
		ShopVO shopVO = new ShopVO();
		shopVO.setShopName(shopName);
		ShopInfo address  = new ShopInfo();
		address.setAddress(shopAddress);
		
		address.setPostCode(postalCode);
		shopVO.setShopAddress(address);
		shopVO.setShopAddress(address);
		return shopVO;
	}
}
