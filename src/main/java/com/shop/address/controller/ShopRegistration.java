package com.shop.address.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shop.address.dao.SaveShopDataDao;
import com.shop.address.dao.SaveShopDataDaoImpl;
import com.shop.address.geo.GeoCodingAPIHelper;
import com.shop.address.util.RetrieveShopAddressConstants;
import com.shop.address.vo.ShopsVO;

/**
 * @author yashwant
 *
 */

@RestController

public class ShopRegistration {
	
	 @RequestMapping(value ="/registerStore", method=RequestMethod.POST)
	
	 
	 public @ResponseBody String registerShop(@RequestBody ShopsVO shop, UriComponentsBuilder ubc) {
		 	
			GeoCodingAPIHelper geoCodingHelper=new GeoCodingAPIHelper();
			ShopsVO shopFullAdress=geoCodingHelper.getAddressWithLongitudeLatitude(shop);
			
			 if (!RetrieveShopAddressConstants.GEOCODING_RES_OK.equals(shopFullAdress.getStatus())) {
				 if (RetrieveShopAddressConstants.GEOCODING_RES_ZERO.equalsIgnoreCase(shopFullAdress.getStatus()) ) return RetrieveShopAddressConstants.APIRESPONCE_INVALID_ADDRESS;
				 if (RetrieveShopAddressConstants.GEOCODING_RES_INVALID_REQUEST.equalsIgnoreCase(shopFullAdress.getStatus()) ) return RetrieveShopAddressConstants.APIRESPONCE_INVALID_REQUEST;
				 if (RetrieveShopAddressConstants.GEOCODING_RES_LIMIT_EXCEEDED.equalsIgnoreCase(shopFullAdress.getStatus()) ) return RetrieveShopAddressConstants.APIRESPONCE_LIMIT_EXCEEDED;
				 if (RetrieveShopAddressConstants.GEOCODING_RES_REQUEST_DENIED.equalsIgnoreCase(shopFullAdress.getStatus()) ) return RetrieveShopAddressConstants.APIRESPONCE_REQUEST_DENIED;
				 if (RetrieveShopAddressConstants.GEOCODING_RES_ZERO.equalsIgnoreCase(shopFullAdress.getStatus()) ) return RetrieveShopAddressConstants.GEOCODING_RES_ZERO;
			 }
		 	 SaveShopDataDao saveStore=new SaveShopDataDaoImpl();
		 	 boolean dataSaveStatus=saveStore.saveShopInfo(shopFullAdress);
		 	
		 	if (dataSaveStatus) return RetrieveShopAddressConstants.REGISTRATION_SUCCESSFULL;
		 	else return RetrieveShopAddressConstants.REGISTRATION_FAILED;
	 }


}
