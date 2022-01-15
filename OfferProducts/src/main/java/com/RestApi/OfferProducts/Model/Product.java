package com.RestApi.OfferProducts.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
@Id
@Column(name="product_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name="product_name", nullable=false)
private String name;
@Column(name="product_description", nullable=false)
private String description;
@Column(name="product_offer", nullable=false)
private Boolean secret;

}