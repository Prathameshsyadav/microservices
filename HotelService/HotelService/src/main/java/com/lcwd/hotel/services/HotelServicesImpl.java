package com.lcwd.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repository.HotelRepository;

@Service
public class HotelServicesImpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Resource was not found on server!!!"));
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		UUID randomUUID = UUID.randomUUID();
		hotel.setHotelId(randomUUID.toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel h = null;
		String hotelName = hotel.getHotelName();
		String hotelLocation = hotel.getHotelLocation();
		String about = hotel.getAbout();
		
		List<Hotel> findAll = hotelRepository.findAll();
		for (Hotel hotel2 : findAll) {
			if(hotel2.getHotelId() == hotel.getHotelId()) {
				hotel2.setAbout(about);
				hotel2.setHotelName(hotelName);
				hotel2.setHotelLocation(hotelLocation);
				h = hotel2;
				hotelRepository.save(h);
			}
			
		}
		return h;
	}

	@Override
	public void removeHotel(String hotelId) {
		// TODO Auto-generated method stub
		
		hotelRepository.deleteById(hotelId);

	}

}
