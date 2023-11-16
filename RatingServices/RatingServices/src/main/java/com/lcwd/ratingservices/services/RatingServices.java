package com.lcwd.ratingservices.services;

import java.util.List;

import com.lcwd.ratingservices.entities.Ratings;

public interface RatingServices {
	
	List<Ratings> getAllRating();
	
	Ratings getRating(String rating);
	
	Ratings addRating(Ratings ratings);
	
	Ratings updateRating(Ratings ratings);
	
	void removeRating(String ratings);
	
	List<Ratings> getRatingByUserId(String userId);
	
	List<Ratings> getRatingByHotelId(String hotelId);
	
}
