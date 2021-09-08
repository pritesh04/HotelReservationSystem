package com.bridgelabs.hotelreservation;

import java.util.Map;

public class Hotel {
	String hotelName;
	Map<CustomerType, Rate> priceOfHotel;
	int rating;

	public Hotel(String hotelName, Map<CustomerType,Rate> priceOfHotel, int rating){
        this.hotelName = hotelName;
        this.priceOfHotel = priceOfHotel;
        this.rating = rating;
    }
}
