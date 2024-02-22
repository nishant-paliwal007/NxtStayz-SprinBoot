package com.example.nxtstayz.controller;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.HotelJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class HotelController {

    @Autowired
    private HotelJpaService hotelService;

    @GetMapping("/hotels")
    public ArrayList<Hotel> getHotels() {
        return hotelService.getHotels();
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotelById(@PathVariable("hotelId") int hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/hotels/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") int hotelId, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int hotelId) {
        hotelService.deleteHotel(hotelId);
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getHotelRooms(@PathVariable("hotelId") int hotelId) {
        return hotelService.getHotelRooms(hotelId);
    }

}