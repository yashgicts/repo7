package com.shop.address.util;

public class LongitudeLatitudeValidator {
	public static boolean validateLongitude(String longitude){
		float longitudeFloat;
		try{
			longitudeFloat=Float.parseFloat(longitude);
		}catch(NumberFormatException e){
			System.out.println("Number format exception occured");
			return false;
		}
		if (longitudeFloat>180 || longitudeFloat<-180){
			System.out.println("Not a valid longitude. Longitude shoud be between (-180 and 180)");
			return false;
		}
		return true;
	}
	
	public static boolean validateLatitude(String latitude){
		float latitudeFloat;
		try{
			latitudeFloat=Float.parseFloat(latitude);
		}catch(NumberFormatException e){
			System.out.println("Number formating exception occured");
			return false;
		}
		if (latitudeFloat>90 || latitudeFloat<-90){
			System.out.println("Not a valid Latitude. Latitude shoud be between (-90 and 90)");
			return false;
		}
		return true;
	}
	
	

}
