package com.RestApi.PostCodeAvailability.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.RestApi.PostCodeAvailability.Exception.PostCodeNotFoundException;

import com.RestApi.PostCodeAvailability.Model.JsonClass;

import com.RestApi.PostCodeAvailability.Model.results;
import com.RestApi.PostCodeAvailability.Repository.PostCodeRepository;

@Service

public class PostCodeService {
	Logger log = LoggerFactory.getLogger(PostCodeService.class);
	@Autowired
	private PostCodeRepository postCodeRepository;
	@Autowired
	RestTemplate restTemplate;

	public results getPostCode(String postcode) {
		// TODO Auto-generated method stub
		log.info("Enter get Post Code in Server Layer");
		Optional<results> code = postCodeRepository.findByPostcode(postcode);
		if(code.isPresent())
		{
			log.info("PostCode is present in Database in  Server Layer");
			return postCodeRepository.findByPostcode(postcode).get();
		}
		else
		{
			log.info("PostCode is not present in Database in  Server Layer");
			return getPostCodeApi(postcode);
			//return null;
			//throw new PostCodeNotFoundException(HttpStatus.NOT_FOUND, "Sorry %s ,we haven't found such postCode"+ postCode);
		}
	}
	public results getPostCodeApi(String postcode) throws PostCodeNotFoundException
	{
		log.info("Entered in getpostcodeAPI in  Server Layer");
		String url="http://api.postcodes.io/postcodes?q="+postcode;
		JsonClass psCode=restTemplate.getForObject(url, JsonClass.class);
		try
		{
		log.info("json to java object");
		results r= new results();
			
			r.setPostcode(postcode);
			r.setLatitude(psCode.getResult().get(0).getLatitude());
			r.setLongitude(psCode.getResult().get(0).getLongitude());
			log.info("PostCode is available in api in  Server Layer");
			postCodeRepository.save(r);
			return r;
		}
		catch(Exception e)
		{
			throw new PostCodeNotFoundException(HttpStatus.NOT_FOUND, String.format("Sorry {%s}, we haven't found such postcode.", postcode));
		}
//		else
//			return new ResponseEntity<String>("Sorry %s,we have not found such PostCode" + postCode, HttpStatus.NOT_FOUND);	
	}

}
