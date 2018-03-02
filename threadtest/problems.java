package com.threadtest;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

public class problems {
	
	/*Method to get the nonrepeated char*/
	public void getthenonrepeatable(String check ){
		for (char c : check.toCharArray()) {
	          if (check.indexOf(c) == check.lastIndexOf(c)) {
	              System.out.println("First non repeated character in String " + check + " is:" + c);
	              break;
	          }
	      }
		
	}
	
	/*Method to get the list of countries*/
	/*public ArrayList<String> getListofcountry(HashMap<String, String> countryMap, String country)
	{
		
		
		return countryMap.entrySet().stream()
        .filter(map -> country.equals(map.getValue()))
        .map(map -> map.getKey())
        .collect();
//		System.out.println("Countries with the language "+Country+" are "+result);
//		return null;
	}*/
	
	/*Method to get map from array[]*/
	
	public void  getmapfromarray(List<String> Listcountries){
		
		 Map<String, String> result = Listcountries.stream().collect(
	                Collectors.toMap(x->x,x->"Hello "+x));
		 
		System.out.println(result);
		
		
	}
	
	/*Problem to get map of dates*/
	private void getmapfromdates(List<LocalDate> dateList) {
		
		Map<LocalDate,Long> resultDateMap=dateList.stream().collect(
                Collectors.toMap(x->x, x->ChronoUnit.DAYS.between(x,LocalDate.of(2018, 12, 25))));
		
		System.out.println(resultDateMap);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("\nProblem 1\n");
		/*Problem statement 1st non repeatable first char*/
		problems p=new problems();
		p.getthenonrepeatable("PAYPAL");
		
		System.out.println("\nProblem 2\n");
		/*Problem statement 2nd to make a MAP and get the language*/
		HashMap<String,String> Countrymap =new HashMap<>();
		ArrayList<String> countryList = new ArrayList<>();
		Countrymap.put("USA", "ENGLISH");
		Countrymap.put("CANADA", "ENGLISH");
		Countrymap.put("FRANCE", "FRENCH");
		Countrymap.put("INDIA", "HINDI");
		Countrymap.put("AUSTRALIA", "ENGLISH");
		String country="ENGLISH";
		//countryList=p.getListofcountry(Countrymap,country);
		
		System.out.println("\nProblem 3\n");
		/*Problem Statement to make map from array of country name*/
		
		String[] countries={"INDIA","USA","FRANCE","KENYA","CANADA"};
		List<String> Listcountries = Arrays.asList(countries);
		p.getmapfromarray(Listcountries);
		//Arrays.stream(countries).
		
		System.out.println("\nProblem 4\n");
		/*Problem to get Map of dates*/
		List<LocalDate> dateList = new ArrayList<>();
		dateList.add(LocalDate.of(2017, 04, 21));
		dateList.add(LocalDate.now().minus(Period.ofDays(100)));
		dateList.add(LocalDate.of(2017, 02, 20));
		dateList.add(LocalDate.of(2017, 02, 25));
		p.getmapfromdates(dateList);
		
		/**/
		
		
		
		
	}

	

}
