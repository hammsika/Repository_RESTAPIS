package com.RestApi.PostCodeAvailability.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.RestApi.PostCodeAvailability.Model.results;

@Repository
public interface PostCodeRepository extends JpaRepository<results, Long> {

	Optional<results> findByPostcode(String postcode);

}
