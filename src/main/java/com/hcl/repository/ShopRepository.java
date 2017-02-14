package com.hcl.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.hcl.exception.InsufficientInputException;
import com.hcl.exception.ServerResponseException;
import com.hcl.helper.ResponseHelper;
import com.hcl.model.ShopDetails;
import com.hcl.model.googlehelper.GoogleResponse;
import com.hcl.vo.ShopVO;

/**
 * This class is used to that define the retrieval of shop address content based on request parameter.
 *
 */
@Repository
public class ShopRepository {

	private List<ShopDetails> shopList;

	private final double NEAREST_DISTANCE = 1.0;

	@PostConstruct
	public void init() {
		shopList = new ArrayList<ShopDetails>();
	}

	/**
	 * This method is used to add shop name, address and postal code.
	 * @param ShopVO
	 */
	public void addShopDetails(ShopVO shopVO) {
		
		GoogleResponse response = null;

		if (shopVO.getShopName() == null | shopVO.getShopAddress().getPostCode() == null
				| shopVO.getShopAddress().getAddress() == null) {
			throw new InsufficientInputException("Please provdie all the Inputs");
		}
		response = ResponseHelper.getLocationDetails(shopVO.getShopName() + " "
				+ shopVO.getShopAddress().getAddress() + " " + shopVO.getShopAddress().getPostCode());
		
		if (response.getStatus().equals("OK")) 
		{
			if(shopList==null){
				shopList = new ArrayList<ShopDetails>();
			}
			ShopDetails shop = new ShopDetails();
			shop.setShopName(shopVO.getShopName());
			shop.setShopAddress(shopVO.getShopAddress());
			shop.setLocation(response.getResults()[0].getGeometry().getLocation());
			shopList.add(shop);
			
		} 
		else if (response.getStatus().equals("ZERO_RESULTS")) 
		{
			throw new InsufficientInputException("There are no resut found for data");
		} 
		else 
		{
			throw new ServerResponseException("Unknown Error");
		}
	}

	/**
	 * This method is used to get nearest shop list. 
	 * @param latitude Double
	 * @param longitude Double
	 * @return List<ShopDetails>
	 */
	public List<ShopDetails> getNearestShopList(Double latitude, Double longitude) {
		List<ShopDetails> shopLists = new ArrayList<ShopDetails>();
		if (latitude == null || longitude == null) {
			throw new InsufficientInputException("inputs are missing");
		}
		for (ShopDetails shop : shopList) {
			double distance = ResponseHelper.getDistance(shop.getLocation().getLat(), shop.getLocation().getLng(),
					latitude, longitude);
			if (distance <= NEAREST_DISTANCE) {
				shopLists.add(shop);
			}
		}
		return shopLists;
	}

	/**
	 * This method is used to get Shop List.
	 * @return List<ShopDetails>
	 */
	public List<ShopDetails> getShopList() {
		return shopList;
	}

	/**
	 * This method is used to save Shop Details in List.
	 * @param List<ShopDetails>
	 */
	public void setShopList(List<ShopDetails> shopList) {
		this.shopList = shopList;
	}
}