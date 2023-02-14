package com.example.tourista.controller;

import com.example.tourista.entities.Hotel;
import com.example.tourista.repository.HotelRepository;
import com.example.tourista.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hotel")
public class ProductsController {

    @Autowired
    private ProductService productService;
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        try {
            Hotel savedHotel = productService.saveHotel(hotel);
            return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        try {
            List<Hotel> allHotels = productService.getAllHotels();
            return new ResponseEntity<>(allHotels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") Long hotelId) {
        try {
            hotelRepository.deleteById(hotelId);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(
        //value = value in url
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "experience", required = false) String experience,
            @RequestParam(value = "pool", required = false) String pool)
    {
        List<Hotel> hotels = productService.searchHotels(location, experience, pool);
        System.out.println("hotels are "+hotels);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel>getHotelById(@PathVariable Long id){
        
        try {
            Hotel hotel = productService.getHotelById(id);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }



}
