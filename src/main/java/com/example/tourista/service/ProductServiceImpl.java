package com.example.tourista.service;

import com.example.tourista.entities.Hotel;
import com.example.tourista.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);

    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> searchHotels(String location, String experience, String pool) {

        List<Hotel> searchedHotels =  hotelRepository.findByLocationAndExperienceAndPool(location, experience, pool);
        System.out.println(searchedHotels);
        return searchedHotels;

    }


}
