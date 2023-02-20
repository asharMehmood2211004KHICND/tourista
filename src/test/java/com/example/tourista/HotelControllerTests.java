package com.example.tourista;




import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.example.tourista.entities.Hotel;
import com.example.tourista.service.ProductServiceImpl;
import org.hibernate.annotations.UpdateTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;






@WebMvcTest
public class HotelControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceImpl hotelService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void postANewHotel() throws Exception{

        Hotel hotel = Hotel.builder()
                .name("myName")
                .shortDescription("myShortDescription")
                .longDescription("myLongDescription")
                .imageLink("myImageLink")
                .location("myLocation")
                .experience("myExperience")
                .pool("myPool")
                .price("myPrice")
                .build();
        given(hotelService.saveHotel(any(Hotel.class))).willAnswer((invocation)->invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/hotel/save")
        // .contentType(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(hotel)));

        response.andDo(print())
        .andExpect(jsonPath("$.name", is(hotel.getName())));


    }

    // @Test
    // public void canPostANewHotel() throws Exception {
    //     Hotel hotel = Hotel.builder()
    //             .name("PC Hotel")
    //             .shortDescription("This is Pc hotel")
    //             .longDescription("it is long description of Pc hotel")
    //             .imageLink("img")
    //             .location("Karchi")
    //             .experience("Budget")
    //             .pool("No")
    //             .price("100")
    //             .build();
    //     given(hotelService.saveHotel(any(Hotel.class))).willAnswer(invocation -> invocation.getArgument(0));
    //     ResultActions response = mockMvc.perform(post("/api/hotels")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(hotel)));
    //     response.andDo(print())
    //             .andExpect(status().isCreated())
    //             .andExpect(jsonPath("$.hotelName", is(hotel.getName())))
    //             .andExpect(jsonPath("$.price", is(hotel.getPrice())))
    //             .andExpect(jsonPath("$.id", is(hotel.getId())))
    //             .andExpect(jsonPath("$.pool", is(hotel.getPool())))
    //             // .andExpect(jsonPath("$.experienceLevel", is(hotel.getExperienceLevel())))
    //             // .andExpect(jsonPath("$.img", is(hotel.getImg())))
    //             // .andExpect(jsonPath("$.location", is(hotel.getLocation())))
    //             .andExpect(jsonPath("$.longDescription", is(hotel.getLongDescription())))
    //             .andExpect(jsonPath("$.shortDescription", is(hotel.getShortDescription())));
    // }
    


}



