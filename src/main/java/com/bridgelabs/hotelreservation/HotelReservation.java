package com.bridgelabs.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	public void addHotel(String hotelName, Map<CustomerType, Rate> priceOfHotel, int rating) {
		obj = new Hotel(hotelName, priceOfHotel, rating);
		hotel.add(obj);

	}

	public String findCheapestHotel(LocalDate first, LocalDate second) {
		ArrayList<LocalDate> dateArr = new ArrayList<LocalDate>(3);

		dateArr.add(first);
		long NoOFDays = ChronoUnit.DAYS.between(first, second);

		while (NoOFDays > 0) {
			dateArr.add(dateArr.get(dateArr.size() - 1).plusDays(1));
			NoOFDays--;
		}

		Integer[] price = { 0, 0, 0 };
		for (int i = 0; i < dateArr.size(); i++) {
			for (int j = 0; j < hotel.size(); j++) {

				if (dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					price[j] += hotel.get(j).priceOfHotel.get(CustomerType.REGULAR).weekEndRate;
				} else
					price[j] += hotel.get(j).priceOfHotel.get(CustomerType.REGULAR).weekDayRate;
			}
		}

		int rate = Arrays.asList(price).indexOf(Collections.min(Arrays.asList(price)));
		System.out.println("Cheapest hotel is  " + hotel.get(rate).hotelName + " Rate : " + price[rate]);

		return hotel.get(rate).hotelName;
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

}
