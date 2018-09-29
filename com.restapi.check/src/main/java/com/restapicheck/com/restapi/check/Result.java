package com.restapicheck.com.restapi.check;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	
	private String topic;
	private Payload payload;
	  

	  public Payload getPayload() {
		return payload;
	}


	public void setPayload(Payload payload) {
		this.payload = payload;
	}


	public Result() {

	  }


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


//	public String getPayload() {
//		return payload;
//	}
//
//
//	public void setPayload(String payload) {
//		this.payload = payload;
//	}

	  

}
