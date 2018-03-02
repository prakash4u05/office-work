package com.threadtest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Lambdaexppractice {
	
	
	
	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer.getSalary());
		}

		System.out.println("After Sort");

		//lambda here!
		listDevs.sort((o1,o2)->o2.getSalary().compareTo(o1.getSalary()));

		//java 8 only, lambda also, to print the List
		//listDevs.forEach((developer)->System.out.println(developer.getSalary()));
		listDevs.forEach(x-> System.out.println(x.getSalary()));
		//another example
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		List<String> list1 = new ArrayList<>();
		list1.add("PR");
		list1.add("AM");
		//list1.sort();

		items.forEach((key,value)->System.out.println("Item : " + key + " Count : " + value));
		List<Integer> Listcheck =items.values().stream().collect(Collectors.toList());//filter(x->!(x==20)).map(x -> x*20)
		Listcheck.forEach(x->{if(!(x==20)){System.out.println(x);}else{System.out.println(x*20);}});
		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E" +v);
			}
		});
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("80000"), 33));
		result.add(new Developer("alvin", new BigDecimal("70000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;

	}

}
