package com.restapicheck.com.restapi.check;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App
{
	
	public static void main(String... args) throws Exception {
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Result[]> responseEntity = restTemplate.getForEntity("https://subrogation-iot.mybluemix.net/pratik", Result[].class);
//	    Response response = restTemplate.getForObject(
//	                           "https://subrogation-iot.mybluemix.net/pratik",
//	                            Response.class);
	    Result[] results = responseEntity.getBody();
	    for(Result result : results) {
	    	System.out.println(result.getPayload().getRandomNumber());
	    	System.out.println(result.getPayload().getSampleObject().xcord);
	    }
	    
	    //System.out.println(response.getRestResponse().getResult().getTopic());
	    
}
}
