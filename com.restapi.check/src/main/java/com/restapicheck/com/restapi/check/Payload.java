package com.restapicheck.com.restapi.check;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {
	private int randomNumber;
	private SampleObjects sampleObject;

	public SampleObjects getSampleObject() {
		return sampleObject;
	}

	public void setSampleObject(SampleObjects sampleObject) {
		this.sampleObject = sampleObject;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public Payload() {
		super();
	}
}
