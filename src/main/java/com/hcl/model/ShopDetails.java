package com.hcl.model;

import com.hcl.model.googlehelper.Location;

public class ShopDetails {

	private String shopName;
	private ShopInfo shopAddress;
	private Location location;

	/**
	 * This method is used to get Shop Location.
	 * @return Location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * This method is used to set Shop Location.
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * This method is used to get Shop Name.
	 * @return shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * This method is used to set Shop Name.
	 * @param shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * This method is used to get Shop Address.
	 * @return shopAddress
	 */
	public ShopInfo getShopAddress() {
		return shopAddress;
	}

	/**
	 * This method is used to set Shop Address.
	 * @param shopAddress
	 */
	public void setShopAddress(ShopInfo shopAddress) {
		this.shopAddress = shopAddress;
	}

}
