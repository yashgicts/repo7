package com.shop.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.address.dao.GetShop;
import com.shop.address.dao.GetShopImpl;
import com.shop.address.util.LongitudeLatitudeValidator;
import com.shop.address.util.RetrieveShopAddressConstants;

@RestController
public class GetFullAdress {
 @RequestMapping(value ="/getStoreList", method=RequestMethod.GET)
	
	 
	 public @ResponseBody String registerShop(@RequestParam String longitude,@RequestParam String latitude) {
		 	GetShop getShopList=new GetShopImpl();
		 	if (longitude==null || latitude==null) return RetrieveShopAddressConstants.SEARCH_INVALID_RANGE;
			if (longitude.isEmpty()||latitude.isEmpty()) return RetrieveShopAddressConstants.SEARCH_INVALID_RANGE;
			if (! LongitudeLatitudeValidator.validateLatitude(latitude)
					|| !LongitudeLatitudeValidator.validateLongitude(longitude))
				return RetrieveShopAddressConstants.SEARCH_INVALID_RANGE;
			
		 	
		 	String shopsListJsonString=getShopList.getShopsList(longitude,latitude);
		 	System.out.println("Shops list for location "+longitude+" & "+latitude +" is : "+shopsListJsonString);
		 	if (shopsListJsonString!=null)
		 			return shopsListJsonString;
		 	else
		 		return RetrieveShopAddressConstants.SEARCH_FAILURE;
	 }

}
