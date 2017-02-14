package com.shop.address.geo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.address.mapper.GeoCodingAddress;
import com.shop.address.mapper.GeoCodingLongitudeLatitude;
import com.shop.address.mapper.GeoCodingResponse;
import com.shop.address.util.RetrieveShopAddressConstants;
import com.shop.address.vo.PostalCodeResponce;
import com.shop.address.vo.ShopsVO;


/**
 * @author yash
 *
 */
public class GeoCodingAPIHelper {
	
	@SuppressWarnings("deprecation")
	public ShopsVO getAddressWithLongitudeLatitude(ShopsVO shop){
		StringBuffer address=new StringBuffer();
		ShopsVO shopVo = new ShopsVO();
		StringBuilder url = new StringBuilder("http://maps.googleapis.com/maps/api/geocode/json?");
		  
	    url.append("sensor=false&address=");
	    
	    address.append(shop.getShopName());
		address.append(",");
		address.append(shop.getShopNumber());
		address.append(",");
		address.append(shop.getPostalCode());
		System.out.println("Adress is : "+address);
	    url.append( URLEncoder.encode(address.toString()) );
	  
	    // request url http://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address) + "&sensor=false"
	    try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
	        HttpGet request = new HttpGet(url.toString());

	        request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.6.0");
	        request.setHeader("Host", "maps.googleapis.com");
	        request.setHeader("Connection", "keep-alive");
	        request.setHeader("Accept-Language", "en-US,en;q=0.5");
	        request.setHeader("Accept-Encoding", "gzip, deflate");

	        try (CloseableHttpResponse response = httpclient.execute(request)) {
	            org.apache.http.HttpEntity entity = response.getEntity();
	            System.out.println("Responce is +"+response);
	            // recover String response (for debug purposes)
	            StringBuilder result = new StringBuilder();
	            try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    result.append(inputLine);
	                    result.append("\n");
	                }
	               System.out.println("Result is :"+result);
	            }catch (Exception e) {
	            	shopVo.setStatus(RetrieveShopAddressConstants.APIRESPONCE_UNKNOWN_ERROR);
	            	return shopVo;
				}
	        

	            ObjectMapper mapper = new ObjectMapper();
	            GeoCodingResponse geoCodeRes = mapper.readValue(result.toString(), GeoCodingResponse.class);

	            if (!RetrieveShopAddressConstants.GEOCODING_RES_OK.equals(geoCodeRes.getStatus())) {
	               shopVo.setStatus(geoCodeRes.getStatus());
	               return shopVo;
	            }
	         
	            shopVo.setStatus(geoCodeRes.getStatus()); 
	           GeoCodingLongitudeLatitude longLatitudes= geoCodeRes.getResults()[0].getGeoCodingGeometry().getGeoCodingLongitudeLatitude();
	           shopVo.setLatitude(longLatitudes.getLatitude());
	           shopVo.setLongitude(longLatitudes.getLongitude());
	           shopVo.setShopName(shop.getShopName());
	           shopVo.setShopNumber(shop.getShopNumber());
	           shopVo.setPostalCode(shop.getPostalCode());
	           System.out.println("Longitude : "+shopVo.getLongitude());
	        }catch (Exception e) {
				shopVo.setStatus(RetrieveShopAddressConstants.APIRESPONCE_UNKNOWN_ERROR);
			}
	    }catch (Exception e) {
	    	shopVo.setStatus(RetrieveShopAddressConstants.APIRESPONCE_UNKNOWN_ERROR);
		}


		return shopVo;
	}
	
	public PostalCodeResponce getAddressPostalCode(String longitude,String latitude){
		
		PostalCodeResponce postalCodeResponse=new PostalCodeResponce();
		System.out.println("Logitude is "+longitude +" and Latitude is : +"+latitude);
		if (longitude==null || latitude==null ){
			postalCodeResponse.setStatus(RetrieveShopAddressConstants.GEOCODING_RES_INVALID_REQUEST);
        	postalCodeResponse.setPostalCode(null);
		}else{
			if ( (longitude.length()==0) || (latitude.length()==0)){
				postalCodeResponse.setStatus(RetrieveShopAddressConstants.GEOCODING_RES_INVALID_REQUEST);
            	postalCodeResponse.setPostalCode(null);
			}
				
		}
		String latlang="&latlng="+longitude+","+latitude;
		 StringBuilder url = new StringBuilder("http");
		  
		    url.append("://maps.googleapis.com/maps/api/geocode/json?");
		    url.append(latlang);
		    try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
		        HttpGet request = new HttpGet(url.toString());
		        request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.6.0");
		        request.setHeader("Host", "maps.googleapis.com");
		        request.setHeader("Connection", "keep-alive");
		        request.setHeader("Accept-Language", "en-US,en;q=0.5");
		        request.setHeader("Accept-Encoding", "gzip, deflate");

		        try (CloseableHttpResponse response = httpclient.execute(request)) {
		        	org.apache.http.HttpEntity  entity = response.getEntity();
		            StringBuilder result = new StringBuilder();
		            try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
		                String inputLine;
		                while ((inputLine = in.readLine()) != null) {
		                    result.append(inputLine);
		                    result.append("\n");
		                }
		               System.out.println("Result is :"+result);
		            }catch (Exception e) {
		            	postalCodeResponse.setStatus(RetrieveShopAddressConstants.GEOCODING_RES_UNKNOWN_ERROR);
		            	postalCodeResponse.setPostalCode(null);
					}

		            ObjectMapper mapper = new ObjectMapper();
		            GeoCodingResponse geoCodeRes = mapper.readValue(result.toString(), GeoCodingResponse.class);

		            if (!RetrieveShopAddressConstants.GEOCODING_RES_OK.equals(geoCodeRes.getStatus())) {
		            	postalCodeResponse.setStatus(geoCodeRes.getStatus());
		            	postalCodeResponse.setPostalCode(null);
					}
		            
		            GeoCodingAddress addressComponents[]= geoCodeRes.getResults()[0].getGeoCodingAddresses();
		            for (GeoCodingAddress geoCodingAdressComponent : addressComponents) {
		            	if(RetrieveShopAddressConstants.ADDRESSCOMPONENT_TYPE_POSTALCODE.equalsIgnoreCase(geoCodingAdressComponent.getTypes()[0])){
		            		System.out.println("Address component type is : "+geoCodingAdressComponent.getTypes()[0]);
		            		System.out.println(geoCodingAdressComponent.getLongName());
		            		postalCodeResponse.setStatus(RetrieveShopAddressConstants.GEOCODING_RES_OK);
			            	postalCodeResponse.setPostalCode(geoCodingAdressComponent.getLongName());
						
		            	}
					}
		        }catch (Exception e) {
		        	postalCodeResponse.setStatus(RetrieveShopAddressConstants.GEOCODING_RES_UNKNOWN_ERROR);
	            	postalCodeResponse.setPostalCode(null);
				}
		    }catch (Exception e) {
		    	postalCodeResponse.setStatus(RetrieveShopAddressConstants.GEOCODING_RES_UNKNOWN_ERROR);
            	postalCodeResponse.setPostalCode(null);
			}
		    return postalCodeResponse;
	}

}
