package com.RestApi.PostCodeAvailability.Controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.PostCodeAvailability.Model.results;
import com.RestApi.PostCodeAvailability.Service.PostCodeService;



@RestController
@RequestMapping("/Postcode")
public class PostCodeController {
	
	Logger log = LoggerFactory.getLogger(PostCodeController.class);
	@Autowired
	private PostCodeService postCodeService;
	
	
	@GetMapping("/{id}")
	public results getPostCode(@PathVariable("id") String postcode)
	{
		log.info("Controller Layer");
		return postCodeService.getPostCode(postcode);
	}

}
