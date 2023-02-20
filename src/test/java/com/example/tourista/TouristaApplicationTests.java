package com.example.tourista;

import com.example.tourista.entities.Hotel;
import com.example.tourista.repository.HotelRepository;
import com.example.tourista.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class TouristaApplicationTests {


	@Mock
	private HotelRepository hotelRepository;

	@InjectMocks
	private ProductServiceImpl hotelServiceImpl;


	@Test
	void contextLoads() {
	}

	@Test
	void getAndSetHotelID(){
		Hotel cut = new Hotel();
		Long myId =  1L;
		cut.setId(myId);
		assertEquals(myId,cut.getId());
	}

	@Test
	void getAndSetHotelName(){
		Hotel cut = new Hotel();
		String myName = "pc";
		cut.setName("pc");
		assertEquals(myName,cut.getName());
	}

	@Test
	void getAndSetHotelProperties(){
		Hotel cut = new Hotel();
		String myShortDescription = "a hotel short";
		String myLongDescription = "a hotel long";
		String myImageLink = "hotel.png";
		String myLocation = "karachi";
		String myExperience = "luxury";
		String myPool = "yes";
		String myPrice = "100";

		cut.setShortDescription(myShortDescription);
		cut.setLongDescription(myLongDescription);
		cut.setImageLink(myImageLink);
		cut.setLocation(myLocation);
		cut.setExperience(myExperience);
		cut.setPool(myPool);
		cut.setPrice(myPrice);

		assertEquals(myShortDescription,cut.getShortDescription());
		assertEquals(myLongDescription,cut.getLongDescription());
		assertEquals(myImageLink,cut.getImageLink());
		assertEquals(myLocation,cut.getLocation());
		assertEquals(myExperience,cut.getExperience());
		assertEquals(myPool,cut.getPool());
		assertEquals(myPrice,cut.getPrice());


	}

	@Test
	void AllArgsConstructorHotel(){
		Long myId = 1L;
		String myName = "pc";
		String myShortDescription = "a hotel short";
		String myLongDescription = "a hotel long";
		String myImageLink = "hotel.png";
		String myLocation = "karachi";
		String myExperience = "luxury";
		String myPool = "yes";
		String myPrice = "100";

		Hotel cut = new Hotel(myId,myName,myShortDescription,myLongDescription,myImageLink,myLocation,myExperience,myPool,myPrice);
		assertEquals(myId,cut.getId());
		assertEquals(myName,cut.getName());
		assertEquals(myShortDescription,cut.getShortDescription());
		assertEquals(myLongDescription,cut.getLongDescription());
		assertEquals(myImageLink,cut.getImageLink());
		assertEquals(myLocation,cut.getLocation());
		assertEquals(myExperience,cut.getExperience());
		assertEquals(myPool,cut.getPool());
		assertEquals(myPrice,cut.getPrice());

	}

	@Test
	void builderHotel(){
		Long myId = 1L;
		String myName = "pc";
		String myShortDescription = "a hotel short";
		String myLongDescription = "a hotel long";
		String myImageLink = "hotel.png";
		String myLocation = "karachi";
		String myExperience = "luxury";
		String myPool = "yes";
		String myPrice = "100";

		Hotel cut = Hotel.builder()
				.id(myId)
				.name(myName)
				.shortDescription(myShortDescription)
				.longDescription(myLongDescription)
				.imageLink(myImageLink)
				.location(myLocation)
				.experience(myExperience)
				.pool(myPool)
//				.price(myPrice)
				.build();

		assertEquals(myId,cut.getId());
		assertEquals(myName,cut.getName());
		assertEquals(myShortDescription,cut.getShortDescription());
		assertEquals(myLongDescription,cut.getLongDescription());
		assertEquals(myImageLink,cut.getImageLink());
		assertEquals(myLocation,cut.getLocation());
		assertEquals(myExperience,cut.getExperience());
		assertEquals(myPool,cut.getPool());

	}


	@Test
	void canSaveAHotel(){
		Long myId = 1L;
		String myName = "pc";
		String myShortDescription = "a hotel short";
		String myLongDescription = "a hotel long";
		String myImageLink = "hotel.png";
		String myLocation = "karachi";
		String myExperience = "luxury";
		String myPool = "yes";
		String myPrice = "100";
		Hotel cut =  Hotel.builder()
				.id(myId)
				.name(myName)
				.shortDescription(myShortDescription)
				.longDescription(myLongDescription)
				.imageLink(myImageLink)
				.location(myLocation)
				.experience(myExperience)
				.pool(myPool)
				.price(myPrice)
				.build();

		given(hotelRepository.save(cut)).willReturn(cut);
		Hotel savedHotel = hotelServiceImpl.saveHotel(cut);
		assertNotNull(savedHotel);
	}


	@Test
	void canGetAHotel(){
		Long myId = 1L;
		String myName = "pc";
		String myShortDescription = "a hotel short";
		String myLongDescription = "a hotel long";
		String myImageLink = "hotel.png";
		String myLocation = "karachi";
		String myExperience = "luxury";
		String myPool = "yes";
		String myPrice = "100";
		Hotel cut =  Hotel.builder()
				.id(myId)
				.name(myName)
				.shortDescription(myShortDescription)
				.longDescription(myLongDescription)
				.imageLink(myImageLink)
				.location(myLocation)
				.experience(myExperience)
				.pool(myPool)
				.price(myPrice)
				.build();
		given(hotelRepository.getReferenceById(myId)).willReturn(cut);
		Hotel gottenHotel = hotelServiceImpl.getHotelById(cut.getId());
		assertEquals(cut.getName(),gottenHotel.getName());


	}



	@Test
	void canUpdateAHotel() {
		Long myId = 1L;
		String myName = "pc";
		String myShortDescription = "a hotel short";
		String myLongDescription = "a hotel long";
		String myImageLink = "hotel.png";
		String myLocation = "karachi";
		String myExperience = "luxury";
		String myPool = "yes";
		String myPrice = "100";

		// mock the hotelRepository.getReferenceById() method
		Hotel hotelToUpdate = Hotel.builder()
				.id(myId)
				.name("old name")
				.shortDescription("old short description")
				.longDescription("old long description")
				.imageLink("old image link")
				.location("old location")
				.experience("old experience")
				.pool("no")
				.price("50")
				.build();
		given(hotelRepository.getReferenceById(myId)).willReturn(hotelToUpdate);

		// create the updated hotel object
		Hotel updatedHotel = Hotel.builder()
				.id(myId)
				.name(myName)
				.shortDescription(myShortDescription)
				.longDescription(myLongDescription)
				.imageLink(myImageLink)
				.location(myLocation)
				.experience(myExperience)
				.pool(myPool)
				.price(myPrice)
				.build();

		// mock the hotelRepository.save() method
		given(hotelRepository.save(hotelToUpdate)).willReturn(updatedHotel);

		// call the service method to update the hotel
		Hotel result = hotelServiceImpl.updateHotel(myId, updatedHotel);

		// assert that the hotel was updated successfully
		assertEquals(myName, result.getName());
		assertEquals(myShortDescription, result.getShortDescription());
		assertEquals(myLongDescription, result.getLongDescription());
		assertEquals(myImageLink, result.getImageLink());
		assertEquals(myLocation, result.getLocation());
		assertEquals(myExperience, result.getExperience());
		assertEquals(myPool, result.getPool());
		assertEquals(myPrice, result.getPrice());
	}


	@Test
	void canDeleteAHotel(){
		Long myId = 1L;
		willDoNothing().given(hotelRepository).deleteById(myId);
		hotelServiceImpl.deleteHotel(myId);
//		verify(hotelRepository,times(1).deleteById(myId));
		verify(hotelRepository,times(1)).deleteById(myId);
	}

	@Test
	void canGetAllHotels(){
		Hotel cut1 = Hotel.builder()
				.id(1L)
				.name("myName")
				.shortDescription("myShortDescription")
				.longDescription("myLongDescription")
				.imageLink("myImageLink")
				.location("myLocation")
				.experience("myExperience")
				.pool("myPool")
				.price("my")
				.build();

		Hotel cut2 = Hotel.builder()
				.id(2L)
				.name("myName")
				.shortDescription("myShortDescription")
				.longDescription("myLongDescription")
				.imageLink("myImageLink")
				.location("myLocation")
				.experience("myExperience")
				.pool("myPool")
				.price("my")
				.build();

		given(hotelRepository.findAll()).willReturn(List.of(cut1,cut2));
		List<Hotel> hotelList = hotelServiceImpl.getAllHotels();
		assertNotNull(hotelList);
		assertEquals(2,hotelList.size());

	}









}











