package com.RestApi.PostCodeAvailability.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PostCode")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class results {
	@Id
	@Column(name="post_code",nullable = false)
	private String postcode;
	@Column(name="longitude",nullable = false)
	private Double longitude;
	@Column(name="latitude",nullable = false)
	private Double latitude;
	

}
