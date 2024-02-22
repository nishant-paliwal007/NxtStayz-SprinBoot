package com.example.nxtstayz.service;

import com.example.nxtstayz.repository.HotelRepository;
import com.example.nxtstayz.repository.HotelJpaRepository;
import com.example.nxtstayz.repository.RoomJpaRepository;
import com.example.nxtstayz.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelJpaService implements HotelRepository {

  @Autowired
  private HotelJpaRepository hotelJpaRepository;

  @Autowired
  private RoomJpaRepository roomJpaRepository;

  @Override
  public ArrayList<Hotel> getHotels() {
    List<Hotel> hotelList = hotelJpaRepository.findAll();
    ArrayList<Hotel> hotels = new ArrayList<>(hotelList);
    return hotels;
  }

  @Override
  public Hotel getHotelById(int hotelId) {
    try {
      Hotel hotel = hotelJpaRepository.findById(hotelId).get();
      return hotel;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Hotel addHotel(Hotel hotel) {
    hotelJpaRepository.save(hotel);
    return hotel;
  }

  @Override
  public Hotel updateHotel(int hotelId, Hotel hotel) {
    Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
    try {
      if (hotel.getHotelName() != null) {
        newHotel.setHotelName(hotel.getHotelName());
      }
      if (hotel.getLocation() != null) {
        newHotel.setLocation(hotel.getLocation());
      }
      if (hotel.getRating() != 0) {
        newHotel.setRating(hotel.getRating());
      }
      hotelJpaRepository.save(newHotel);
      return newHotel;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void deleteHotel(int hotelId) {
    try {
      hotelJpaRepository.deleteById(hotelId);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    throw new ResponseStatusException(HttpStatus.NO_CONTENT);

  }

  @Override
  public List<Room> getHotelRooms(int hotelId) {
    try {
      Hotel hotel = hotelJpaRepository.findById(hotelId).get();
      return roomJpaRepository.findByHotel(hotel);

    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}