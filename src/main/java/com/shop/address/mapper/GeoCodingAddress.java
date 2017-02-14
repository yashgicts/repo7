package com.shop.address.mapper;

public class GeoCodingAddress {
    private String longName;
    private String shortName;
    private String [] types;
	/**
	 * @return the longName
	 */
	public String getLongName() {
		return longName;
	}
	/**
	 * @param longName the longName to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * @return the types
	 */
	public String[] getTypes() {
		return types;
	}
	/**
	 * @param types the types to set
	 */
	public void setTypes(String[] types) {
		this.types = types;
	}
}
