package com.may.ple.dg.ricoh.criteria;

public abstract class CommonCriteriaResp {
	private int statusCode;
	
	public CommonCriteriaResp(){}
	
	public CommonCriteriaResp(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
