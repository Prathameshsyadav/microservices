package com.lcwd.ratingservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.ratingservices.entities.Ratings;

public interface RatingRepository extends JpaRepository<Ratings, String> {

	//custom finder method
	List<Ratings> findByUserId(String userId);
	
	List<Ratings> findByHotelId(String hotelId);
}
