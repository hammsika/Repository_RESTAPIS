package com.RestApi.OfferProducts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApi.OfferProducts.Model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findBySecret(Boolean secret);

}
