package com.lcwd.ratingservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.ratingservices.entities.Ratings;
import com.lcwd.ratingservices.services.RatingServices;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingServices ratingServices;
	
	//getAllRatings
	@GetMapping
	public ResponseEntity<List<Ratings>> findAllRatings() {
		List<Ratings> allRating = ratingServices.getAllRating();
		return   ResponseEntity.status(HttpStatus.ACCEPTED).body(allRating);
	}
	
	//getRatingsById
	@GetMapping("/{ratingID}")
	public ResponseEntity<Ratings> findRatingById(@PathVariable String ratingID) {
		Ratings rating = ratingServices.getRating(ratingID);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rating);
	}
	
	//save ratings
	@PostMapping
	public ResponseEntity<Ratings> saveRatings(@RequestBody Ratings r) {
		Ratings addRating = ratingServices.addRating(r);
		return ResponseEntity.status(HttpStatus.CREATED).body(addRating);
	}
	
	//updateRatings
	@PutMapping
	public ResponseEntity<Ratings> updateRatings(@RequestBody Ratings r) {
		System.out.println("update rating");
		Ratings updateRating = ratingServices.updateRating(r);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateRating);
	}
	
	//deleteratings
	@DeleteMapping
	public void deleteRatings(String ratingid) {
		ratingServices.removeRating(ratingid);
	}
	
	@GetMapping("/users/{userID}")
	public ResponseEntity<List<Ratings>> getRatingByUserid(@PathVariable String userID) {
		List<Ratings> ratingByUserId = ratingServices.getRatingByUserId(userID);
		return ResponseEntity.ok(ratingByUserId);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Ratings>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Ratings> ratingByHotelId = ratingServices.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingByHotelId);
	}
}
