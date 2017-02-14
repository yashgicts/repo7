package com.hcl.vo;

import com.hcl.model.ShopInfo;

/**
 * This class is used to set and get the shop name and address.
 *
 */
public class ShopVO {
	private String shopName;
	private ShopInfo shopAddress;

	/**
	 * This method is used to get Shop Name.
	 * @return shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * This method is used to set Shop Name.
	 * @param String
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
	 * @param ShopInfo
	 */
	public void setShopAddress(ShopInfo shopAddress) {
		this.shopAddress = shopAddress;
	}
}
