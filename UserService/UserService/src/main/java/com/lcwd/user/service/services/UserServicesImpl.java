package com.lcwd.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Ratings;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelServices;
import com.lcwd.user.service.repository.UserRepository;




@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelServices hotelService;
	
	

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	
	
	
	
	public User getSingleUser(String userId) {
		
	    User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad

        Ratings[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Ratings[].class);
        //logger.info("{} ", ratingsOfUser);
        List<Ratings> ratings = Arrays.asList(ratingsOfUser);
        List<Ratings> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            // logger.info("response status code: {} ",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
		
	    // Get single user

		/*   User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on the server: " + userId));
	   
	    // Fetch ratings of the user using a REST API
	    Ratings[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Ratings[].class);
	    
	    List<Ratings> ratingList = Arrays.asList(ratings);
	   // System.out.println(ratingList.getClass().getName());
	
	/*
   ratingList.forEach(r -> {
	    	System.out.println("foreach called");
	    	Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+r.getHotelId(), Hotel.class);
	    	r.setHotel(hotel);    	
	    	System.out.println(hotel);
	    	r.setHotel(hotel);
	    	
    });
	 

       ratingList.forEach(r -> {
         
            	System.out.println("hello");
            	System.out.println(r.getHotelId());
                Hotel hotel = hotelService.getHotel(r.getHotelId());
                System.out.println(hotel);
                r.setHotel(hotel);
           
        });
        
	   //user.setRatings(rating);
	   user.setRatings(ratingList);
	
	    return user;	*/
	}

	
	

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		
		User us = null;
		
		// TODO Auto-generated method stub
		String userId = user.getUserId();
		String userName = user.getUserName();
		String userEmail = user.getUserEmail();
		String about = user.getAbout();
		
		//System.out.println(userId+" "+userName+" "+userEmail+" "+about);
	
		Optional<User> userToUpdate = userRepository.findAll()
		        .stream()
		        .filter(Userr -> Userr.getUserId().equals(userId))
		        .findFirst();
		//System.out.println(userToUpdate);
		    
		    if (userToUpdate.isPresent()) {
		        User updatedUser = userToUpdate.get();
		        updatedUser.setUserName(userName);
		        updatedUser.setUserEmail(userEmail);
		        updatedUser.setAbout(about);
		        us = updatedUser;
		       // System.out.println(updatedUser);
		        //System.out.println(us);
		        userRepository.save(updatedUser);
		        
		    }
		    return us;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
		
	}

	

	

}
