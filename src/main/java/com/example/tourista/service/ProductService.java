package com.example.tourista.service;

import com.example.tourista.entities.Hotel;

import java.util.List;

public interface ProductService {

    public Hotel saveHotel(Hotel hotel);

    public Hotel getHotelById(Long id);

    public List<Hotel> getAllHotels();

    public List<Hotel> searchHotels(String location,String experience,String pool);


}
