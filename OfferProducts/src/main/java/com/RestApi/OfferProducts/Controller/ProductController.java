package com.RestApi.OfferProducts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.OfferProducts.Model.Product;
import com.RestApi.OfferProducts.Service.ProductService;

@RestController
@RequestMapping("/Products")
public class ProductController {
	@Autowired
	private ProductService productService;
@PostMapping("/")	
public Product saveProduct(@RequestBody Product product)
{
	return productService.saveProduct(product);
}
@GetMapping("/{id}")
public Product getByProductId(@PathVariable("id") Long id)
{
	return productService.getProductId(id);
}
@GetMapping("/all")
public List<Product> getByProductId()
{
	return productService.getSeretProducts(false);
}
	
	

}
