package com.hcl.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.exception.DataInputException;
import com.hcl.exception.InsufficientInputException;
import com.hcl.exception.ServerResponseException;
import com.hcl.model.ShopDetails;
import com.hcl.repository.ShopRepository;
import com.hcl.vo.ShopVO;


/**
 * Rest controller to retrieve and save Shop Location from Google.
 *
 */
@RestController
public class RetrieveShopAddressController {
	
	@Autowired
	private ShopRepository repository;    
	
	/** Save Shop Location using Shop Name and Address.
	 * @param shopVO ShopVO
	 * @return ResponseEntity
	 */
	@RequestMapping(method = RequestMethod.POST,value = "/addShopAddress")
	public ResponseEntity<String> addShopAddress(@RequestBody ShopVO shopVO){
		try {
			repository.addShopDetails(shopVO);
		}catch (DataInputException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}catch (ServerResponseException e1) {
			return new ResponseEntity<String>(e1.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(InsufficientInputException e2){
			return new ResponseEntity<String>(e2.getMessage(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Resource created",HttpStatus.CREATED);
	}
	
	/**
	 * Retrieves Shop Location using latitude and longitude from Google.
	 * @param latitude Double
	 * @param longitude Double
	 * @return ResponseEntity
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getShopList")
	public ResponseEntity<List<ShopDetails>> retrieveShopAddress(@RequestParam Double latitude,@RequestParam Double longitude){
		try 
		{
			return new ResponseEntity<List<ShopDetails>>(repository.getNearestShopList(latitude, longitude),HttpStatus.OK);
		} 
		catch (DataInputException e) 
		{
			return new ResponseEntity<List<ShopDetails>>(new ArrayList<ShopDetails>(),HttpStatus.BAD_REQUEST);
		}		
	}
}
