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
	Integer[] price = { 0, 0, 0 };

	public void addHotel(String hotelName, Map<CustomerType, Rate> priceOfHotel, int rating) {
		obj = new Hotel(hotelName, priceOfHotel, rating);
		hotel.add(obj);

	}

	public String findCheapestHotel(LocalDate dateFirst, LocalDate dateSecond) {
		ArrayList<LocalDate> dates = new ArrayList<LocalDate>();

		dates.add(dateFirst);
		long daysInMid = ChronoUnit.DAYS.between(dateFirst, dateSecond);

		while (daysInMid > 0) {
			dates.add(dates.get(dates.size() - 1).plusDays(1));
			daysInMid--;
		}

		for (int i = 0; i < dates.size(); i++) {
			for (int j = 0; j < hotel.size(); j++) {
				if (dates.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| dates.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					price[j] += hotel.get(j).priceOfHotel.get(CustomerType.REGULAR).weekEndRate;
				} else
					price[j] += hotel.get(j).priceOfHotel.get(CustomerType.REGULAR).weekDayRate;
			}
		}

		Integer rate = Arrays.asList(price).indexOf(Collections.min(Arrays.asList(price)));

		return hotel.get(rate).hotelName;

	}

	public String bestRatedHotel(LocalDate first, LocalDate second) {
		Hotel[] hotelsList = new Hotel[3];
		ArrayList<Integer> rating = new ArrayList<>();
		ArrayList<LocalDate> date = new ArrayList<LocalDate>();

		date.add(first);
		long daysInBetween = ChronoUnit.DAYS.between(first, second);

		while (daysInBetween > 0) {
			date.add(date.get(date.size() - 1).plusDays(1));
			daysInBetween--;
		}

		for (int i = 0; i < date.size(); i++) {
			for (int j = 0; j < hotel.size(); j++) {

				if (date.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| date.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					price[j] += hotel.get(j).priceOfHotel.get(CustomerType.REGULAR).weekEndRate;
				} else
					price[j] += hotel.get(j).priceOfHotel.get(CustomerType.REGULAR).weekDayRate;
			}
		}

		for (int i = 0; i < hotel.size(); i++) {
			for (int j = 0; j < price.length; j++) {
				if (i != j) {
					if (price[i].equals(price[j])) {
						hotelsList[i] = hotel.get(i);
					}
				}
			}
		}

		for (int i = 0; i < hotelsList.length; i++) {
			if (hotelsList[i] != null) {
				rating.add(hotel.get(i).rating);
			}
		}

		Integer rate = rating.indexOf(Collections.max(rating));
		System.out.println("Cheapest hotel with best Ratings: " + hotel.get(rate).hotelName + " Ratings: "
				+ hotel.get(rate).rating + " with total rates: " + price[rate]);
		return hotel.get(rate).hotelName;
	}
	
	public void bestRatedHotel(){
	    ArrayList<Integer> bestRatedHotel = new ArrayList<Integer>();

	        for (int i=0; i<hotel.size() ;i++){
	            bestRatedHotel.add(hotel.get(i).rating);
	        }
	        int n = bestRatedHotel.indexOf(Collections.max(bestRatedHotel));
	        System.out.println("Best rated Hotel Name :- " + hotel.get(n).hotelName + " Rating :- " + hotel.get(n).rating
	        		);
	        
	    }
	
	 public void cheapestBestHotelRewarded(LocalDate first, LocalDate second) {
	    	Hotel[] hotelsReward = new Hotel[3];
	    	ArrayList<Integer> rating = new ArrayList<>();
	        ArrayList<LocalDate> date = new ArrayList<LocalDate>();

	        date.add(first);
	        long noOFDays = ChronoUnit.DAYS.between(first,second);

	        while (noOFDays>0){
	        	date.add(date.get(date.size()-1).plusDays(1));
	            noOFDays--;
	        }
	                
	        Integer[] amountGiven = null;
			for (Integer i=0; i<date.size(); i++){
	            for (Integer j=0; j<hotel.size(); j++) {

	                if (date.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
	                	amountGiven[i] += hotel.get(j).priceOfHotel.get(CustomerType.REWARDED).weekEndRate;
	                }
	                else
	                	amountGiven[j] += hotel.get(j).priceOfHotel.get(CustomerType.REWARDED).weekDayRate;
	            }
	        }
	        int rate = Arrays.asList(amountGiven).indexOf(Collections.min(Arrays.asList(amountGiven)));
	       
	    	
	    	for(int i=0; i<hotel.size(); i++) {
	    		for(int j=0; j<amountGiven.length; j++) {
	    			if(i != j) {   				
	    				if(amountGiven[i].equals(rate)) {
	    					hotelsReward[i] = hotel.get(i);
	    				}
	    			}
	    		}
	    	}
	    	
	       for(int i=0; i<hotelsReward.length; i++) {
	    	   if(hotelsReward[i] != null) {
	    		  rating.add(hotel.get(i).rating);
	    	   }
	       }
	       
	       if(hotelsReward[0] == null && hotelsReward[0] == null && hotelsReward[0] == null) {
	    	   int n = rate;
	    	   System.out.println("Cheapest hotel with best Ratings for Rewarded Customer : " + hotel.get(n).hotelName + " Ratings: " +hotel.get(n).rating+ "  Rates: " +amountGiven[n]);
	       }
	       else {
	           int n = rating.indexOf(Collections.max(rating));
	           System.out.println("Cheapest hotel with best Ratings for Rewarded Customer: " + hotel.get(n).hotelName + " Ratings: " +hotel.get(n).rating+ " Ratess: " +amountGiven[n]);
	       }

	       
	    }
	 public boolean validateDate(String d1){
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
	        dateFormat.setLenient(false);
	        try {
	            dateFormat.parse(d1.trim());
	        }
	        catch (ParseException pe) {
	            return false;
	        }
	        return true;
	    }

}
