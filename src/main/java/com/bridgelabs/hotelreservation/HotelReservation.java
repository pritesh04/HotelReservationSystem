package com.bridgelabs.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelReservation {

	String name;
	Integer weekDays;
	Integer ratePerWeekdays;
	Integer rateForRewardCust;
	Integer rateWeekendForRegular;
	Integer rateWeekendForReward;
	List<HotelReservation> list = new ArrayList<HotelReservation>();
	// HashMap<CustomerType, Rate> map= new HashMap<>();

	public HotelReservation() {
	}

	public HotelReservation(String name, Integer weekDays, Integer ratePerWeekdays, Integer rateForRewardCust,
			Integer rateWeekendForRegular, Integer rateWeekendForReward) {

		this.name = name;
		this.weekDays = weekDays;
		this.ratePerWeekdays = ratePerWeekdays;
		this.rateForRewardCust = rateForRewardCust;
		this.rateWeekendForRegular = rateWeekendForRegular;
		this.rateWeekendForReward = rateWeekendForReward;
	}
	
	 public ArrayList<Hotel> hotel = new ArrayList<Hotel>();
	    Hotel obj;

	    public void addHotel(String hotelName, Map<CustomerType,Rate> priceOfHotel, int rating){
	        obj = new Hotel(hotelName, priceOfHotel, rating);
	        hotel.add(obj);

	    }

//	public void addHotel(String name, Integer weekDays, Integer ratePerWeekdays, Integer rateForRewardCust,
//			Integer rateWeekendForRegular, Integer rateWeekendForReward) {
//		list.add(new HotelReservation(name, weekDays, ratePerWeekdays, rateForRewardCust, rateWeekendForRegular,
//				rateWeekendForReward));
//
//	}
//
//	public int size() {
//		return list.size();
//
//	}
//
//	public void findHotel(String day1, String day2) throws ParseException {
//		int minrateForHotel;
//		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(day1);
//		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(day2);
//
//		int weekday = date.getDay();
//		int weekday1 = date.getDay();
//		System.out.println(weekday);
//		System.out.println(weekday1);
//
//		List<HotelReservation> cityList = list.stream()
//				.sorted(Comparator.comparing(HotelReservation::getRatePerWeekdays)).collect(Collectors.toList());
//		cityList.forEach(System.out::println);
//
//	}



}
