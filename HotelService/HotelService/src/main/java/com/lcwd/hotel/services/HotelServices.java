package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelServices {
	
	//getAll
	List<Hotel> getAllHotels();
	
	//getSinglehotel
	Hotel getHotel(String hotelId);
	
	//addhotel
	Hotel addHotel(Hotel hotel);
	
	//updateHotel
	Hotel updateHotel(Hotel hotel);
	
	//delete hotel
	void removeHotel(String hotelId);

}
