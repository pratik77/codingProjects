package com.restapicheck.com.restapi.check;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SampleObjects {
	String xcord;
	String ycord;
	public String getXcord() {
		return xcord;
	}
	public void setXcord(String xcord) {
		this.xcord = xcord;
	}
	public String getYcord() {
		return ycord;
	}
	public void setYcord(String ycord) {
		this.ycord = ycord;
	}
	

}
