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
        return hotelRepository.getReferenceById(id);
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

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel hotelToUpdate = hotelRepository.getReferenceById(id);
        hotelToUpdate.setName(hotel.getName());
        hotelToUpdate.setShortDescription(hotel.getShortDescription());
        hotelToUpdate.setLongDescription(hotel.getLongDescription());
        hotelToUpdate.setLocation(hotel.getLocation());
        hotelToUpdate.setImageLink(hotel.getImageLink());
        hotelToUpdate.setPool(hotel.getPool());
        hotelToUpdate.setPrice(hotel.getPrice());
        hotelToUpdate.setExperience(hotel.getExperience());

        return hotelRepository.save(hotelToUpdate);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }


}
