package com.shop.address.mapper;

public class GeoCodingResponse {
	private String status;
    private GeoCodingResults [] results;
    private Boolean excludeFromSLO;
    private String errorMessage;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the results
	 */
	public GeoCodingResults[] getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(GeoCodingResults[] results) {
		this.results = results;
	}
	/**
	 * @return the excludeFromSLO
	 */
	public Boolean getExcludeFromSLO() {
		return excludeFromSLO;
	}
	/**
	 * @param excludeFromSLO the excludeFromSLO to set
	 */
	public void setExcludeFromSLO(Boolean excludeFromSLO) {
		this.excludeFromSLO = excludeFromSLO;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
