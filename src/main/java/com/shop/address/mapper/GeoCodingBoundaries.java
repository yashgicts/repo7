package com.shop.address.mapper;

public class GeoCodingBoundaries {
	 private GeoCodingLongitudeLatitude northeast;
	 private GeoCodingLongitudeLatitude southwest;
	/**
	 * @return the northeast
	 */
	public GeoCodingLongitudeLatitude getNortheast() {
		return northeast;
	}
	/**
	 * @param northeast the northeast to set
	 */
	public void setNortheast(GeoCodingLongitudeLatitude northeast) {
		this.northeast = northeast;
	}
	/**
	 * @return the southwest
	 */
	public GeoCodingLongitudeLatitude getSouthwest() {
		return southwest;
	}
	/**
	 * @param southwest the southwest to set
	 */
	public void setSouthwest(GeoCodingLongitudeLatitude southwest) {
		this.southwest = southwest;
	}
	 
	 
}
