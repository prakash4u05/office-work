package com.threadtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewLambdaTest implements DefaultInterface,AnotherInterface {
	
	@Override
	public void check()
	{
		System.out.println("checked");
	}
	
	@Override
	public void optionalcheck()
	{
		
		System.out.println("ok");
	}
	
	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	static void modifyTheValue(int v, Function<Integer, Integer> function){
	    int result = function.apply(v);
	    System.out.println(result);
	  }
	 static void display(Supplier<Integer> arg) {
	        System.out.println(arg.get());
	    }
	
	
	public static void main(String[] args) {
		
		  Optional<String> gender = Optional.of("MALE");
		
		NewLambdaTest test1= new NewLambdaTest();
		
		test1.check();
		test1.optionalcheck();
		test1.print("");
		test1.isNull("abc");
		// for predicate test
		List<String> l = new ArrayList<>();
	    l.add("successfully");
	    l.add("easy");
	    l.add("fortune");
	    List<String> filtered = l.stream().filter( r -> r.endsWith("y")).collect(Collectors.toList());
	    
	    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
	    numbers.forEach(System.out::println);
	    //List<String> checkagain=l.stream().map(mapper)
	    System.out.println(filtered);
	    
	    //checking other implementation
	    int n1 = 5;
	    modifyTheValue(n1, val-> val + 10);
	    modifyTheValue(n1, val-> val * 100);
		//other check
	    int n = 3;
        display(() -> n + 10);
        display(() -> n + 100);
        
        List<String> list =Arrays.asList("John","smith","robert");//,”ned”,”ramesh”); 
        List<String> list2=Arrays.asList("Ned","Stark");
        
        List<List<String>> list3=new ArrayList<>();
        list3.add(list);
        list3.add(list2);
		String concatString =list3.stream().flatMap(array-> array.stream()).map(String::toUpperCase).collect(Collectors.joining(","));
		//String concatString =list3.stream().flatMap(pList -> pList.stream()).map(x->x).collect(Collectors.joining(","));

		System.out.println("joined Strings " + concatString);
		  String word ="Helloworld";
		    
		 String newword=Stream.of(word).map(String::toUpperCase).reduce("",(a,b)->a+b);
		  System.out.println(newword);//.get());
    
		  StringBuilder demo2= new StringBuilder("Hello");
		  demo2.append("world");System.out.println(demo2);
   
	}

}
