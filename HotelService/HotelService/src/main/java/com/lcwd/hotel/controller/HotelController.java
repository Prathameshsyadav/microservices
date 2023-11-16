package com.lcwd.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelServices hotelServices;
	
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
		Hotel hotel2 = hotelServices.addHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> allHotels = hotelServices.getAllHotels();
		return ResponseEntity.ok(allHotels);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
		Hotel hotel = hotelServices.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.FOUND).body(hotel);
	}
	
	@PutMapping
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
		Hotel updateHotel = hotelServices.updateHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(updateHotel);
	}
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity deleteHotel(@PathVariable String hotelId) {
		hotelServices.removeHotel(hotelId);
		return ResponseEntity.ok().build();
	}
}
