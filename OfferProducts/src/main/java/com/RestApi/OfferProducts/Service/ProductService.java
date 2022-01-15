package com.RestApi.OfferProducts.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.RestApi.OfferProducts.Exception.ProductNotFoundException;
import com.RestApi.OfferProducts.Model.Product;
import com.RestApi.OfferProducts.Repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Product getProductId(Long id) throws ProductNotFoundException
	{
//		Optional<Product> findById = productRepository.findById(id);
		try
		{
			return productRepository.findById(id).get();
		}catch(Exception e)
		{
			throw new ProductNotFoundException("Product Not Found", HttpStatus.NOT_FOUND);
		}
		
	}
	public List<Product> getSeretProducts(Boolean secret)
	{
		return productRepository.findBySecret(secret);
	}

}   
