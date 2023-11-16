package com.lcwd.ratingservices.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.ratingservices.entities.Ratings;
import com.lcwd.ratingservices.exceptions.ResourceNotFoundException;
import com.lcwd.ratingservices.repository.RatingRepository;

@Service
public class RatingServicesImpl implements RatingServices {
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public List<Ratings> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public Ratings getRating(String rating) {
		// TODO Auto-generated method stub
		return ratingRepository.findById(rating).orElseThrow(() -> new ResourceNotFoundException(" Rating Id is not found on server!!!"));
				
	}

	@Override
	public Ratings addRating(Ratings ratings) {
		UUID randomUUID = UUID.randomUUID();
		ratings.setRatingId(randomUUID.toString());
		return ratingRepository.save(ratings);
	}

	@Override
	public Ratings updateRating(Ratings ratings) {
		// TODO Auto-generated method stub
		Ratings r = null;
		//System.out.println(r);
		List<Ratings> findAll = ratingRepository.findAll();
//		System.out.println(ratings);
//		System.out.println(findAll);
		
		for (Ratings ratings2 : findAll) {
//			System.out.println(ratings2.getRatingId());
//			System.out.println(ratings.getRatingId());
			if(ratings2.getRatingId().equals(ratings.getRatingId())) {
				System.out.println(ratings2);
				ratings2.setFeedback(ratings.getFeedback());
				ratings2.setRating(ratings.getRating());
				r = ratings2;
				//System.out.println(r);
				ratingRepository.save(r);
				
			}
		}
		return r;
	}

	@Override
	public void removeRating(String ratings) {
		// TODO Auto-generated method stub
		ratingRepository.deleteById(ratings);

	}

	@Override
	public List<Ratings> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Ratings> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
