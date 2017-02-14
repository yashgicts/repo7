package com.shop.address;


import static org.junit.Assert.assertNotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RetrieveShopAddress.class)
@WebAppConfiguration
public class RetrieveShopAddressTests {
	  private RestTemplate restTemplate = new TestRestTemplate();
	  		
	@Test
	public void testRegisterShopsAPI() throws JSONException{
		  JSONObject requestBody=new JSONObject();
		  requestBody.put("shopName", "Citadel");
		  requestBody.put("shopNumber", "d3");
		  requestBody.put("postalCode", "411001");
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		  HttpEntity<String> httpEntity =new HttpEntity<String>(requestBody.toString(), requestHeaders);
		  String response=restTemplate.postForObject("http://localhost:8089/registerStore", httpEntity,String.class);
		  assertNotNull(response);
	}
	
	@Test
	public void testGetShopsAPI() throws JSONException{
		final String uri = "http://localhost:8089/getStoreList?longitude=73.90675519999999&latitude=18.5203044";
		String response=restTemplate.getForObject(uri,String.class);
		assertNotNull(response);
	}
	
	@Test
	public void testGetShopswithInvalidInputsAPI() throws JSONException{
		  String response=restTemplate.getForObject("http://localhost:8089/getStoreList?longitude=189&latitude=99",String.class);
		  assertNotNull(response);
	}
}
