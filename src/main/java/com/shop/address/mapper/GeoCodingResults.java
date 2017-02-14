package com.shop.address.mapper;

public class GeoCodingResults {
	 private GeoCodingAddress [] geoCodingAddresses;
	    private String formattedAddress;
	    private GeoCodingGeometry geoCodingGeometry;
	    private Boolean partialMatch;
	    private String placeId;
	    private String [] types;
		/**
		 * @return the geoCodingAddresses
		 */
		public GeoCodingAddress[] getGeoCodingAddresses() {
			return geoCodingAddresses;
		}
		/**
		 * @param geoCodingAddresses the geoCodingAddresses to set
		 */
		public void setGeoCodingAddresses(GeoCodingAddress[] geoCodingAddresses) {
			this.geoCodingAddresses = geoCodingAddresses;
		}
		/**
		 * @return the formattedAddress
		 */
		public String getFormattedAddress() {
			return formattedAddress;
		}
		/**
		 * @param formattedAddress the formattedAddress to set
		 */
		public void setFormattedAddress(String formattedAddress) {
			this.formattedAddress = formattedAddress;
		}
		/**
		 * @return the geoCodingGeometry
		 */
		public GeoCodingGeometry getGeoCodingGeometry() {
			return geoCodingGeometry;
		}
		/**
		 * @param geoCodingGeometry the geoCodingGeometry to set
		 */
		public void setGeoCodingGeometry(GeoCodingGeometry geoCodingGeometry) {
			this.geoCodingGeometry = geoCodingGeometry;
		}
		/**
		 * @return the partialMatch
		 */
		public Boolean getPartialMatch() {
			return partialMatch;
		}
		/**
		 * @param partialMatch the partialMatch to set
		 */
		public void setPartialMatch(Boolean partialMatch) {
			this.partialMatch = partialMatch;
		}
		/**
		 * @return the placeId
		 */
		public String getPlaceId() {
			return placeId;
		}
		/**
		 * @param placeId the placeId to set
		 */
		public void setPlaceId(String placeId) {
			this.placeId = placeId;
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
