package com.shop.address.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.shop.address.util.LongitudeLatitudeValidator;

public class GetShopImpl implements GetShop {
	
	public String getShopsList(String longitude,String latitude){
		try{
			JSONArray responceJsonArray=new JSONArray();
			
			if (longitude==null || latitude==null) return null;
			if (longitude.isEmpty()||latitude.isEmpty()) return null;
			if (! LongitudeLatitudeValidator.validateLatitude(latitude)
					|| !LongitudeLatitudeValidator.validateLongitude(longitude))
				return null;
			String lngShortForm=longitude.substring(0,5);
			String latitudeShortForm=latitude.substring(0,5);
			 StringBuffer sb = new StringBuffer();
		     BufferedReader br = null;
		     try {
		    	 System.out.println("Before reading file");
		    	 	br = new BufferedReader(new FileReader("Shops.json"));
		    	 System.out.println("After reading file");
		         String temp;
		         while ((temp = br.readLine()) != null)
		             sb.append(temp);
		     } catch (IOException e) {
		    	 return null;
		       
		     } finally {
		         try {
		             br.close(); // stop reading
		         } catch (IOException e) {
		             e.printStackTrace();
		             
		         }
		     }  
		     int counter=0;
		     String shopsJsonString = sb.toString();
		     System.out.println("shopsJsonString"+shopsJsonString);
		     try{
				     JSONObject shopsJsonObject=new JSONObject(shopsJsonString);
				     JSONArray shopsArray=shopsJsonObject.getJSONArray("shops");
				    
				     for (int i=0;i<shopsArray.length();i++){
				    	 JSONObject temp=shopsArray.getJSONObject(i);
				    	String  tempLat=temp.getString("latitude");
				    	String  tempLng=temp.getString("longitude");
				    	 if (tempLat.contains(latitudeShortForm)&&tempLng.contains(lngShortForm))
				    	 {
				    		 responceJsonArray.put(temp);
				    		 counter++;
				    	 }
					  }
				     System.out.println("Response Json is :"+responceJsonArray.toString());
				     
			    }catch(Exception e){
			    	 return null;
			    }
		     if (counter>0)
	     		return responceJsonArray.toString();
		     else
		    	 return "No Shops Found near specified location";
		}catch(Exception e){
			return null;
		}
	}
	
	
}
