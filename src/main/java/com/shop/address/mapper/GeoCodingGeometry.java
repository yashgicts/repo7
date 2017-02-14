package com.shop.address.mapper;

public class GeoCodingGeometry {
	private GeoCodingBoundaries geoCodingBoundaries;
    private GeoCodingLongitudeLatitude geoCodingLongitudeLatitude;
    private String locationType;
    private GeoCodingBoundaries geoCodingBoundariesView;
	/**
	 * @return the geoCodingBoundaries
	 */
	public GeoCodingBoundaries getGeoCodingBoundaries() {
		return geoCodingBoundaries;
	}
	/**
	 * @param geoCodingBoundaries the geoCodingBoundaries to set
	 */
	public void setGeoCodingBoundaries(GeoCodingBoundaries geoCodingBoundaries) {
		this.geoCodingBoundaries = geoCodingBoundaries;
	}
	/**
	 * @return the geoCodingLongitudeLatitude
	 */
	public GeoCodingLongitudeLatitude getGeoCodingLongitudeLatitude() {
		return geoCodingLongitudeLatitude;
	}
	/**
	 * @param geoCodingLongitudeLatitude the geoCodingLongitudeLatitude to set
	 */
	public void setGeoCodingLongitudeLatitude(GeoCodingLongitudeLatitude geoCodingLongitudeLatitude) {
		this.geoCodingLongitudeLatitude = geoCodingLongitudeLatitude;
	}
	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}
	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	/**
	 * @return the geoCodingBoundariesView
	 */
	public GeoCodingBoundaries getGeoCodingBoundariesView() {
		return geoCodingBoundariesView;
	}
	/**
	 * @param geoCodingBoundariesView the geoCodingBoundariesView to set
	 */
	public void setGeoCodingBoundariesView(GeoCodingBoundaries geoCodingBoundariesView) {
		this.geoCodingBoundariesView = geoCodingBoundariesView;
	}
}
