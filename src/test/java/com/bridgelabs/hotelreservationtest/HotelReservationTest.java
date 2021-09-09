package com.bridgelabs.hotelreservationtest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabs.hotelreservation.CustomerType;
import com.bridgelabs.hotelreservation.HotelReservation;
import com.bridgelabs.hotelreservation.Rate;

public class HotelReservationTest {
	HotelReservation hotelReservation = new HotelReservation();
	@Test
	public void addHotel_Shouldreturn_SizeOfHotel() {
		

		HashMap<CustomerType, Rate> lMap = new HashMap<CustomerType, Rate>();
		lMap.put(CustomerType.REGULAR, new Rate(110, 90));
		lMap.put(CustomerType.REWARDED, new Rate(80, 80));
		hotelReservation.addHotel("Lakewood", lMap, 3);

		HashMap<CustomerType, Rate> bridgewoodMap = new HashMap<CustomerType, Rate>();
		bridgewoodMap.put(CustomerType.REGULAR, new Rate(160, 60));
		bridgewoodMap.put(CustomerType.REWARDED, new Rate(110, 50));
		hotelReservation.addHotel("Bridgewood", bridgewoodMap, 4);

		HashMap<CustomerType, Rate> ridgewoodMap = new HashMap<CustomerType, Rate>();
		ridgewoodMap.put(CustomerType.REGULAR, new Rate(220, 150));
		ridgewoodMap.put(CustomerType.REWARDED, new Rate(100, 40));
		hotelReservation.addHotel("Ridgewood", ridgewoodMap, 5);

		Assert.assertEquals(3, hotelReservation.hotel.size());
	}
	@Test
	public void priceOfCheapestHotel_ShouldGIveNameAndPrice()
	{
		  LocalDate date1 = LocalDate.of(2020,9,10);
	        LocalDate date2 = LocalDate.of(2020,9,11);
	       String name= hotelReservation.findCheapestHotel(date1,date2);
	        Assert.assertEquals("Lakewood", name);
	}
	
	@Test
	 public void BestRatingCheapestHotel() {
	    	DateTimeFormatter date = DateTimeFormatter.ofPattern("ddMMMyyyy");    	
	    	String firstDate = "11Sep2020";
	    	String secondDate = "12Sep2020";
	    	
	        LocalDate date1 = LocalDate.parse(firstDate,date);
	        LocalDate date2 = LocalDate.parse(secondDate,date);
	        String h2 =  hotelReservation.bestRatedHotel(date1,date2);
	        assertEquals("BridgeWood", h2);
	    }
	

}
